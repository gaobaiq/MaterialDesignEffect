package com.gaobaiq.mdeffect.base

/**
 * Description:
 * Author: gaobaiqiang
 * 2018/3/8 下午4:50.
 */
abstract class BasePresenter<T> {
    var mView: T? = null

    /** 绑定view */
    fun attach(view: T) {
        this.mView = view
    }

    /** 解绑，资源回收 */
    fun detach() {
        mView?.let {
            mView = null
        }
    }
}