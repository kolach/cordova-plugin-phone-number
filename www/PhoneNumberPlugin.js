var exec = require("cordova/exec");

module.exports = {
  getPhoneNumber: getPhoneNumber,
  getNetworkCountryCode: getNetworkCountryCode,
  getSimCountryCode: getSimCountryCode
};

function getDeferred() {
  var injector = angular.injector(["ng"]);
  var $q = injector.get("$q");
  return $q.defer();
}

function execute(command, args) {
  var deferred = getDeferred();
  exec(deferred.resolve, deferred.reject, "PhoneNumber", command, args);
  return deferred.promise;
}

function getPhoneNumber(token) {
  return execute("getPhoneNumber", []);
}

function getNetworkCountryCode(token) {
  return execute("getNetworkCountryCode", []);
}

function getSimCountryCode(token) {
  return execute("getSimCountryCode", []);
}
