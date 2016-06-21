'use strict';

// Declare app level module which depends on views, and components
angular.module('livedoctorapp', [
    'ngRoute',
    'livedoctorapp.pacient',
    'livedoctorapp.doctor',
    'livedoctorapp.pacient.dashbord',
    'livedoctorapp.doctor.dashbord'
]).constant("appConstants", {
    "rootUrl": "http://localhost:8080",
    "pacientPath": "/pacient",
    "countryPath": "/info/country",
    "languagePath": "/info/language",
    "specializationPath": "/info/specialization",
    "consultationPath": "/consultation",
    "doctorPath": "/doctor",
    "OTApiKey" : 45608962,
    "sID" : "2_MX40NTYwODk2Mn5-MTQ2NjI3MDU4MDY5NX5yaGd6NytnSnBiQlNQVHYrUHJ3VTNaRmx-fg",
    "docToken" : "T1==cGFydG5lcl9pZD00NTYwODk2MiZzaWc9NDYwOWZlMTRlMzRjMTEzNzU5MTFkYWIzODgxNTdiNGIzNTNkNzgyNzpzZXNzaW9uX2lkPTJfTVg0ME5UWXdPRGsyTW41LU1UUTJOakkzTURVNE1EWTVOWDV5YUdkNk55dG5TbkJpUWxOUVZIWXJVSEozVlROYVJteC1mZyZjcmVhdGVfdGltZT0xNDY2Mjc5ODI1Jm5vbmNlPTAuNTcxNTY3ODE2ODkyNjM4OCZyb2xlPXN1YnNjcmliZXImZXhwaXJlX3RpbWU9MTQ2ODg3MTgzMA==",
    "patToken" : "T1==cGFydG5lcl9pZD00NTYwODk2MiZzaWc9NDY4ZWRlYTU2NGYwNzBjNWQ3OGYwYTA3YTFhYTBmZTY3MTBlYWNlMjpzZXNzaW9uX2lkPTJfTVg0ME5UWXdPRGsyTW41LU1UUTJOakkzTURVNE1EWTVOWDV5YUdkNk55dG5TbkJpUWxOUVZIWXJVSEozVlROYVJteC1mZyZjcmVhdGVfdGltZT0xNDY2Mjc1Mjc4Jm5vbmNlPTAuMzMxNDMwODgzNjEyNDgzNzQmcm9sZT1wdWJsaXNoZXImZXhwaXJlX3RpbWU9MTQ2ODg2NzI4Mw=="
}).config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $locationProvider.hashPrefix('!');

    //$routeProvider.otherwise({redirectTo: '/'});
}]);
