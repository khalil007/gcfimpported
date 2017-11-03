
package com.dupleit.demo.gcfproject.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideosingleAll {

    @SerializedName("video_id")
    @Expose
    private String videoId;
    @SerializedName("video_path")
    @Expose
    private String videoPath;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("institute")
    @Expose
    private String institute;
    @SerializedName("views")
    @Expose
    private String views;
    @SerializedName("course")
    @Expose
    private String course;

    public VideosingleAll(String videoId, String videoPath, String name, String institute, String views, String course) {
        this.videoId = videoId;
        this.videoPath = videoPath;
        this.name = name;
        this.institute = institute;
        this.views = views;
        this.course = course;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}
