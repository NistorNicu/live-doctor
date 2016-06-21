'use strict';

angular.module('livedoctorapp.doctor.dashbord', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/doctor/dashbord', {
            templateUrl: 'doctor/doctor.dashbord.view.html',
            controller: 'DoctorDashboardCtrl'
        });

    }])

    .controller('DoctorDashboardCtrl', ['$scope', '$http', "appConstants", '$rootScope', function ($scope, $http, appConstants, $rootScope) {
        $scope.stateData = "Doctor dashboard";
        var session = OT.initSession(appConstants.OTApiKey, appConstants.sID);
        var token = appConstants.docToken;
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
        $scope.subscribeToDoctor();
    }]);
