package com.maxot.mytest.di.component;

import com.maxot.mytest.di.PerActivity;
import com.maxot.mytest.di.module.ActivityModule;
import com.maxot.mytest.ui.main.MainActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
}
