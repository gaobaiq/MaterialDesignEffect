package com.gaobaiq.mdeffect.ui.widget

import com.gaobaiq.mdeffect.R
import com.gaobaiq.mdeffect.base.BaseActivity
import com.gaobaiq.mdeffect.ui.presenter.impl.MainPresenterImpl
import com.gaobaiq.mdeffect.ui.view.IMainView

/**
 * Description:
 * Author: gaobaiqiang
 * 2018/3/8 下午5:11.
 */
class MainActivity: BaseActivity<IMainView, MainPresenterImpl>(), IMainView {
    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initPresenter(): MainPresenterImpl? {
        return MainPresenterImpl()
    }

    override fun initViewAndData() {

    }
}