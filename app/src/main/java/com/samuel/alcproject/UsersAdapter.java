package com.samuel.alcproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static java.lang.System.load;

/**
 * Created by USER on 8/29/2017.
 */


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {


    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_URL = "url";

    private List<UsersList> usersLists;
    private Context context;

    public UsersAdapter(List<UsersList> usersLists, Context context) {

        this.usersLists = usersLists;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.users, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        final UsersList usersList = usersLists.get(position);
        holder.login.setText(usersList.getLogin());

        Picasso.with(context)
                .load(usersList.getAvatar_url())
                .into(holder.avatar_url);
        holder.html_url.setText(usersList.getHtml_url());


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UsersList usersList1 = usersLists.get(position);

                Intent skipIntent = new Intent(v.getContext(), Profile.class);
                skipIntent.putExtra(KEY_NAME, usersList1.getLogin());
                skipIntent.putExtra(KEY_URL, usersList1.getHtml_url());
                skipIntent.putExtra(KEY_IMAGE, usersList1.getAvatar_url());
                v.getContext().startActivity(skipIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return usersLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView login;
        public ImageView avatar_url;
        public TextView html_url;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            login = (TextView) itemView.findViewById(R.id.username);
            avatar_url = (ImageView) itemView.findViewById(R.id.imageView);
            html_url = (TextView) itemView.findViewById(R.id.htmUrl);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);


            ;
            ;
        }

    }
}


