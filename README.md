**

聪明刷新控件 上下拉
----------
　可以理解为带上下拉的recycle
**


    public class SmartRecyclerView extends FrameLayout {
       
    　　　．．．．．．．．．
        /**
         * 获取　recyclerView
         * @return
         */
        public RecyclerView getRecyclerView() {
            return recyclerView;
        }
    
    
    
        /**
         * 设置刷新头样式
         * @param refreshHeader
         */
        public void setReFreshHearfer(RefreshHeader refreshHeader){
            smartRefreshLayout.setRefreshHeader(refreshHeader);
        }
    
        /**
         * 手动调用触发刷新
         */
        public void startRefresh(){
            smartRefreshHelper.refresh();
        }
    
        /**
         * 告诉view获取失败
         */
        public void onFetchDataError(){
            smartRefreshHelper.refresh();
        }
        /**
         * 请求成功　smartRefreshHelper处理页数记录空视图的显示
         */
        public void onFetchDataFinish(List data,  Boolean  goneIfNoData){
            smartRefreshHelper.onFetchDataFinish(data ,goneIfNoData);
        }
    
        /**
         * 初始化
         *
         * @param emptyView 空视图
         * @param adapter  适配器
         *@param preLoadNumber 静默加载滑到倒数第几个开始
         * @param fetcherFuc 刷新事件页回调　0开始
         */
        public void setUp (BaseQuickAdapter adapter, IEmptyView emptyView
                , int preLoadNumber,Boolean loadmoreNeed, Boolean refreshNeed
    
               , Function1<Integer,Unit>  fetcherFuc
        ){
            if(emptyView!=null){
                flRecyContent.addView(emptyView.getContentView());
            }
    
            recyclerView.setAdapter(adapter);
            smartRefreshHelper = new SmartRefreshHelper(adapter,recyclerView,smartRefreshLayout,emptyView,preLoadNumber,loadmoreNeed,refreshNeed,fetcherFuc);
        }
    
    
    
    
    
    }


