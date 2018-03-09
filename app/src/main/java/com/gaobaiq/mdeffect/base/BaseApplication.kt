package com.gaobaiq.mdeffect.base

import android.app.Application
import com.gaobaiq.mdeffect.BuildConfig
import com.gaobaiq.mdeffect.utils.AppManager
import timber.log.Timber

/**
 * Description:
 * Author: gaobaiqiang
 * 2018/3/8 下午4:06.
 */
class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        mApplication = this
        mAppManager = AppManager.instance

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        var mApplication: BaseApplication? = null
        var mAppManager: AppManager? = null // Activity 管理器
    }
}