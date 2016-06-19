'use strict';

angular.module('livedoctorapp.version.version-directive', [])

.directive('appVersion', ['version', function(version) {
  return function(scope, elm, attrs) {
    elm.text(version);
    console.log(attrs.href);

  };
}]);
