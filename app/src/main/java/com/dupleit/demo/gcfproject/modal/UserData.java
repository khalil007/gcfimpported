
package com.dupleit.demo.gcfproject.modal;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("userShow")
    @Expose
    private UserShow userShow;
    @SerializedName("subject")
    @Expose
    private List<Subject> subject = null;
    @SerializedName("VideoAll")
    @Expose
    private List<VideoAll> videoAll = null;
    @SerializedName("performance")
    @Expose
    private List<Performance> performance = null;
    @SerializedName("quiz_show")
    @Expose
    private List<QuizShow> quizShow = null;

    public UserShow getUserShow() {
        return userShow;
    }

    public void setUserShow(UserShow userShow) {
        this.userShow = userShow;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }

    public List<VideoAll> getVideoAll() {
        return videoAll;
    }

    public void setVideoAll(List<VideoAll> videoAll) {
        this.videoAll = videoAll;
    }

    public List<Performance> getPerformance() {
        return performance;
    }

    public void setPerformance(List<Performance> performance) {
        this.performance = performance;
    }

    public List<QuizShow> getQuizShow() {
        return quizShow;
    }

    public void setQuizShow(List<QuizShow> quizShow) {
        this.quizShow = quizShow;
    }

}
