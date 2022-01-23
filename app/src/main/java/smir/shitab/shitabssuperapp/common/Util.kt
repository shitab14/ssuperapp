package smir.shitab.shitabssuperapp.common

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

class Util {
    companion object {

        fun showToast(context: Context?, msg: String?) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }

        fun hideKeyboard(activity: Activity) {
            val imm =
                activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            var view = activity.currentFocus
            if (view == null) {
                view = View(activity)
            }
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }
}