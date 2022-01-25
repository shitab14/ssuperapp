package smir.shitab.shitabssuperapp.common

import android.util.Log
import smir.shitab.shitabssuperapp.BuildConfig

class DebugingUtil {
    companion object {

        fun logVerbose(tag: String, verboseMsg: String) {
            if (BuildConfig.DEBUG) {
                Log.v(tag, verboseMsg)
            }
        }

        fun logDebug(tag: String, debugMsg: String) {
            if (BuildConfig.DEBUG) {
                Log.d(tag, debugMsg)
            }
        }
        fun logInfo(tag: String, info: String) {
            if (BuildConfig.DEBUG) {
                Log.i(tag, info)
            }
        }
        fun logWarning(tag: String, warning: String) {
            if (BuildConfig.DEBUG) {
                Log.w(tag, warning)
            }
        }
        fun logError(tag: String, error: String) {
            if (BuildConfig.DEBUG) {
                Log.e(tag, error)
            }
        }

    }
}