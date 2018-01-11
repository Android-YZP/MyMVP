package com.example.smith.mymvp.main.app_module.test_module.adapter;

import android.content.Context;
import android.widget.TextView;

import com.example.smith.mymvp.R;
import com.example.smith.mymvp.main.app_module.test_module.model.main_bean.TestBean;
import com.example.smith.mymvp.main.base.ListBaseAdapter;
import com.example.smith.mymvp.main.base.SuperViewHolder;

import java.util.List;

/**
 * Created by 姚中平 on 2018/1/11.
 */

public class TestAdapter extends ListBaseAdapter<TestBean> {

    public TestAdapter(Context context) {
        super(context);


    }

    @Override
    public int getLayoutId() {
        return R.layout.list_item_text;
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, int position) {
        TestBean item = mDataList.get(position);
        TextView titleText = holder.getView(R.id.info_text);
        titleText.setText(item.name);
    }
}
