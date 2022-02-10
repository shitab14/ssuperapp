package smir.shitab.shitabssuperapp.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<DataBinding: ViewDataBinding> : Fragment(){

    private var _dataBinding: DataBinding? = null
    val dataBinding get() = _dataBinding!!

    @get:LayoutRes
    abstract val layoutResourceId: Int

    override fun onAttach(context: Context) {
        // AndroidSupportInjection.inject(getFragment())
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _dataBinding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
        return dataBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _dataBinding = null
    }

    fun getFragment(): Fragment = this
}