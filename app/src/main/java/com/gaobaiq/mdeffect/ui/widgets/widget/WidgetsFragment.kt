package com.gaobaiq.mdeffect.ui.widgets.widget

import com.gaobaiq.mdeffect.R
import com.gaobaiq.mdeffect.base.BaseFragment
import com.gaobaiq.mdeffect.ui.widgets.presenter.impl.WidgetsPresenterImpl
import com.gaobaiq.mdeffect.ui.widgets.view.IWidgetsView

/**
 * Description:
 * Author: gaobaiqiang
 * 2018/3/9 上午10:24.
 */
class WidgetsFragment: BaseFragment<IWidgetsView, WidgetsPresenterImpl>(), IWidgetsView {
    override val layoutId: Int
        get() = R.layout.fragment_widgets

    override fun initPresenter(): WidgetsPresenterImpl? {
        return WidgetsPresenterImpl()
    }

    override fun initViewAndData() {

    }

    override fun beginLoad() {

    }
}