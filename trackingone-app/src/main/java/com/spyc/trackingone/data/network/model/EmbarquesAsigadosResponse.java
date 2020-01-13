package com.spyc.trackingone.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmbarquesAsigadosResponse {

    @Expose
    @SerializedName("status")
    private int status;
    @Expose
    @SerializedName("error")
    private Boolean error;
    @Expose
    @SerializedName("error_code")
    private String error_code;
    @Expose
    @SerializedName("message")
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
