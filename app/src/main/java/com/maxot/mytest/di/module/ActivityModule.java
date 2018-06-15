package com.maxot.mytest.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.google.firebase.firestore.Query;
import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.Question;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.data.db.model.Test;
import com.maxot.mytest.di.ActivityContext;
import com.maxot.mytest.di.PerActivity;
import com.maxot.mytest.ui.basic.MvpPresenter;
import com.maxot.mytest.ui.basic.MvpView;
import com.maxot.mytest.ui.login.LoginMvpPresenter;
import com.maxot.mytest.ui.login.LoginMvpView;
import com.maxot.mytest.ui.login.LoginPresenter;
import com.maxot.mytest.ui.main.MainMvpPresenter;
import com.maxot.mytest.ui.main.MainMvpView;
import com.maxot.mytest.ui.main.MainPagerAdapter;
import com.maxot.mytest.ui.main.MainPresenter;
import com.maxot.mytest.ui.main.results.ResultsAdapter;
import com.maxot.mytest.ui.main.results.ResultsMvpPresenter;
import com.maxot.mytest.ui.main.results.ResultsMvpView;
import com.maxot.mytest.ui.main.results.ResultsPresenter;
import com.maxot.mytest.ui.main.tasks.TasksAdapter;
import com.maxot.mytest.ui.main.tasks.TasksMvpPresenter;
import com.maxot.mytest.ui.main.tasks.TasksMvpView;
import com.maxot.mytest.ui.main.tasks.TasksPresenter;
import com.maxot.mytest.ui.main.tasks.newTask.NewTaskDialogMvpPresenter;
import com.maxot.mytest.ui.main.tasks.newTask.NewTaskDialogMvpView;
import com.maxot.mytest.ui.main.tasks.newTask.NewTaskDialogPresenter;
import com.maxot.mytest.ui.main.tests.TestsAdapter;
import com.maxot.mytest.ui.main.tests.TestsMvpPresenter;
import com.maxot.mytest.ui.main.tests.TestsMvpView;
import com.maxot.mytest.ui.main.tests.TestsPresenter;
import com.maxot.mytest.ui.newTest.NewTestAdapter;
import com.maxot.mytest.ui.newTest.NewTestMvpPresenter;
import com.maxot.mytest.ui.newTest.NewTestMvpView;
import com.maxot.mytest.ui.newTest.NewTestPresenter;
import com.maxot.mytest.ui.profile.ProfileMvpPresenter;
import com.maxot.mytest.ui.profile.ProfileMvpView;
import com.maxot.mytest.ui.profile.ProfilePresenter;
import com.maxot.mytest.ui.result.ResultAdapter;
import com.maxot.mytest.ui.result.ResultMvpPresenter;
import com.maxot.mytest.ui.result.ResultMvpView;
import com.maxot.mytest.ui.result.ResultPresenter;
import com.maxot.mytest.ui.search.SearchMvpPresenter;
import com.maxot.mytest.ui.search.SearchMvpView;
import com.maxot.mytest.ui.search.SearchPresenter;
import com.maxot.mytest.ui.search.user.UserAdapter;
import com.maxot.mytest.ui.splash.SplashMvpPresenter;
import com.maxot.mytest.ui.splash.SplashMvpView;
import com.maxot.mytest.ui.splash.SplashPresenter;
import com.maxot.mytest.ui.testing.TestingMvpPresenter;
import com.maxot.mytest.ui.testing.TestingMvpView;
import com.maxot.mytest.ui.testing.TestingPresenter;
import com.maxot.mytest.utils.rx.AppSchedulerProvider;
import com.maxot.mytest.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return  mActivity;
    }

    @Provides
    AppCompatActivity provideActivity(){
        return  mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider(){
        return new AppSchedulerProvider();
    }

    /**
     * Adapters
     */

    @Provides
    MainPagerAdapter provideMainPagerAdapter(AppCompatActivity activity){
        return new MainPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    TestsAdapter provideTestsAdapter(){
        return new TestsAdapter(new ArrayList<Test>());
    }

    @Provides
    ResultAdapter provideResultAdapter(){
        return new ResultAdapter(new ArrayList<Result>());
    }

    @Provides
    ResultsAdapter provideResultsAdapter(){
        return new ResultsAdapter(new ArrayList<Result>());
    }

    @Provides
    NewTestAdapter provideNewTestAdapter(){
        return new NewTestAdapter(new ArrayList<Integer>());
    }

    @Provides
    UserAdapter provideUserAdapter(){
        return new UserAdapter();
    }

    @Provides
    TasksAdapter provideTasksAdapter(){
        return new TasksAdapter();
    }

    /**
     * Presenters
     */

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    TestingMvpPresenter<TestingMvpView> provideTestingPresenter(
            TestingPresenter<TestingMvpView> presenter) {
        return presenter;
    }

    @Provides
    TestsMvpPresenter<TestsMvpView> provideTestsMvpPresenter(
            TestsPresenter<TestsMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ResultMvpPresenter<ResultMvpView> provideResultMvpPresenter(
            ResultPresenter<ResultMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SearchMvpPresenter<SearchMvpView> provideSearchMvpPresenter(
            SearchPresenter<SearchMvpView> presenter) {
        return presenter;
    }


    @Provides
    @PerActivity
    ProfileMvpPresenter<ProfileMvpView> provideProfileMvpPresenter(
            ProfilePresenter<ProfileMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashMvpPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    ResultsMvpPresenter<ResultsMvpView> provideResultsMvpPresenter(
            ResultsPresenter<ResultsMvpView> presenter) {
        return presenter;
    }

    @Provides
    NewTestMvpPresenter<NewTestMvpView> provideNewTestMvpPresenter(
            NewTestPresenter<NewTestMvpView> presenter) {
        return presenter;
    }

    @Provides
    LoginMvpPresenter<LoginMvpView> provideLoginMvpPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    TasksMvpPresenter<TasksMvpView> provideTasksMvpPresenter(
            TasksPresenter<TasksMvpView> presenter) {
        return presenter;
    }

    /**
     * Dialogs
     */
    @Provides
    NewTaskDialogMvpPresenter<NewTaskDialogMvpView> provideRateUsPresenter(
            NewTaskDialogPresenter<NewTaskDialogMvpView> presenter) {
        return presenter;
    }







    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
