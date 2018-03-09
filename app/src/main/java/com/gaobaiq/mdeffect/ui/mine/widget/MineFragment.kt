package com.gaobaiq.mdeffect.ui.other.widget

import com.gaobaiq.mdeffect.R
import com.gaobaiq.mdeffect.base.BaseFragment
import com.gaobaiq.mdeffect.ui.other.presenter.impl.OtherPresenterImpl
import com.gaobaiq.mdeffect.ui.other.view.IOtherView

/**
 * Description:
 * Author: gaobaiqiang
 * 2018/3/9 上午10:21.
 */
class OtherFragment: BaseFragment<IOtherView, OtherPresenterImpl>(), IOtherView {
    override val layoutId: Int
        get() = R.layout.fragment_other

    override fun initPresenter(): OtherPresenterImpl? {
        return OtherPresenterImpl()
    }

    override fun initViewAndData() {

    }

    override fun beginLoad() {

    }
}