package com.gaobaiq.mdeffect.base

import android.support.annotation.IdRes

/**
 * Description:
 * Author: gaobaiqiang
 * 2018/3/8 下午4:58.
 */
interface BtnClickPresenter {
    fun onBtnClick(@IdRes viewId: Int)
}