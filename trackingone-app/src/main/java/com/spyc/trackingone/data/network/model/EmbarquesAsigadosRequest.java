package com.spyc.trackingone.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmbarquesAsigadosRequest {

    @Expose
    @SerializedName("initial_yard_mule_driver_id")
    private int initial_yard_mule_driver_id;
    @Expose
    @SerializedName("initial_parking_space")
    private String initial_parking_space;
    @Expose
    @SerializedName("ramp")
    private String ramp;
    @Expose
    @SerializedName("final_yard_mule_driver_id")
    private int final_yard_mule_driver_id;
    @Expose
    @SerializedName("final_parking_space")
    private String final_parking_space;
    @Expose
    @SerializedName("shipping_priority")
    private int shipping_priority;

    public int getInitial_yard_mule_driver_id() {
        return initial_yard_mule_driver_id;
    }

    public void setInitial_yard_mule_driver_id(int initial_yard_mule_driver_id) {
        this.initial_yard_mule_driver_id = initial_yard_mule_driver_id;
    }

    public String getInitial_parking_space() {
        return initial_parking_space;
    }

    public void setInitial_parking_space(String initial_parking_space) {
        this.initial_parking_space = initial_parking_space;
    }

    public String getRamp() {
        return ramp;
    }

    public void setRamp(String ramp) {
        this.ramp = ramp;
    }

    public int getFinal_yard_mule_driver_id() {
        return final_yard_mule_driver_id;
    }

    public void setFinal_yard_mule_driver_id(int final_yard_mule_driver_id) {
        this.final_yard_mule_driver_id = final_yard_mule_driver_id;
    }

    public String getFinal_parking_space() {
        return final_parking_space;
    }

    public void setFinal_parking_space(String final_parking_space) {
        this.final_parking_space = final_parking_space;
    }

    public int getShipping_priority() {
        return shipping_priority;
    }

    public void setShipping_priority(int shipping_priority) {
        this.shipping_priority = shipping_priority;
    }

}
