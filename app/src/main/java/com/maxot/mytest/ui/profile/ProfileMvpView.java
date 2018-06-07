package com.maxot.mytest.ui.profile;

import com.maxot.mytest.data.db.model.AboutUser;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.data.db.model.Review;
import com.maxot.mytest.ui.basic.MvpView;

import java.util.List;

public interface ProfileMvpView extends MvpView {

    void updateResults(List<Result> resultList);

    void updateAboutUser(AboutUser about);

    void updateReviews(List<Review> about);

    void openMainActivity();

    void openResultActivity();
}
