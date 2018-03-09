package com.gaobaiq.mdeffect.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Description:
 * Author: gaobaiqiang
 * 2018/3/8 下午4:59.
 */
abstract class BaseFragment<V, T: BasePresenter<V>>: Fragment() {
    /** 视图是否已经初初始化 */
    private var isInit = false
    private var isLoad = false
    open var mContext: Context? = null
    open var mView: View? = null
    open var isInFragment: Boolean = false
    open var mPresenter: T? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (mPresenter == null) {
            mPresenter = initPresenter()
        }
        mPresenter?.attach(this as V)

        if (activity is BaseActivity<*, *>) {
            val activity = activity as BaseActivity<*, *>?
            activity!!.addFragment(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isInFragment = true
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mView == null) {
            mView = inflater.inflate(layoutId, container, false)
        }
        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (!isInit) {
            initViewAndData()
            isInit = true

            // 初始化的时候去加载数据
            isCanLoadData()
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        isCanLoadData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isInit = false
        isLoad = false
    }

    override fun onDetach() {
        super.onDetach()
        isInFragment = false
    }

    /**
     * 是否可以加载数据
     * 可以加载数据的条件：
     * 1.视图已经初始化
     * 2.视图对用户可见
     */
    private fun isCanLoadData() {
        if (!isInit) {
            return
        }
        if (userVisibleHint) {
            beginLoad()
            isLoad = true
        } else {
            if (isLoad) {
                stopLoad()
            }
        }
    }

    fun detach() {
        mPresenter?.detach()
    }

    /** 模版方法，通过该方法获取该fragment的view的layoutId */
    protected abstract val layoutId: Int

    /**实例化presenter*/
    protected abstract fun initPresenter(): T?

    /** 模版方法，在activity初始化之后调用 */
    protected abstract fun initViewAndData()

    /** 当视图初始化并且对用户可见的时候去真正的加载数据 */
    protected abstract fun beginLoad()

    /** 当视图已经对用户不可见并且加载过数据，如果需要在切换到其他页面时停止加载数据，可以调用此方法 */
    protected open fun stopLoad() {

    }
}