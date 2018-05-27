package com.maxot.mytest.ui.testing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.maxot.mytest.R;
import com.maxot.mytest.ui.basic.BaseActivity;
import com.maxot.mytest.utils.ScreenUtils;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestingActivity extends BaseActivity implements TestingMvpView {

    @Inject
    TestingMvpPresenter<TestingMvpView> mPresenter;

    @BindView(R.id.card_container)
    SwipePlaceHolderView mCardsContainerView;



    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, TestingActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        getActivityComponent().inject(this);

        setUnbinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void setUp() {
        setupCardContainerView();
        mPresenter.onViewInitialized();
    }


    /**
     * Working with Card Container.
     */

    private void setupCardContainerView(){

        int screenWidth = ScreenUtils.getScreenWidth(this);
        int screenHeight = ScreenUtils.getScreenHeight(this);

        mCardsContainerView.getBuilder()
                .setDisplayViewCount(3)
                .setHeightSwipeDistFactor(10)
                .setWidthSwipeDistFactor(5)
                .setSwipeDecor(new SwipeDecor()
                        .setViewWidth((int)(0.90 * screenWidth))
                        .setViewHeight((int) (0.75 * screenHeight))
                        .setPaddingTop(20)
                        .setSwipeRotationAngle(10)
                        .setRelativeScale(0.01f));

    }
}
