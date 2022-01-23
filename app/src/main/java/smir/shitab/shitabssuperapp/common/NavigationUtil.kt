package smir.shitab.shitabssuperapp.common

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

class NavigationUtil {
    companion object {

        fun goToNextActivity(
            context: Context,
            //bundle: Bundle?,
            targetActivity: Class<out Activity?>?
        ) {
            val intent = Intent(context, targetActivity)
            //intent.putExtras(bundle!!)
            context.startActivity(intent)
        }

        fun goToNextActivityWithBundle(
            context: Context,
            bundle: Bundle,
            targetActivity: Class<out Activity?>?
        ) {
            val intent = Intent(context, targetActivity)
            intent.putExtras(bundle)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
        }

        fun goToNextActivityWithBundleWithoutClearing(
            context: Context,
            bundle: Bundle?,
            targetActivity: Class<out Activity?>?
        ) {
            val intent = Intent(context, targetActivity)
            intent.putExtras(bundle!!)
            context.startActivity(intent)
        }

        fun goToNextActivityWithFlag(
            context: Context,
            flag: Int,
            targetActivity: Class<out Activity?>?
        ) {
            val intent = Intent(context, targetActivity)
            intent.flags = flag
            context.startActivity(intent)
        }

        fun goToNextActivityByClearingHistory(
            context: Context,
            targetActivity: Class<out Activity?>?
        ) {
            val intent = Intent(context, targetActivity)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
        }

        fun goToNextActivityWithBundleByClearingHistory(
            context: Context,
            bundle: Bundle?,
            targetActivity: Class<out Activity?>?
        ) {
            val intent = Intent(context, targetActivity)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.putExtras(bundle!!)
            context.startActivity(intent)
        }

        fun goToPreviousActivityWithoutBundle(
            context: Context,
            targetActivity: Class<out Activity?>?
        ) {
            (context as Activity).finish()
            val intent = Intent(context, targetActivity)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)
        }

        fun goToPreviousActivityWithBundle(
            context: Context,
            bundle: Bundle,
            targetActivity: Class<out Activity?>?
        ) {
            (context as Activity).finish()
            val intent = Intent(context, targetActivity)
            intent.putExtras(bundle)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)
        }


    }
}