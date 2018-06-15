package com.maxot.mytest.di.component;

import com.maxot.mytest.di.PerActivity;
import com.maxot.mytest.di.module.ActivityModule;
import com.maxot.mytest.ui.login.LoginActivity;
import com.maxot.mytest.ui.main.MainActivity;
import com.maxot.mytest.ui.main.results.ResultsFragment;
import com.maxot.mytest.ui.main.tasks.TasksFragment;
import com.maxot.mytest.ui.main.tasks.newTask.NewTaskDialog;
import com.maxot.mytest.ui.main.tests.TestsFragment;
import com.maxot.mytest.ui.newTest.NewTestActivity;
import com.maxot.mytest.ui.profile.ProfileActivity;
import com.maxot.mytest.ui.result.ResultActivity;
import com.maxot.mytest.ui.search.SearchActivity;
import com.maxot.mytest.ui.splash.SplashActivity;
import com.maxot.mytest.ui.testing.TestingActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(TestingActivity activity);

    void inject(ResultActivity activity);

    void inject(NewTestActivity activity);

    void inject(LoginActivity activity);

    void inject(ProfileActivity activity);

    void inject(SearchActivity activity);

    void inject(SplashActivity activity);


    void inject(TestsFragment fragment);

    void inject(TasksFragment fragment);

    void inject(ResultsFragment fragment);



    void inject(NewTaskDialog dialog);
}
