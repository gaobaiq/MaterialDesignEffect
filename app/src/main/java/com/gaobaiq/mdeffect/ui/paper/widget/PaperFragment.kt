package com.gaobaiq.mdeffect.ui.paper.widget

import com.gaobaiq.mdeffect.R
import com.gaobaiq.mdeffect.base.BaseFragment
import com.gaobaiq.mdeffect.ui.paper.presenter.impl.PaperPresenterImpl
import com.gaobaiq.mdeffect.ui.paper.view.IPaperView
import kotlinx.android.synthetic.main.layout_paper_i.*
import timber.log.Timber

/**
 * Description:
 * Author: gaobaiqiang
 * 2018/3/9 上午10:23.
 */
class PaperFragment: BaseFragment<IPaperView, PaperPresenterImpl>(), IPaperView {
    override val layoutId: Int
        get() = R.layout.fragment_paper

    override fun initPresenter(): PaperPresenterImpl? {
        return PaperPresenterImpl()
    }

    override fun initViewAndData() {
        btn_paper_i_action_1.setOnClickListener { Timber.e("click i") }

        paper_i.setOnClickListener { Timber.e("click ii") }
    }

    override fun beginLoad() {

    }
}