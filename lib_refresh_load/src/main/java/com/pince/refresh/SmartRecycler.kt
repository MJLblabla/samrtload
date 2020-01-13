package com.pince.refresh

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshHeader


/**
 * 刷新分页控制
 */
class SmartRecycler:FrameLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    var recyclerView: RecyclerView

    private  var smartRefreshLayout: SmartRefreshLayout
    private  var flRecyContent:FrameLayout
    private lateinit var smartRefreshHelper:SmartRefreshHelper<*>


    init {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_refresh_recyclerview,this,false)
        recyclerView = view.findViewById(R.id.recyclerView)
        flRecyContent = view.findViewById(R.id.flRecyContent)
        smartRefreshLayout = view.findViewById(R.id.refreshLayout)
        addView(view)
    }

    fun setReFreshHearfer(refreshHeader: RefreshHeader){
        smartRefreshLayout.setRefreshHeader(refreshHeader)
    }

    fun startRefresh(){
        smartRefreshHelper.refresh()
    }



    /**
     * 初始化
     */
    fun setUp(adapter: BaseQuickAdapter<*, *> , emptyView:IEmptyView?=null,preLoadNumber: Int=1,loadmoreNeed:Boolean=true,refreshNeed:Boolean=true,fetcherFuc: (page: Int) -> Unit){
        emptyView?.let {
            flRecyContent.addView(it.contentView)
        }
        recyclerView.adapter = adapter
        smartRefreshHelper = SmartRefreshHelper(adapter,recyclerView,smartRefreshLayout,emptyView,preLoadNumber,loadmoreNeed,refreshNeed,fetcherFuc)
    }

}