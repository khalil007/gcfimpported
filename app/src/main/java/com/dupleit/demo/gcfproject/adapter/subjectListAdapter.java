package com.dupleit.demo.gcfproject.adapter;


import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.dupleit.demo.gcfproject.R;
import com.dupleit.demo.gcfproject.modal.Subject;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class subjectListAdapter extends RecyclerView.Adapter<subjectListAdapter.SearchListViewHolder>{

    private Context context;
    private List<Subject> playlists;

    public class SearchListViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        public SearchListViewHolder(View itemView) {
            super(itemView);
            image = (CircleImageView) itemView.findViewById(R.id.imageSubject);
        }

    }


    public subjectListAdapter(Context context, List<Subject> playlists) {
        this.context = context;
        this.playlists = playlists;
    }

    @Override
    public SearchListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_subjects, parent, false);
        return new SearchListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchListViewHolder holder, int position) {
        Subject userObject = playlists.get(position);

        Glide.with(context).load(userObject.getSubImg()).into(holder.image);
    }


    @Override
    public int getItemCount() {
        return playlists.size();
    }
}
