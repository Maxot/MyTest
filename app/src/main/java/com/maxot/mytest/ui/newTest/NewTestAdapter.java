package com.maxot.mytest.ui.newTest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.Question;
import com.maxot.mytest.ui.basic.BaseViewHolder;

import java.util.List;

public class NewTestAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    List<Integer> mList;

    public NewTestAdapter(List<Integer> questionList) {
        mList = questionList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new_test, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (mList != null && mList.size() > 0)
            return  mList.size();
        return 0;
    }

    public void addItems(List<Integer> list){
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public void addItem(Integer list){
        mList.add(list);
        notifyDataSetChanged();
    }







    public class ViewHolder extends BaseViewHolder {


        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void clear() {

        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

//            final Integer item = mList.get(position);
        }
    }
}
