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

    List<Question> mQuestionList;

    public NewTestAdapter(List<Question> questionList) {
        mQuestionList = questionList;
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
        return 0;
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
        }
    }
}
