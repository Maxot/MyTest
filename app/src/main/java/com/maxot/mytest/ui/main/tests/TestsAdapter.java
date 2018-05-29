package com.maxot.mytest.ui.main.tests;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.Test;
import com.maxot.mytest.ui.basic.BaseViewHolder;
import com.maxot.mytest.ui.testing.TestingActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class TestsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private List<Test> mTestList;


    public TestsAdapter(List<Test> tests) {

        mTestList = tests;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tests_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if(mTestList != null && mTestList.size() > 0)
            return mTestList.size();
        else
            return 0;
    }

    public void addItems(List<Test> testList){
        mTestList.addAll(testList);
        notifyDataSetChanged();

    }


    public interface Callback{
        void onTestsEmptyViewRetryClick();
    }


    /**
     * View Holder for test list
     */
    public class ViewHolder extends BaseViewHolder{

        @BindView(R.id.test_name_view)
        TextView testNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {
            testNameTextView.setText("");
        }

        @Override
        public void onBind(int position){
            super.onBind(position);

            final Test test = mTestList.get(position);

            testNameTextView.setText(test.getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   itemView.getContext().startActivity(TestingActivity.getStartIntent(itemView.getContext()));
                }
            });
        }
    }
}
