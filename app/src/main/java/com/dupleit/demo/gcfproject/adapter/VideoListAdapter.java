package com.dupleit.demo.gcfproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dupleit.demo.gcfproject.R;
import com.dupleit.demo.gcfproject.helper.Config;
import com.dupleit.demo.gcfproject.modal.Subject;
import com.dupleit.demo.gcfproject.modal.VideoAll;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.SearchListViewHolder>{

    private Context context;
    private List<VideoAll> playlists;

    public class SearchListViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView couse,name,institute,userviews,videoTime;
        public SearchListViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.propertyImage);
            couse = itemView.findViewById(R.id.title);
            videoTime = itemView.findViewById(R.id.videoTime);
            institute = itemView.findViewById(R.id.ownerName);
            userviews = itemView.findViewById(R.id.ownerType);
            name = itemView.findViewById(R.id.profName);
        }
    }

    public VideoListAdapter(Context context, List<VideoAll> playlists) {
        this.context = context;
        this.playlists = playlists;
    }

    @Override
    public SearchListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_images, parent, false);
        return new SearchListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchListViewHolder holder, int position) {
        VideoAll userObject = playlists.get(position);

        Glide.with(context).load(Config.Web_path+userObject.getImagePath()).into(holder.image);
        holder.couse.setText(userObject.getCourse());
        holder.videoTime.setText("4 min");
        holder.userviews.setText(userObject.getViews());
        holder.institute.setText(userObject.getInstitute());
        holder.name.setText("by Prof. "+userObject.getName());

    }


    @Override
    public int getItemCount() {
        return playlists.size();
    }
}
