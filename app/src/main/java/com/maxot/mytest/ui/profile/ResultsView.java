package com.maxot.mytest.ui.profile;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.Result;
import com.maxot.mytest.ui.main.MainActivity;
import com.maxot.mytest.ui.result.ResultActivity;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.ChildPosition;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;

import butterknife.BindView;

@Layout(R.layout.item_profile_result)
public class ResultsView {

    @ParentPosition
    int mParentPosition;

    @ChildPosition
    int mChildPosition;

    @View(R.id.test_name_in_result_profile)
    TextView titleTxt;

//    @View(R.id.captionTxt)
//    TextView captionTxt;
//
//    @View(R.id.timeTxt)
//    TextView timeTxt;
//
//    @View(R.id.imageView)
//    ImageView imageView;

    Result mResult;
    Context mContext;

    public ResultsView(Context context, Result result) {
        mContext = context;
        mResult = result;
    }

    @Resolve
    public void onResolved() {
        titleTxt.setText("test id: " + mResult.getTestId());
    }

    @Click(R.id.test_name_in_result_profile)
    public void clickItemResult(){
        titleTxt.getContext().startActivity(ResultActivity.getStartIntent(mContext));
    }

}
