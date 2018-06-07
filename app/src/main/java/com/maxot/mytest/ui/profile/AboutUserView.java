package com.maxot.mytest.ui.profile;

import android.content.Context;
import android.widget.TextView;

import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.AboutUser;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.item_profile_about)
public class AboutUserView {

    @View(R.id.about_user_text_view)
    TextView aboutUserTextView;


    Context mContext;
    AboutUser mAboutUser;

    public AboutUserView(Context context, AboutUser aboutUser) {
        mContext = context;
        mAboutUser = aboutUser;
    }

    @Resolve
    public void onResolved() {
        aboutUserTextView.setText(mAboutUser.getAbout());
    }
}
