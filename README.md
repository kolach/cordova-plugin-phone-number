# Cordova PhoneNumber plugin for Android

Gets the number of the phone.
It should work if the phone number is available on Settings -> About Phone -> Status -> My phone number.

## Installation

### With cordova-cli

If you are using [cordova-cli](https://github.com/apache/cordova-cli), install
with:

    cordova plugin add https://github.com/kolach/cordova-plugin-phone-number.git

## Use from Javascript

Works with Angular only:

    cordova.getPhoneNumber(function (number) {
        alert(number);
    });

    cordova.getNetworkCountryCode(function (countryCode) {
        alert(countryCode);
    });

    cordova.getSimCountryCode(function (countryCode) {
        alert(countryCode);
    });

## Credits

Written by [Nick Chistyakov](https://github.com/kolach) at
[AssuredLabor](http://assuredlabor.com/)

Code based on the following posts:

* [macdonst/TelephoneNumberPlugin](https://github.com/macdonst/TelephoneNumberPlugin)
* [vliesaputra/DeviceInformationPlugin](https://github.com/vliesaputra/DeviceInformationPlugin)
* [Stackoverflow](http://stackoverflow.com/questions/23839686/get-the-user-phone-number-with-cordova-phonegap)
