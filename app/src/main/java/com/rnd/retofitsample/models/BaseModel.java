package com.rnd.retofitsample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Devrepublic-14 on 9/12/2017.
 */

public class BaseModel {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("msg")
    @Expose
    private String msg;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
