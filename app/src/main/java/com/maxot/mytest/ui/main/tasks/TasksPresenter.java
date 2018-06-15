package com.maxot.mytest.ui.main.tasks;

import com.google.firebase.firestore.Query;
import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.ui.basic.BasePresenter;
import com.maxot.mytest.ui.basic.MvpView;
import com.maxot.mytest.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class TasksPresenter<V extends TasksMvpView> extends BasePresenter<V>
        implements TasksMvpPresenter<V> {

    @Inject
    public TasksPresenter(DataManager dataManager,
                          CompositeDisposable compositeDisposable,
                          SchedulerProvider schedulerProvider) {
        super(dataManager, compositeDisposable, schedulerProvider);
    }


    @Override
    public Query getTasks() {
        return getDataManager().getTasks();
    }
}

