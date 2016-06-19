'use strict';

angular.module('livedoctorapp.pacient', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/pacient', {
    templateUrl: 'pacient/pacient.enter.app.view.html',
    controller: 'PacientEnterController'
  });

}])

.controller('PacientController', ['$scope', function($scope) {
  $scope.data = "Hello angular";
  $scope.startPublish = function(){
    var session = OT.initSession(45608962, "2_MX40NTYwODk2Mn5-MTQ2NjI3MDU4MDY5NX5yaGd6NytnSnBiQlNQVHYrUHJ3VTNaRmx-fg");
    var token = "T1==cGFydG5lcl9pZD00NTYwODk2MiZzaWc9NDY4ZWRlYTU2NGYwNzBjNWQ3OGYwYTA3YTFhYTBmZTY3MTBlYWNlMjpzZXNzaW9uX2lkPTJfTVg0ME5UWXdPRGsyTW41LU1UUTJOakkzTURVNE1EWTVOWDV5YUdkNk55dG5TbkJpUWxOUVZIWXJVSEozVlROYVJteC1mZyZjcmVhdGVfdGltZT0xNDY2Mjc1Mjc4Jm5vbmNlPTAuMzMxNDMwODgzNjEyNDgzNzQmcm9sZT1wdWJsaXNoZXImZXhwaXJlX3RpbWU9MTQ2ODg2NzI4Mw=="
    session.connect(token, function(error) {
      if (error) {
        console.log(error.message);
      } else {
        // This example assumes that a DOM element with the ID 'publisherElement' exists
        var publisherProperties = {width: 400, height:300, name:"Bob's stream"};
        var publisher = OT.initPublisher('publisher', publisherProperties);
        session.publish(publisher);
      }
    });
  };

}])
    .controller('PacientEnterController', ['$scope', function($scope){
      $.get(rootUrl + '/session', function(res) {


        initializeSession();
      });
        $scope.infoText = "Select a user";
    }]);