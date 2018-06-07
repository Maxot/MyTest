package com.maxot.mytest.ui.profile;

import android.content.Context;
import android.widget.TextView;

import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.data.db.model.Review;
import com.maxot.mytest.ui.result.ResultActivity;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.ChildPosition;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;

@Layout(R.layout.item_profil_reviews)
public class ReviewsView {

    @ParentPosition
    int mParentPosition;

    @ChildPosition
    int mChildPosition;

    @View(R.id.review_text_view)
    TextView titleTxt;

    Review mReview;
    Context mContext;

    public ReviewsView(Context context, Review review) {
        mContext = context;
        mReview = review;
    }

    @Resolve
    public void onResolved() {
        titleTxt.setText("Review id: " + mReview.getReview());
    }

}
