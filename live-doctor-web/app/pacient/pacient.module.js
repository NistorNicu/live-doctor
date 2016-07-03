'use strict';

angular.module('livedoctorapp.pacient', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/pacient', {
            templateUrl: 'pacient/pacient.enter.app.view.html',
            controller: 'PacientEnterController'
        });

    }])

    .controller('PacientEnterController', ['$scope', '$http', "appConstants", '$location', '$rootScope', 'localStorageService', function ($scope, $http, appConstants, $location, $rootScope, localStorageService) {
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
        $scope.pacients = [];
        loadResource(appConstants.pacientPath, "pacients");
        loadResource(appConstants.countryPath, "countries");
        loadResource(appConstants.languagePath, "languages");

        $scope.signin = function(userId){
            $rootScope.loggedPacientId = userId;
            localStorageService.set("loggedPacientId", userId);
            $location.path("pacient/dashbord");
        };


        $scope.signupPacient = function (newPacientView) {
            $http.post(appConstants.rootUrl + appConstants.pacientPath,
                JSON.stringify(newPacientView),
                {
                    headers: {'Access-Control-Allow-Origin': "*"}
                }).then(function succes(response) {
                console.log(response.data);
                $rootScope.loggedPacientId = response.data.id;
                localStorageService.set("loggedPacientId", response.data.id);
                $location.path("pacient/dashbord");
            }, function errorFn(error) {
                console.log(error);
            });
        };
    }]);