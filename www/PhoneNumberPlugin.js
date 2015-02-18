var exec = require("cordova/exec");

module.exports = {
  getPhoneNumber: getPhoneNumber,
  getNetworkCountryCode: getNetworkCountryCode,
  getSimCountryCode: getSimCountryCode,
  getAll: getAll
};

var $q;

function q() {
    if (!$q) {
        var injector = angular.injector(["ng"]);
        $q = injector.get("$q");
    }
    return $q;
}

function getDeferred() {
  return q().defer();
}

function execute(command, args) {
  var deferred = getDeferred();
  exec(deferred.resolve, deferred.reject, "PhoneNumber", command, args);
  return deferred.promise;
}

function getPhoneNumber() {
  return execute("getPhoneNumber", []);
}

function getNetworkCountryCode() {
  return execute("getNetworkCountryCode", []);
}

function getSimCountryCode() {
  return execute("getSimCountryCode", []);
}

function getAll() {
    return q().all({
        phoneNumber         : pn.getPhoneNumber(),
        networkCountryCode  : pn.getNetworkCountryCode(),
        simCountryCode      : pn.getSimCountryCode()
    });
}