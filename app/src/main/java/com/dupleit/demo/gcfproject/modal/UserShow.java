
package com.dupleit.demo.gcfproject.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserShow {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("subject_show")
    @Expose
    private String subjectShow;
    @SerializedName("video_show")
    @Expose
    private String videoShow;
    @SerializedName("performance_show")
    @Expose
    private String performanceShow;
    @SerializedName("quiz_show")
    @Expose
    private String quizShow;
    @SerializedName("allvideo_show")
    @Expose
    private String allvideoShow;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectShow() {
        return subjectShow;
    }

    public void setSubjectShow(String subjectShow) {
        this.subjectShow = subjectShow;
    }

    public String getVideoShow() {
        return videoShow;
    }

    public void setVideoShow(String videoShow) {
        this.videoShow = videoShow;
    }

    public String getPerformanceShow() {
        return performanceShow;
    }

    public void setPerformanceShow(String performanceShow) {
        this.performanceShow = performanceShow;
    }

    public String getQuizShow() {
        return quizShow;
    }

    public void setQuizShow(String quizShow) {
        this.quizShow = quizShow;
    }

    public String getAllvideoShow() {
        return allvideoShow;
    }

    public void setAllvideoShow(String allvideoShow) {
        this.allvideoShow = allvideoShow;
    }

}
