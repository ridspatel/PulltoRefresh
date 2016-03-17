package com.example.pulltorefreshdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import java.util.ArrayList;

public class ListActivity extends Activity {

    private RecyclerView itemsRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    private DataListAdapter dataListAdapter;
    private ArrayList<DataBean> dataList;
    private DataBean dataBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_list);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.mSwipeRefreshLayout);
        itemsRecyclerView = (RecyclerView) findViewById(R.id.itemsRecyclerView);
        linearLayoutManager = new LinearLayoutManager(ListActivity.this);
        itemsRecyclerView.setLayoutManager(linearLayoutManager);

        dataList = new ArrayList<DataBean>();


        bindAdapter();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Refresh items
                bindRefreshAdapter();
            }
        });
    }

    private void bindAdapter() {
        dataBean = new DataBean();
        dataBean.name = "Riddhi";
        dataBean.email = "riddhi@gmail.com";
        dataBean.address = "Odhav";
        dataBean.mobile = "1234567890";
        dataList.add(dataBean);

        dataBean = new DataBean();
        dataBean.name = "Swara";
        dataBean.email = "swara@gmail.com";
        dataBean.address = "Naroda";
        dataBean.mobile = "1234567890";
        dataList.add(dataBean);
         /* bind adapter */
        if (dataList != null && dataList.size() > 0) {
            dataListAdapter = new DataListAdapter(ListActivity.this, dataList);
            itemsRecyclerView.setAdapter(dataListAdapter);
        }
    }

    private void bindRefreshAdapter() {
        dataBean = new DataBean();
        dataBean.name = "Vani";
        dataBean.email = "vani@gmail.com";
        dataBean.address = "Mumbai";
        dataBean.mobile = "1234567890";
        dataList.add(dataBean);

        dataBean = new DataBean();
        dataBean.name = "Ipsha";
        dataBean.email = "ipsha@gmail.com";
        dataBean.address = "Baroda";
        dataBean.mobile = "1234567890";
        dataList.add(dataBean);

        onItemsLoadComplete();
    }

    void onItemsLoadComplete() {
        // Update the adapter and notify data set changed
        dataListAdapter.notifyDataSetChanged();

        /* Stop refresh animation*/
        mSwipeRefreshLayout.setRefreshing(false);
        /*disable pull to refresh gestures and progress animations*/
        mSwipeRefreshLayout.setEnabled(false);
    }


}
