'use strict';

angular.module('livedoctorapp.pacient.dashbord', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/pacient/dashbord', {
            templateUrl: 'pacient/pacient.dashbord.view.html',
            controller: 'PacientDashbordCtrl'
        });

    }])

    .controller('PacientDashbordCtrl', ['$scope', '$http', "appConstants", '$rootScope', function ($scope, $http, appConstants, $rootScope) {
        $scope.showWaitingPanel = false;
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
        loadResource(appConstants.specializationPath, 'spacializations');

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
                $scope.startConsultation();
                $scope.showWaitingPanel = true;
            }, function errorFn(error) {
                console.log(error);
            });
        };
    }]);

