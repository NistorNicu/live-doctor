'use strict';

// Declare app level module which depends on views, and components
angular.module('livedoctorapp', [
    'ngRoute',
    'livedoctorapp.pacient',
    'livedoctorapp.doctor',
    'livedoctorapp.pacient.dashbord'
]).constant("appConstants", {
    "rootUrl": "http://localhost:8080",
    "pacientPath": "/pacient",
    "countryPath": "/info/country",
    "languagePath": "/info/language",
    "specializationPath": "/info/specialization",
    "consultationPath": "/consultation"
}).config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $locationProvider.hashPrefix('!');

    //$routeProvider.otherwise({redirectTo: '/'});
}]);
