package com.desiredsoftware.quwi.component.usercomponent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.desiredsoftware.quwi.R;
import com.desiredsoftware.quwi.data.model.api.in.UserInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<UserInfo> userItems;

    public UserAdapter(List<UserInfo> userItems){
        this.userItems = userItems;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
            holder.setUserItem(userItems.get(position));
    }

    @Override
    public int getItemCount() {
        return userItems.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{

        ImageView avatarImage;
        TextView userName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarImage = itemView.findViewById(R.id.imageViewAvatar);
            userName = itemView.findViewById(R.id.userName);
        }

        void setUserItem (UserInfo userItem)
        {
            try {
                Picasso.get().load(userItem.getAvatarUrl().toString()).into(avatarImage);
            }
            catch (NullPointerException e)
            {
                avatarImage.setImageResource(R.drawable.user_avatar);
                Log.e("Avatar URL is empty ", e.getMessage());
            }
            userName.setText(userItem.getName());
        }
    }
}
