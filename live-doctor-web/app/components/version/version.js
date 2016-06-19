'use strict';

angular.module('livedoctorapp.version', [
  'livedoctorapp.version.interpolate-filter',
  'livedoctorapp.version.version-directive'
])

.value('version', '0.1');
