package com.gaobaiq.mdeffect.base

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gaobaiq.mdeffect.R
import timber.log.Timber

/**
 * Description:
 * Author: gaobaiqiang
 * 2018/3/8 下午4:49.
 */
abstract class BaseActivity<V, T: BasePresenter<V>>: AppCompatActivity() {

    open var mContext: Context? = null
    open var isRunning: Boolean = false

    open var mPresenter: T? = null

    private val fragments: MutableList<BaseFragment<*, *>> = ArrayList()
    private var mCurrFragment: BaseFragment<*, *>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(layoutId)

        mContext = this
        BaseApplication.mAppManager?.addActivity(this)

        if (mPresenter == null) {
            mPresenter = initPresenter()
        }
        mPresenter?.attach(this as V)

        isRunning = true

        initViewAndData()
    }

    fun addFragment(fragment: BaseFragment<*, *>?) {
        if (fragment != null) {
            if (!fragments.contains(fragment)) {
                fragments.add(fragment)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detach()
        BaseApplication.mAppManager?.killActivity(this)
        isRunning = false

        for (fragment: BaseFragment<*, *> in fragments) {
            detach(fragment)
        }
        fragments.clear()
    }

    private fun detach(fragment: BaseFragment<*, *>?) {
        if (fragments.contains(fragment)) {
            fragment?.detach()
        }
    }

    fun remove(fragment: BaseFragment<*, *>?) {
        if (fragments.contains(fragment)) {
            fragments.remove(fragment)
        }
    }

    protected open fun replaceFragment(toFragment: BaseFragment<*, *>?, containerId: Int, isAnim: Boolean) {
        if (toFragment == null) {
            Timber.w("将要替换的fragment不存在")
            return
        }
        replaceFragment(toFragment, containerId, isAnim, R.anim.left_right_in, R.anim.left_right_out)
    }

    /**
     * 改变当前的fragment
     *
     * @param toFragment    需要加载的fragment
     * @param containerId   fragment的布局容器id
     * @param isAnim        是否需要切换动画
     */
    protected open fun replaceFragment(toFragment: BaseFragment<*, *>, containerId: Int, isAnim: Boolean, inAnim: Int, outAnim: Int) {
        val ft = supportFragmentManager.beginTransaction()
        if (isAnim) {
            ft.setCustomAnimations(inAnim, outAnim)
        }
        val toTag: String = toFragment::class.java.simpleName
        if (mCurrFragment != null) {
            ft.hide(mCurrFragment)
        }
        if (!toFragment.isAdded()) {
            ft.add(containerId, toFragment, toTag)
        } else {
            ft.show(toFragment)
        }
        ft.commitAllowingStateLoss()
        mCurrFragment = toFragment
    }

    /** 模版方法，通过该方法获取该Activity的view的layoutId */
    protected abstract val layoutId: Int

    /** 实例化presenter */
    protected abstract fun initPresenter(): T?

    /** 初始化界面和数据 */
    protected abstract fun initViewAndData()

}