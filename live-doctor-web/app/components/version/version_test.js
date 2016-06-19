'use strict';

describe('livedoctorapp.version module', function() {
  beforeEach(module('livedoctorapp.version'));

  describe('version service', function() {
    it('should return current version', inject(function(version) {
      expect(version).toEqual('0.1');
    }));
  });
});
