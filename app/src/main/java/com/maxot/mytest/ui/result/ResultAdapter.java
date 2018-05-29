package com.maxot.mytest.ui.result;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.Answer;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.ui.basic.BaseViewHolder;
import com.maxot.mytest.ui.main.results.ResultsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class ResultAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Result> mResults;
    private Callback mCallback;

    public ResultAdapter(List<Result> results) {
        this.mResults = results;
    }

    public void setCallback(Callback callback){
        this.mCallback = callback;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (mResults != null && mResults.size() > 0)
            return mResults.size();
        else
            return 0;
    }

    public void addItems(List<Result> results){
        mResults.addAll(results);
        notifyDataSetChanged();
    }




    public interface Callback {
        void onRepoEmptyViewRetryClick();
    }



    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.question_name_textview)
        TextView questionNameTextView;

        @BindView(R.id.your_answer_textview)
        TextView yourAnswerTextView;

        @BindView(R.id.correct_answer_textview)
        TextView correctAnswerTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {
            questionNameTextView.setText("");
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            final Result result = mResults.get(position);

            questionNameTextView.setText("Question" + result.getTestId());

    //            yourAnswerTextView.setText(result.getAnswers().get(position).getMyAnswer());
        }
    }
}
