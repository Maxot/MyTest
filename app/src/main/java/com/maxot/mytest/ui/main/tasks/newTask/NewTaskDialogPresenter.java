package com.maxot.mytest.ui.main.tasks.newTask;

import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.data.db.model.CustomTask;
import com.maxot.mytest.ui.basic.BasePresenter;
import com.maxot.mytest.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class NewTaskDialogPresenter<V extends  NewTaskDialogMvpView>
        extends BasePresenter<V>
        implements NewTaskDialogMvpPresenter<V>{

    public static final String TAG = "NewTaskDialogPresenter";


    @Inject
    public NewTaskDialogPresenter(DataManager dataManager,
                                  CompositeDisposable compositeDisposable,
                                  SchedulerProvider schedulerProvider) {
        super(dataManager, compositeDisposable, schedulerProvider);
    }

    @Override
    public void addNewTask(CustomTask task) {
        getDataManager().addNewTaskToDb(task);
    }
}
