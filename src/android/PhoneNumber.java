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

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("getPhoneNumber")) {
			TelephonyManager telephonyManager =
					(TelephonyManager)this.cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
			String result = telephonyManager.getLine1Number();
			callbackContext.success(result);
			return true;
		}
		callbackContext.success("N/A");
		return false;
	}

}
