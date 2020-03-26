package com.spyc.trackingone.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jorge Namitle on 24/03/2018.
 */

public class ComentariosMuleroRequest {
    private ComentariosMuleroRequest() {
        // This class is not publicly instantiable
    }

    @Expose
    @SerializedName("id")
    private Long id;

    @Expose
    @SerializedName("comment")
    private String comment;

    public ComentariosMuleroRequest(Long id, String comment) {
        this.setId(id);
        this.setComment(comment);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ComentariosMuleroRequest that = (ComentariosMuleroRequest) object;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return comment != null ? comment.equals(that.comment) : that.comment == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
