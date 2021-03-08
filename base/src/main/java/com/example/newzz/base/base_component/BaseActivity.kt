package com.example.newzz.base.base_component

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.os.Messenger
import androidx.appcompat.app.AppCompatActivity
import com.example.newzz.base.extension.applyLocale
import com.example.newzz.base.extension.hasInternetConnection
import com.novoda.merlin.Merlin
import com.tapadoo.alerter.Alerter

abstract class BaseActivity : AppCompatActivity() {

    abstract var layoutId: Int
    private val merlin by lazy {
        Merlin.Builder()
            .withConnectableCallbacks()
            .withDisconnectableCallbacks()
            .build(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initView()
    }

    override fun onResume() {
        super.onResume()
        initEvent()
        initLogic()
    }

    override fun attachBaseContext(context: Context?) {
        super.attachBaseContext(context?.applyLocale())
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        applicationContext.applyLocale()
    }

    override fun onStop() {
        super.onStop()
        merlin.unbind()
    }

    open fun initView() {
    }

    open fun initEvent() {
        if (!hasInternetConnection()) {
            handleConnectionOff()
        }
        with(merlin) {
            bind()
            registerConnectable {
                handleConnectionBack()
            }
            registerDisconnectable {
                handleConnectionOff()
            }
        }
    }

    open fun initLogic() {}

    /**
     * @method Handle case connection gone
     */
    open fun handleConnectionOff() {}

    /**
     * @method Handle connection back
     */
    open fun handleConnectionBack() {
        Alerter.clearCurrent(this)
    }

    abstract fun getServerMessenger(): Messenger?

    abstract fun getClientMessenger(): Messenger?
}