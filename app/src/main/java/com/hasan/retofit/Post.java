package com.hasan.retofit;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("result")
    @Expose
    private List<Eczane> result;



    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean datetime) {
        this.success = datetime;
    }

     public List<Eczane> getResult() {
        return result;
    }

    public void setResult(List<Eczane> result) {
        this.result = result;
    }
}