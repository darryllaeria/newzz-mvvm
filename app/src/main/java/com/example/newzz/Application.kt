package com.example.newzz

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.example.newzz.base.extension.applyLocale
import com.example.newzz.base.manager.PrefsManager
import com.example.newzz.base.utils.AppLog
import com.example.newzz.base.utils.ConfigHelper
import leakcanary.AppWatcher
import leakcanary.ObjectWatcher
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Application : Application(), LifecycleObserver {

    // MARK: - Companion Object
    companion object {
        private val TAG = Application::class.java.simpleName
    }

    // MARK: - Private Constants
    private val prefMan: PrefsManager by inject()

    // MARK: - Application level lifecycle events
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onEnteredForeground() {
        AppLog.d(TAG, "Application did enter foreground")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onEnteredBackground() {
        AppLog.d(TAG, "Application did enter background")
    }

    // MARK: - Override Functions
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base.applyLocale())
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        applyLocale()
        super.onConfigurationChanged(newConfig)
    }

    override fun onCreate() {
        super.onCreate()
        applyLocale()
        initDependencies()
        ConfigHelper.applyTheme(PrefsManager.getInstance(this).getBool("mode", false))
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        val objectWatcher: ObjectWatcher = AppWatcher.objectWatcher
    }

    // MARK: - Private Functions
    private fun initDependencies() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@Application)
            modules(getModule())
        }
    }
}