package com.maxot.mytest.ui.main.tasks;

import android.app.DownloadManager;

import com.google.firebase.firestore.Query;
import com.maxot.mytest.ui.basic.MvpPresenter;

public interface TasksMvpPresenter<V extends TasksMvpView>
        extends MvpPresenter<V>{

    Query getTasks();
}
