package smir.shitab.shitabssuperapp.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import android.content.Context.CONNECTIVITY_SERVICE
import android.os.Build

class NetworkUtil {

    companion object {

        fun isNetworkConnected(context: Context): Boolean {
            val conMgr = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            /** WIFI Network:  */
            val wifi = conMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI)

            /** Cellular Network:  */
            val mobile = conMgr
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
            if (wifi!!.isAvailable && wifi.isConnected) {
                Log.e("WIFI_CONNECTED", "WIFI Connected:" + NetworkInfo.State.CONNECTED)
                return true
            }

            /** Any Other Network:  */
            else if (mobile != null && mobile.isAvailable && mobile.isConnected) {
                Log.e("CELLULAR_NET_CONNECTED", "CELLULAR Connected:" + NetworkInfo.State.CONNECTED)
                return true
            } else if (conMgr.activeNetworkInfo != null && conMgr.activeNetworkInfo!!.isAvailable && conMgr.activeNetworkInfo!!.isConnected) {
                Log.e("ANY_NET_CONNECTED", "ANY NETWORK Connected:" + NetworkInfo.State.CONNECTED)
                return true
            }
            Log.e("NO_NET_CONNECTED", "NO NETWORK Connected:")
            return false
        }

        fun getUploadSpeedInKbps(context: Context): Int {
            try {
                val cm: ConnectivityManager? =
                    context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager?
                val nc = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    cm?.getNetworkCapabilities(cm.activeNetwork)
                } else {
                    // TODO("VERSION.SDK_INT < M")
                    return 1
                }
//                val downSpeed: Int? = nc?.linkDownstreamBandwidthKbps
                val upSpeed: Int? = nc?.linkUpstreamBandwidthKbps
                Log.e("UploadSpeed", "Upload Speed: $upSpeed")
                return upSpeed ?: 0
            } catch (e: Exception) {
                return 0
            }
        }

        fun getDownloadSpeedInKbps(context: Context): Int {
            try {
                val cm: ConnectivityManager? =
                    context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager?
                val nc = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    cm?.getNetworkCapabilities(cm.activeNetwork)
                } else {
                    // TODO("VERSION.SDK_INT < M")
                    return 1
                }
                val downSpeed: Int? = nc?.linkDownstreamBandwidthKbps
//                val upSpeed: Int? = nc?.linkUpstreamBandwidthKbps
                Log.e("DownloadSpeed", "Download Speed: $downSpeed")
                return downSpeed ?: 0
            } catch (e: Exception) {
                return 0
            }
        }

    }
}