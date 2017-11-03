
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
    @SerializedName("sub_pos")
    @Expose
    private String subPos;
    @SerializedName("video_pos")
    @Expose
    private String videoPos;
    @SerializedName("videoall_pos")
    @Expose
    private String videoallPos;
    @SerializedName("per_pos")
    @Expose
    private String perPos;
    @SerializedName("quiz_pos")
    @Expose
    private String quizPos;

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

    public String getSubPos() {
        return subPos;
    }

    public void setSubPos(String subPos) {
        this.subPos = subPos;
    }

    public String getVideoPos() {
        return videoPos;
    }

    public void setVideoPos(String videoPos) {
        this.videoPos = videoPos;
    }

    public String getVideoallPos() {
        return videoallPos;
    }

    public void setVideoallPos(String videoallPos) {
        this.videoallPos = videoallPos;
    }

    public String getPerPos() {
        return perPos;
    }

    public void setPerPos(String perPos) {
        this.perPos = perPos;
    }

    public String getQuizPos() {
        return quizPos;
    }

    public void setQuizPos(String quizPos) {
        this.quizPos = quizPos;
    }

}
