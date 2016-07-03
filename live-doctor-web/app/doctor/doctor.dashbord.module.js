'use strict';

angular.module('livedoctorapp.doctor.dashbord', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/doctor/dashbord', {
            templateUrl: 'doctor/doctor.dashbord.view.html',
            controller: 'DoctorDashboardCtrl'
        });

    }])

    .controller('DoctorDashboardCtrl', ['$scope', '$http', "appConstants", '$rootScope', 'localStorageService','$mdDialog', '$mdMedia', function ($scope, $http, appConstants, $rootScope, localStorageService, $mdDialog, $mdMedia) {
        $scope.stateData = "Doctor dashboard";
        var session = OT.initSession(appConstants.OTApiKey, appConstants.sID);
        var token = appConstants.docToken;
        var sock;
        var stompClient;

        $scope.startConsulting = function (sessionId, connToken) {
            var session = OT.initSession(appConstants.OTApiKey, sessionId);
            session.connect(connToken, function (error) {
                if (error) {
                    console.log(error.message);
                } else {
                    var publisherProperties = {width: 400, height: 300, insertMode: "replace"};
                    var publisher = OT.initPublisher('chatForm', publisherProperties);
                    session.publish(publisher);
                }
            });
        };

        $scope.showNewConsultationDialog = function(data) {
            // Appending dialog to document.body to cover sidenav in docs app
            var confirm = $mdDialog.confirm()
                .title('Would you like to delete your debt?')
                .textContent('All of the banks have agreed to forgive you your debts.')
                .ariaLabel('Lucky day')
                .ok('Please do it!')
                .cancel('Sounds like a scam');
            $mdDialog.show(confirm).then(function() {
                console.log('You decided to get rid of your debt.');
                $scope.startConsulting(data.sessionId, data.connToken);
            }, function() {
                console.log('You decided to keep your debt.');
            });
        };

        $scope.subscribeToDoctor = function () {
            session.on('streamCreated', function (event) {
                var subscriberProperties = {width: 400, height: 300, insertMode: 'replace'};
                var subscriber = session.subscribe(event.stream,
                    'chatForm',
                    subscriberProperties,
                    function (error) {
                        if (error) {
                            console.log(error);
                        } else {
                            console.log('Subscriber added.');
                            //$scope.stateData = "Consultation in progress";
                        }
                    });
            });


            session.connect(token, function (error) {
                if (error) {
                    console.log(error);
                }
            });
        };
        $scope.buildLoginMess = function (){
            var id = localStorageService.get("loggedDoctorId");
            return JSON.stringify({senderId : id, actor : "doctor", action : "login"})
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
                $scope.showNewConsultationDialog(e.data);

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
    }]);
