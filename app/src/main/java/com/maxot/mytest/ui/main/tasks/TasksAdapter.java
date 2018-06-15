package com.maxot.mytest.ui.main.tasks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.CustomTask;
import com.maxot.mytest.ui.basic.FirestoreAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TasksAdapter extends FirestoreAdapter<TasksAdapter.ViewHolder> {

    private  OnTaskSelectedListener mListener;

    public interface OnTaskSelectedListener{

        void onTaskSelected(DocumentSnapshot tasks);
    }

    public TasksAdapter() {
    }

    public TasksAdapter(Query mQuery, OnTaskSelectedListener mListener) {
        super(mQuery);
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item_task_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getSnapshot(position), mListener);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_task_name)
        TextView tvTaskName;

        @BindView(R.id.tv_task_subject)
        TextView tvTaskSubject;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(DocumentSnapshot snapshot, OnTaskSelectedListener listener) {

            CustomTask task = snapshot.toObject(CustomTask.class);

            tvTaskName.setText(task.getName());
            tvTaskSubject.setText("subject: " + task.getSubject());
        }
    }
}
