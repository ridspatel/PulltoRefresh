package com.example.pulltorefreshdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class DataListAdapter extends
        RecyclerView.Adapter<DataListAdapter.CustomViewHolder> {

    private ArrayList<DataBean> dataList;
    private Context context;
    private Intent intent = null;

    public DataListAdapter(Context context,
                           ArrayList<DataBean> dataList) {

        this.context = context;
        this.dataList = dataList;

    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView txtname, txtemail, txtadd, txtmobile;

        public CustomViewHolder(View itemView) {
            super(itemView);

            txtname = (TextView) itemView
                    .findViewById(R.id.textname);
            txtemail = (TextView) itemView
                    .findViewById(R.id.textemail);
            txtadd = (TextView) itemView
                    .findViewById(R.id.textadd);
            txtmobile = (TextView) itemView
                    .findViewById(R.id.textmobile);

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int arg1) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.row_data, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int pos) {

        final DataBean dataBean = dataList.get(pos);

        holder.txtname.setText(dataBean.name);
        holder.txtemail.setText(dataBean.email);
        holder.txtadd.setText(dataBean.address);
        holder.txtmobile.setText(dataBean.mobile);
    }

    @Override
    public int getItemCount() {

        return dataList.size();
    }

}
