package com.maxot.mytest.ui.testing;

import com.maxot.mytest.data.DataManager;
import com.maxot.mytest.data.db.model.Question;
import com.maxot.mytest.ui.basic.BasePresenter;
import com.maxot.mytest.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class TestingPresenter<V extends TestingMvpView> extends BasePresenter<V>
        implements TestingMvpPresenter<V>{

    public static final String TAG = "TestingPresenter";

    @Inject
    public TestingPresenter(DataManager dataManager,
                            CompositeDisposable compositeDisposable,
                            SchedulerProvider schedulerProvider) {
        super(dataManager, compositeDisposable, schedulerProvider);
    }

    @Override
    public void onViewInitialized() {
        getCompositeDisposable().add(getDataManager()
            .getAllQuestion()
            .subscribeOn(getSchedulerProvider().io())
            .observeOn(getSchedulerProvider().ui())
            .subscribe(new Consumer<List<Question>>() {
                @Override
                public void accept(List<Question> questions) throws Exception {
                    if(!isViewAttached()) {
                        return;
                    }

                    if (questions != null) {
                        getMvpView().refreshQuestionnaire(questions);
                    }
                }
            }));
    }
}
