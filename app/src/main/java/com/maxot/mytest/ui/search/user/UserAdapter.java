package com.maxot.mytest.ui.search.user;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.User;
import com.maxot.mytest.ui.basic.FirestoreAdapter;
import com.maxot.mytest.ui.custom.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAdapter extends FirestoreAdapter<UserAdapter.ViewHolder> {

    private OnUserSelectedListener mListener;

    public interface OnUserSelectedListener {

        void onUserSelected(DocumentSnapshot restaurant);

    }

    public UserAdapter() {
    }

    public UserAdapter(Query mQuery, OnUserSelectedListener listener) {
        super(mQuery);
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getSnapshot(position), mListener);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_user_name)
        TextView tvUserName;

        @BindView(R.id.iv_user_pic)
        RoundedImageView ivUserPick;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final DocumentSnapshot snapshot,
                         final OnUserSelectedListener listener) {

            User user = snapshot.toObject(User.class);
            //Resources resources = itemView.getResources();

            Glide.with(ivUserPick.getContext())
                    .load(user.getPicture())
                    .into(ivUserPick);

            tvUserName.setText(user.getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onUserSelected(snapshot);
                    }
                }
            });
        }
    }
}
