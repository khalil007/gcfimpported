
package com.dupleit.demo.gcfproject.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoAll {

    public VideoAll(String videoid, String imagePath, String name, String institute, String views, String course) {
        this.videoid = videoid;
        this.imagePath = imagePath;
        this.name = name;
        this.institute = institute;
        this.views = views;
        this.course = course;
    }

    @SerializedName("videoid")
    @Expose
    private String videoid;
    @SerializedName("image_path")
    @Expose
    private String imagePath;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }



    public String getVideoid() {
        return videoid;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

}
