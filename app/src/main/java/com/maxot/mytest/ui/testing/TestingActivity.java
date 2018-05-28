package com.maxot.mytest.ui.testing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.Question;
import com.maxot.mytest.ui.basic.BaseActivity;
import com.maxot.mytest.utils.ScreenUtils;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.listeners.ItemRemovedListener;

import java.util.List;

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
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
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

        mCardsContainerView.addItemRemoveListener(new ItemRemovedListener() {
            @Override
            public void onItemRemoved(int count) {
                if (count == 0){
                    //reload the content
                }
            }
        });

    }


    @Override
    public void refreshQuestionnaire(List<Question> questionList) {
        for (Question question: questionList){
            if (question != null
                    && question.getOptionList() != null
                    && question.getOptionList().size() == 3) {
                mCardsContainerView.addView(new QuestionCard(question));
            }
        }
    }

    @Override
    public void reloadQuestionnaire(List<Question> questionList) {
        refreshQuestionnaire(questionList);
        ScaleAnimation animation =
                new ScaleAnimation(
                        1.15f, 1, 1.15f, 1,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);

        mCardsContainerView.setAnimation(animation);
        animation.setDuration(100);
        animation.start();
    }
}
