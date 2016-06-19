'use strict';

angular.module('livedoctorapp.doctor', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/doctor', {
    templateUrl: 'doctor/doctor.dashbord.view.html',
    controller: 'DoctorCtrl'
  });
}])

.controller('DoctorCtrl', ["$scope", function($scope) {
  var session = OT.initSession(45608962, "2_MX40NTYwODk2Mn5-MTQ2NjI3MDU4MDY5NX5yaGd6NytnSnBiQlNQVHYrUHJ3VTNaRmx-fg");
  var token = "T1==cGFydG5lcl9pZD00NTYwODk2MiZzaWc9NDYwOWZlMTRlMzRjMTEzNzU5MTFkYWIzODgxNTdiNGIzNTNkNzgyNzpzZXNzaW9uX2lkPTJfTVg0ME5UWXdPRGsyTW41LU1UUTJOakkzTURVNE1EWTVOWDV5YUdkNk55dG5TbkJpUWxOUVZIWXJVSEozVlROYVJteC1mZyZjcmVhdGVfdGltZT0xNDY2Mjc5ODI1Jm5vbmNlPTAuNTcxNTY3ODE2ODkyNjM4OCZyb2xlPXN1YnNjcmliZXImZXhwaXJlX3RpbWU9MTQ2ODg3MTgzMA==";
  $scope.subscribeToDoctor = function(){
    session.on('streamCreated', function(event) {
      var subscriberProperties = {insertMode: 'replace'};
      var subscriber = session.subscribe(event.stream,
          'subscriber',
          subscriberProperties,
          function (error) {
            if (error) {
              console.log(error);
            } else {
              console.log('Subscriber added.');
            }
          });
    });


// Replace with your API key and token:
    session.connect(token, function (error) {
      if(error) {
        console.log(error);
      }
    });
  };
}]);