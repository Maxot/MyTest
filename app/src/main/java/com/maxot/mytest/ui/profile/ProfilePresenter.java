package com.maxot.mytest.ui.profile;

import android.net.Uri;

import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.data.db.model.AboutUser;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.data.db.model.Review;
import com.maxot.mytest.data.db.model.User;
import com.maxot.mytest.ui.basic.BasePresenter;
import com.maxot.mytest.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class ProfilePresenter<V extends  ProfileMvpView> extends BasePresenter<V>
        implements ProfileMvpPresenter<V>{

    public static final String TAG = "ProfilePresenter";

    @Inject
    public ProfilePresenter(DataManager dataManager,
                             CompositeDisposable compositeDisposable,
                             SchedulerProvider schedulerProvider) {
        super(dataManager, compositeDisposable, schedulerProvider);
    }

    @Override
    public void getAboutUser() {
        getCompositeDisposable().add(getDataManager()
                .getAboutUser()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<AboutUser>() {
                    @Override
                    public void accept(AboutUser aboutUser) throws Exception {

                        getMvpView().updateAboutUser(aboutUser);
                    }
                }));

    }

    @Override
    public void getReviews() {
        getCompositeDisposable().add(getDataManager()
                .getReviews()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<Review>>() {
                    @Override
                    public void accept(List<Review> reviews) throws Exception {
                        getMvpView().updateReviews(reviews);
                    }
                }));
    }



    @Override
    public void getResults() {
        getCompositeDisposable().add(getDataManager()
                .getAllResult()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<Result>>() {
                    @Override
                    public void accept(List<Result> results) throws Exception {

                        getMvpView().updateResults(results);
                    }
                }));

    }

    @Override
    public void getContact() {
        getMvpView().updateContacts(super.getDataManager().getUser());
    }

    @Override
    public String getEmail(){
        return super.getDataManager().getEmail();
    }

    @Override
    public String getName() {
        return super.getDataManager().getName();
    }

    @Override
    public Uri getProfileImage() {
        return super.getDataManager().getProfileImg();
    }

    @Override
    public User getUser() {
        return super.getDataManager().getUser();
    }

}
