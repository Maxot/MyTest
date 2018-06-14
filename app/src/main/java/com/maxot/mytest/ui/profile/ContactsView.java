package com.maxot.mytest.ui.profile;

import android.content.Context;
import android.widget.TextView;

import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.User;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.item_profile_contact)
public class ContactsView {

    Context mContext;
    User mUser;
    @View(R.id.tv_profile_phone)
    TextView tvProfilePhone;

    @View(R.id.tv_profile_email)
    TextView tvProfileEmail;

    public ContactsView(Context mContext, User mUser) {
        this.mContext = mContext;
        this.mUser = mUser;
    }

    @Resolve
    public void onResolved() {
        tvProfilePhone.setText(mUser.getPhone());
        tvProfileEmail.setText(mUser.getEmail());
    }

}
