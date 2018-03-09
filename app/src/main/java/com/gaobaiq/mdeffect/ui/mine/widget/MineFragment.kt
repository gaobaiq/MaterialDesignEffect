package com.gaobaiq.mdeffect.ui.mine.widget

import com.gaobaiq.mdeffect.R
import com.gaobaiq.mdeffect.base.BaseFragment
import com.gaobaiq.mdeffect.ui.mine.presenter.impl.MinePresenterImpl
import com.gaobaiq.mdeffect.ui.mine.view.IMineView

/**
 * Description:
 * Author: gaobaiqiang
 * 2018/3/9 上午10:21.
 */
class MineFragment: BaseFragment<IMineView, MinePresenterImpl>(), IMineView {
    override val layoutId: Int
        get() = R.layout.fragment_mine

    override fun initPresenter(): MinePresenterImpl? {
        return MinePresenterImpl()
    }

    override fun initViewAndData() {

    }

    override fun beginLoad() {

    }
}