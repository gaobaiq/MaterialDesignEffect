package com.gaobaiq.mdeffect.base

/**
 * Description:
 * Author: gaobaiqiang
 * 2018/3/8 下午4:52.
 */
interface BaseView {
    /**
     * 错误提示
     *
     * @param errMsg
     * @param isShow 是否toast提示，默认提示
     * */
    fun loadErr(errMsg: String, isShow: Boolean = true)
}