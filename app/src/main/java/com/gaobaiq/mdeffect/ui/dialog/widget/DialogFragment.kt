package com.gaobaiq.mdeffect.ui.dialog.widget

import com.gaobaiq.mdeffect.R
import com.gaobaiq.mdeffect.base.BaseFragment
import com.gaobaiq.mdeffect.ui.dialog.presenter.impl.DialogPresenterImpl
import com.gaobaiq.mdeffect.ui.dialog.view.IDialogView

/**
 * Description: 弹窗有关
 * Author: gaobaiqiang
 * 2018/3/9 上午10:15.
 */
class DialogFragment: BaseFragment<IDialogView, DialogPresenterImpl>(), IDialogView {
    override val layoutId: Int
        get() = R.layout.fragment_dialog

    override fun initPresenter(): DialogPresenterImpl? {
        return DialogPresenterImpl()
    }

    override fun initViewAndData() {

    }

    override fun beginLoad() {

    }
}