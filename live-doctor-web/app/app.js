'use strict';

// Declare app level module which depends on views, and components
angular.module('livedoctorapp', [
  'ngRoute',
  'livedoctorapp.pacient',
  'livedoctorapp.doctor',
  'livedoctorapp.version'
]).
    constant("myConfig", {
        "rootUrl": "http://localhost:8080"
    }).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  //$routeProvider.otherwise({redirectTo: '/pacient'});
}]);
