'use strict';

angular.module('livedoctorapp.doctor', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/doctor', {
            templateUrl: 'doctor/doctor.enter.app.view.html',
            controller: 'DoctorEnterCtrl'
        });
    }])

    .controller('DoctorEnterCtrl', ['$scope', '$http', "appConstants", '$location', '$rootScope', function ($scope, $http, appConstants, $location, $rootScope) {
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
        loadResource(appConstants.doctorPath, "doctors");
        loadResource(appConstants.countryPath, "countries");
        loadResource(appConstants.languagePath, "languages");
        loadResource(appConstants.specializationPath, "specializations");

        $scope.signin = function (userId) {
            $rootScope.loggedPacientId = userId;
            $location.path("doctor/dashbord");
        };


        $scope.signupDoctor = function (newDoctorView) {
            $http.post(appConstants.rootUrl + appConstants.doctorPath,
                JSON.stringify(newDoctorView),
                {
                    headers: {'Access-Control-Allow-Origin': "*"}
                }).then(function succes(response) {
                console.log(response.data);
                $rootScope.loggedDoctorId = response.data.id;
                $location.path("doctor/dashbord");
            }, function errorFn(error) {
                console.log(error);
            });
        };
    }]);

