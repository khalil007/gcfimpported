
package com.dupleit.demo.gcfproject.modal;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("subject")
    @Expose
    private List<Subject> subject = null;
    @SerializedName("performance")
    @Expose
    private Performance performance;
    @SerializedName("quiz_show")
    @Expose
    private QuizShow quizShow;
    @SerializedName("userShow")
    @Expose
    private UserShow userShow;

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public QuizShow getQuizShow() {
        return quizShow;
    }

    public void setQuizShow(QuizShow quizShow) {
        this.quizShow = quizShow;
    }

    public UserShow getUserShow() {
        return userShow;
    }

    public void setUserShow(UserShow userShow) {
        this.userShow = userShow;
    }

}
