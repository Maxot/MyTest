package com.maxot.mytest.ui.main.results;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.data.db.model.Test;
import com.maxot.mytest.ui.basic.BaseViewHolder;
import com.maxot.mytest.ui.main.tests.TestsAdapter;
import com.maxot.mytest.ui.result.ResultActivity;
import com.maxot.mytest.ui.testing.TestingActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private List<Result> mResultList;

    public ResultsAdapter(List<Result> resultList) {
        mResultList = resultList;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ResultsAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_results_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if(mResultList != null && mResultList.size() > 0)
            return mResultList.size();
        else
            return 0;
    }

    public void addItems(List<Result> resultList){
        mResultList.addAll(resultList);
        notifyDataSetChanged();

    }


    public interface Callback{
        void onTestsEmptyViewRetryClick();
    }

    /**
     * View Holder for results list
     */
    public class ViewHolder extends BaseViewHolder{

        @BindView(R.id.test_name_in_results_view)
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

            final Result result = mResultList.get(position);

            testNameTextView.setText("test id: " + result.getTestId());


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemView.getContext().startActivity(ResultActivity.getStartIntent(itemView.getContext()));
                }
            });
        }
    }

}
