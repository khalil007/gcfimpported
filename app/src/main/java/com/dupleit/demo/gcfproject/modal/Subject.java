
package com.dupleit.demo.gcfproject.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subject {

    @SerializedName("sub_id")
    @Expose
    private String subId;
    @SerializedName("sub_img")
    @Expose
    private String subImg;
    @SerializedName("sub_name")
    @Expose
    private String subName;
    @SerializedName("status")
    @Expose
    private String status;

    public Subject(String subId, String subImg, String subName, String status) {
        this.subId = subId;
        this.subImg = subImg;
        this.subName = subName;
        this.status = status;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getSubImg() {
        return subImg;
    }

    public void setSubImg(String subImg) {
        this.subImg = subImg;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
