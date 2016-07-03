'use strict';

angular.module('livedoctorapp.pacient.dashbord', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/pacient/dashbord', {
            templateUrl: 'pacient/pacient.dashbord.view.html',
            controller: 'PacientDashbordCtrl'
        });

    }])

    .controller('PacientDashbordCtrl', ['$scope', '$http', "appConstants", '$rootScope', 'localStorageService', function ($scope, $http, appConstants, $rootScope, localStorageService) {
        $scope.showWaitingPanel = false;
        var sock;
        var loadResource = function (resoursePath, containerModel) {
            $http.get(appConstants.rootUrl + resoursePath,
                {
                    headers: {'Access-Control-Allow-Origin': "*"}
                }).then(function succes(response) {
                console.log(response.data);
                $scope[containerModel] = response.data;
            }, function errorFn(error) {
                console.log(error);
            });
        };
        $scope.startConsultation = function () {
            var session = OT.initSession(appConstants.OTApiKey, appConstants.sID);
            var token = appConstants.patToken;
            session.connect(token, function (error) {
                if (error) {
                    console.log(error.message);
                } else {
                    var publisherProperties = {width: 400, height: 300, insertMode: "replace"};
                    var publisher = OT.initPublisher('chatForm', publisherProperties);
                    session.publish(publisher);
                }
            });
        };

        $scope.connectToSession = function(sessionId, token){
            var session = OT.initSession(appConstants.OTApiKey, sessionId);
            session.on("streamCreated", function(event) {
                // streamContainer is a DOM element
                var subscriberProperties = {width: 400, height: 300, insertMode: 'replace'};
                session.session.subscribe(event.stream,
                    'chatForm',
                    subscriberProperties,
                    function (error) {
                        if (error) {
                            console.log(error);
                        } else {
                            console.log('Subscriber added.');
                        }
                    });
            }).connect(token, function (error) {
                if (error) {
                    console.log(error.message);
                } else {
                    console.log("connected to session : " + sessionId +  " with token : " + token);
                }
            });
        };
        loadResource(appConstants.specializationPath, 'spacializations');

        $scope.buildLoginMess = function (){
            var id = localStorageService.get("loggedPacientId");
            return JSON.stringify({senderId : id, actor : "pacient", action : "login"});
        };
        $scope.buildReqConsultationMess = function(doctorId){
            var id = localStorageService.get("loggedPacientId");
          return  JSON.stringify({senderId : id,
                                  actor : "pacient",
                                  action : "requestConsultation",
                                 destinatarId : doctorId,
                                 sessionId :localStorageService.get("sessionId"),
                                    doctorToken :localStorageService.get("docotrToken") });
        };

        $scope.sendNotification = function (doctorId){
            $scope.sendMessage($scope.buildReqConsultationMess(doctorId));
        };

        $scope.requestConsultation = function (specializationId) {
            var newConsultationView = {};
            newConsultationView.specializationId = specializationId;
            newConsultationView.pacientId = $rootScope.loggedPacientId;
            console.log('POST :' + appConstants.rootUrl + appConstants.consultationPath);
            $http.post(appConstants.rootUrl + appConstants.consultationPath,
                JSON.stringify(newConsultationView),
                {
                    headers: {'Access-Control-Allow-Origin': "*"}
                }).then(function succes(response) {
                console.log(response.data);
                $scope.availableDoctors = response.data.availableDoctors;
                localStorageService.set("availableDoctors", response.data.availableDoctors);
                localStorageService.set("sessionId", response.data.sessionId);
                localStorageService.set("pacientToken", response.data.pacientToken);
                localStorageService.set("docotrToken", response.data.docotrToken);
                $scope.connectToSession(response.data.sessionId, response.data.pacientToken);
                //$scope.startConsultation();
                //$scope.showWaitingPanel = true;
            }, function errorFn(error) {
                console.log(error);
            });
        };

        //$scope.subscribeToDoctor();
        $scope.registerToMessageEndpiont = function (){
            sock = new SockJS('http://localhost:8080/consultations');
            //stompClient = Stomp.over(sock);
            //
            //stompClient.connect({}, function(frame) {
            //    console.log(frame);
            //    stompClient.subscribe("http://localhost:8080/topic/consultations", function(message){
            //        console.log("Recived: " + message);
            //    });
            //}, function (error){
            //   console.log("STOMP protocol error " + error);
            //});

            sock.onopen = function() {
                console.log('open');
                $scope.sendMessage($scope.buildLoginMess());
            };
            sock.onmessage = function(e) {
                console.log('message', e.data);
            };
            sock.onclose = function() {
                console.log('close');
            };
            $scope.stompClient = sock;
        };
        $scope.sendMessage = function(message){

            sock.send(message);
        };

        $scope.registerToMessageEndpiont();
        $scope.availableDoctors = localStorageService.get("availableDoctors");
        $scope.connectToSession(localStorageService.get("sessionId"), localStorageService.get("pacientToken"));
    }]);

