package com.gaobaiq.mdeffect.ui.main.widget

import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.gaobaiq.mdeffect.R
import com.gaobaiq.mdeffect.base.BaseActivity
import com.gaobaiq.mdeffect.ui.dialog.widget.DialogFragment
import com.gaobaiq.mdeffect.ui.main.presenter.impl.MainPresenterImpl
import com.gaobaiq.mdeffect.ui.main.view.IMainView
import com.gaobaiq.mdeffect.ui.mine.widget.MineFragment
import com.gaobaiq.mdeffect.ui.paper.widget.PaperFragment
import com.gaobaiq.mdeffect.ui.widgets.widget.WidgetsFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Description:
 * Author: gaobaiqiang
 * 2018/3/8 下午5:11.
 */
class MainActivity: BaseActivity<IMainView, MainPresenterImpl>(), IMainView {
    private var mPaperFragment: PaperFragment? = null
    private var mWidgetsFragment: WidgetsFragment? = null
    private var mDialogFragment: DialogFragment? = null
    private var mMineFragment: MineFragment? = null

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initPresenter(): MainPresenterImpl? {
        return MainPresenterImpl()
    }

    override fun initViewAndData() {
        toolbar.title = "纸片"
        initBottomTab()
    }

    private fun initBottomTab() {
        bottom_navigation_bar.setMode(BottomNavigationBar.MODE_FIXED)
        bottom_navigation_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        bottom_navigation_bar.isAutoHideEnabled = true

        val paperItem = BottomNavigationItem(R.drawable.icon_paper, "纸片")
        paperItem.setActiveColorResource(R.color.colorPrimary)
        paperItem.setInActiveColorResource(R.color.colorSubTitle)
        val widgetsItem = BottomNavigationItem(R.drawable.icon_widgets, "控件")
        widgetsItem.setActiveColorResource(R.color.colorPrimary)
        widgetsItem.setInActiveColorResource(R.color.colorSubTitle)
        val dialogItem = BottomNavigationItem(R.drawable.icon_dialog, "弹窗")
        dialogItem.setActiveColorResource(R.color.colorPrimary)
        dialogItem.setInActiveColorResource(R.color.colorSubTitle)
        val mineItem = BottomNavigationItem(R.drawable.icon_mine, "我的")
        mineItem.setActiveColorResource(R.color.colorPrimary)
        mineItem.setInActiveColorResource(R.color.colorSubTitle)
        bottom_navigation_bar.addItem(paperItem).addItem(widgetsItem).addItem(dialogItem).addItem(mineItem)
                .setFirstSelectedPosition(0).initialise()

        bottom_navigation_bar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabReselected(position: Int) {

            }

            override fun onTabUnselected(position: Int) {

            }

            override fun onTabSelected(position: Int) {
                when (position) {
                    0 -> {
                        toolbar.title = "纸片"
                        onPaperClick()
                    }
                    1 -> {
                        toolbar.title = "控件"
                        onWidgetsClick()
                    }
                    2 -> {
                        toolbar.title = "弹窗"
                        onDialogClick()
                    }
                    3 -> {
                        toolbar.title = "我的"
                        onMineClick()
                    }
                }
            }
        })

        onPaperClick()
    }

    override fun onPaperClick() {
        if (mPaperFragment == null) {
            mPaperFragment = PaperFragment()
        }
        replaceFragment(mPaperFragment, R.id.fragment_container, true)
    }

    override fun onWidgetsClick() {
        if (mWidgetsFragment == null) {
            mWidgetsFragment = WidgetsFragment()
        }
        replaceFragment(mWidgetsFragment, R.id.fragment_container, true)
    }

    override fun onDialogClick() {
        if (mDialogFragment == null) {
            mDialogFragment = DialogFragment()
        }
        replaceFragment(mDialogFragment, R.id.fragment_container, true)
    }

    override fun onMineClick() {
        if (mMineFragment == null) {
            mMineFragment = MineFragment()
        }
        replaceFragment(mMineFragment, R.id.fragment_container, true)
    }
}