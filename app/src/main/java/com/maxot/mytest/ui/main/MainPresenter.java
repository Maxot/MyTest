package com.maxot.mytest.ui.main;

import android.net.Uri;

import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.data.db.model.User;
import com.maxot.mytest.ui.basic.BasePresenter;
import com.maxot.mytest.ui.basic.MvpPresenter;
import com.maxot.mytest.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    public static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(DataManager dataManager,
                         CompositeDisposable compositeDisposable,
                         SchedulerProvider schedulerProvider) {
        super(dataManager, compositeDisposable, schedulerProvider);
    }

    @Override
    public void onViewInitialized() {

    }

    @Override
    public void onNavMenuCreated() {

    }

    @Override
    public void onDrawerOptionProfileClick() {
        getMvpView().openProfileActivity();
    }

    @Override
    public void onDrawerOptionAboutClick() {

    }

    @Override
    public void onDrawerOptionLogoutClick() {

    }

//    @Override
//    public String getEmail(){
//        return super.getDataManager().getEmail();
//    }
//
//    @Override
//    public String getName() {
//        return super.getDataManager().getName();
//    }
//
//    @Override
//    public Uri getProfilImage() {
//        return super.getDataManager().getProfileImg();
//    }

    @Override
    public User getCurrentUser() {
        return getDataManager().getCurrentUser();
    }

    @Override
    public String getCurrentUseID() {
        return getDataManager().getCurrentUserId();
    }
}
