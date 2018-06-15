package com.maxot.mytest.ui.main.tasks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.maxot.mytest.R;
import com.maxot.mytest.di.component.ActivityComponent;
import com.maxot.mytest.ui.basic.BaseFragment;
import com.maxot.mytest.ui.main.tasks.newTask.NewTaskDialog;
import com.maxot.mytest.ui.search.user.UserAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TasksFragment extends BaseFragment
        implements  TasksMvpView,
        TasksAdapter.OnTaskSelectedListener{

    public static final String TAG = "TaskFragment";

    @Inject
    TasksMvpPresenter<TasksMvpView> mPresenter;

    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @Inject
    TasksAdapter mAdapter;

    @BindView(R.id.tasks_recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.floatingActionButtonForNewTask)
    FloatingActionButton mFloatingActionButton;



    public static TasksFragment newInstance(){
        Bundle args = new Bundle();
        TasksFragment fragment = new TasksFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        //    mTaskAdapter.setCallback(this);
        }

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

    @Override
    protected void setUp(View view) {
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        // RecyclerView
        mAdapter = new TasksAdapter(mPresenter.getTasks(), this) {
            @Override
            protected void onDataChanged() {
                // Show/hide content if the query returns empty.
                if (getItemCount() == 0) {
                    mRecyclerView.setVisibility(View.GONE);
                    //     mEmptyView.setVisibility(View.VISIBLE);
                } else {
                    mRecyclerView.setVisibility(View.VISIBLE);
                    //     mEmptyView.setVisibility(View.GONE);
                }
            }

            @Override
            protected void onError(FirebaseFirestoreException e) {
                // Show a snackbar on errors
//                Snackbar.make(findViewById(android.R.id.content),
//                        "Error: check logs for info.", Snackbar.LENGTH_LONG).show();
            }
        };

        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @OnClick(R.id.floatingActionButtonForNewTask)
    public void floatingNewTaskClick(){
        NewTaskDialog.newInstance().show(getFragmentManager());
    }

    @Override
    public void onTaskSelected(DocumentSnapshot tasks) {

    }
}
