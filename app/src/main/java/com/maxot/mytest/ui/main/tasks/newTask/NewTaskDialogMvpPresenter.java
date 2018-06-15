package com.maxot.mytest.ui.main.tasks.newTask;

import com.maxot.mytest.data.db.model.CustomTask;
import com.maxot.mytest.ui.basic.MvpPresenter;

public interface NewTaskDialogMvpPresenter<V extends NewTaskDialogMvpView>
        extends MvpPresenter<V>{

    void addNewTask(CustomTask task);
}
