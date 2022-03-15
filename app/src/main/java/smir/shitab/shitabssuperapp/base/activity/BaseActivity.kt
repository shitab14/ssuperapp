package smir.shitab.shitabssuperapp.base.activity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import smir.shitab.shitabssuperapp.R
import kotlin.properties.Delegates

abstract class BaseActivity<DataBinding: ViewDataBinding> : AppCompatActivity() {

    var dataBinding: DataBinding by Delegates.notNull()
    private val loaderDialog: AlertDialog by lazy {
        val builder = AlertDialog.Builder(this@BaseActivity, R.style.LoaderDialogTheme)
        val dialogView = LayoutInflater.from(applicationContext).inflate(R.layout.dialog_loader, null)
        builder.setView(dialogView)
        builder.setCancelable(false)
        return@lazy builder.create()
    }

    @get:LayoutRes
    abstract val layoutResourceId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        // AndroidInjection.inject(getActivity())
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(getActivity(), layoutResourceId)
    }

    fun getActivity(): AppCompatActivity = this

    fun getContext(): Context = this

    fun showLoader() {
        try {
            runOnUiThread {
                if (!loaderDialog.isShowing) loaderDialog.show()
            }
        } catch (e: Exception) {
            // todo Shitab
        }
    }

    fun hideLoader() {
        try {
            runOnUiThread {
                if (loaderDialog.isShowing) loaderDialog.dismiss()
            }
        } catch (e: Exception) {
            // todo Shitab
        }
    }

}