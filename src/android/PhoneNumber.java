package com.assuredlabor.cordova;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PackageManager;

import android.content.Context;
import android.telephony.TelephonyManager;

public class PhoneNumber extends CordovaPlugin {


	/**
	 * Actions the HockeyAppPlugin can parse.
	 */
	public enum DefinedAction {
		getPhoneNumber, 		// registers HockeyApp with tocken
		getNetworkCountryCode, 	// crash report
		getSimCountryCode       // show feedback
	};


	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

		DefinedAction definedAction = DefinedAction.valueOf(action);
		TelephonyManager telephonyManager =
				(TelephonyManager) this.cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);

		switch (definedAction) {
			case getPhoneNumber:
				String result = telephonyManager.getLine1Number();
				callbackContext.success(result);
				break;

			case getNetworkCountryCode:
				String result = telephonyManager.getNetworkCountryIso();
				callbackContext.success(result);
				break;

			case getSimCountryCode:
				String result = telephonyManager.getSimCountryIso();
				callbackContext.success(result);
				break;
		}

		return true;
	}

}
