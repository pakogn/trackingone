package com.spyc.trackingone.data.network.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilaEmbarqueResponse {


    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("is_marked_as_rejected")
    private String is_marked_as_rejected;

    @Expose
    @SerializedName("shipping_number")
    private String shipping_number;

    @Expose
    @SerializedName("shipping_status_id")
    private String shipping_status_id;

    @Expose
    @SerializedName("scheduled_date")
    private String scheduled_date;

    @Expose
    @SerializedName("warehouse_id")
    private String warehouse_id;

    @Expose
    @SerializedName("carrier_id")
    private String carrier_id;

    @Expose
    @SerializedName("driver_id")
    private String driver_id;

    @Expose
    @SerializedName("customer_id")
    private String customer_id;

    @Expose
    @SerializedName("trailer_number")
    private String trailer_number;

    @Expose
    @SerializedName("truck_number")
    private String truck_number;

    @Expose
    @SerializedName("license_plate")
    private String license_plate;

    @Expose
    @SerializedName("container")
    private String container;

    @Expose
    @SerializedName("trailer_status_id")
    private String trailer_status_id;

    @Expose
    @SerializedName("origin")
    private String origin;

    @Expose
    @SerializedName("destination")
    private String destination;

    @Expose
    @SerializedName("initial_yard_mule_driver_id")
    private String initial_yard_mule_driver_id;

    @Expose
    @SerializedName("initial_parking_space")
    private String initial_parking_space;

    @Expose
    @SerializedName("ramp")
    private String ramp;

    @Expose
    @SerializedName("final_parking_space")
    private String final_parking_space;

    @Expose
    @SerializedName("shipping_priority")
    private String shipping_priority;

    @Expose
    @SerializedName("final_yard_mule_driver_id")
    private String final_yard_mule_driver_id;

    @Expose
    @SerializedName("ramp_and_yard_mule_driver_assigned_at")
    private String ramp_and_yard_mule_driver_assigned_at;

    @Expose
    @SerializedName("moved_from_parking_space_at")
    private String moved_from_parking_space_at;

    @Expose
    @SerializedName("in_ramp_at")
    private String in_ramp_at;

    @Expose
    @SerializedName("moved_from_ramp_at")
    private String moved_from_ramp_at;

    @Expose
    @SerializedName("in_parking_space_at")
    private String in_parking_space_at;

    @Expose
    @SerializedName("created_at")
    private String created_at;

    @Expose
    @SerializedName("creator_id")
    private String creator_id;

    @Expose
    @SerializedName("updated_at")
    private String updated_at;

    @Expose
    @SerializedName("editor_id")
    private String editor_id;

    @Expose
    @SerializedName("shipping_status")
    private String shipping_status;

    @Expose
    @SerializedName("warehouse")
    private String warehouse;

    @Expose
    @SerializedName("carrier")
    private String carrier;

    @Expose
    @SerializedName("driver")
    private String driver;

    @Expose
    @SerializedName("customer")
    private String customer;

    @Expose
    @SerializedName("initial_yard_mule_driver")
    private String initial_yard_mule_driver;

    @Expose
    @SerializedName("final_yard_mule_driver")
    private String final_yard_mule_driver;

    @Expose
    @SerializedName("creator")
    private String creator;

    @Expose
    @SerializedName("editor")
    private String editor;

    @Expose
    @SerializedName("trailer_status")
    private String trailer_status;

    /*
    public FilaEmbarqueResponse(int id, String fecha, String operador, String no_embarque, String transportista, String no_remolque, String no_tractor, String caja, String placas) {
        this.id = id;
        this.fecha = fecha;
        this.operador = operador;
        this.no_embarque = no_embarque;
        this.transportista = transportista;
        this.no_remolque = no_remolque;
        this.no_tractor = no_tractor;
        this.caja = caja;
        this.placas = placas;
    }
    */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIs_marked_as_rejected() {
        return is_marked_as_rejected;
    }

    public void setIs_marked_as_rejected(String is_marked_as_rejected) {
        this.is_marked_as_rejected = is_marked_as_rejected;
    }

    public String getShipping_number() {
        return shipping_number;
    }

    public void setShipping_number(String shipping_number) {
        this.shipping_number = shipping_number;
    }

    public String getShipping_status_id() {
        return shipping_status_id;
    }

    public void setShipping_status_id(String shipping_status_id) {
        this.shipping_status_id = shipping_status_id;
    }

    public String getScheduled_date() {
        return scheduled_date;
    }

    public void setScheduled_date(String scheduled_date) {
        this.scheduled_date = scheduled_date;
    }

    public String getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(String warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getCarrier_id() {
        return carrier_id;
    }

    public void setCarrier_id(String carrier_id) {
        this.carrier_id = carrier_id;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getTrailer_number() {
        return trailer_number;
    }

    public void setTrailer_number(String trailer_number) {
        this.trailer_number = trailer_number;
    }

    public String getTruck_number() {
        return truck_number;
    }

    public void setTruck_number(String truck_number) {
        this.truck_number = truck_number;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getTrailer_status_id() {
        return trailer_status_id;
    }

    public void setTrailer_status_id(String trailer_status_id) {
        this.trailer_status_id = trailer_status_id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getInitial_yard_mule_driver_id() {
        return initial_yard_mule_driver_id;
    }

    public void setInitial_yard_mule_driver_id(String initial_yard_mule_driver_id) {
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

    public String getFinal_parking_space() {
        return final_parking_space;
    }

    public void setFinal_parking_space(String final_parking_space) {
        this.final_parking_space = final_parking_space;
    }

    public String getShipping_priority() {
        return shipping_priority;
    }

    public void setShipping_priority(String shipping_priority) {
        this.shipping_priority = shipping_priority;
    }

    public String getFinal_yard_mule_driver_id() {
        return final_yard_mule_driver_id;
    }

    public void setFinal_yard_mule_driver_id(String final_yard_mule_driver_id) {
        this.final_yard_mule_driver_id = final_yard_mule_driver_id;
    }

    public String getRamp_and_yard_mule_driver_assigned_at() {
        return ramp_and_yard_mule_driver_assigned_at;
    }

    public void setRamp_and_yard_mule_driver_assigned_at(String ramp_and_yard_mule_driver_assigned_at) {
        this.ramp_and_yard_mule_driver_assigned_at = ramp_and_yard_mule_driver_assigned_at;
    }

    public String getMoved_from_parking_space_at() {
        return moved_from_parking_space_at;
    }

    public void setMoved_from_parking_space_at(String moved_from_parking_space_at) {
        this.moved_from_parking_space_at = moved_from_parking_space_at;
    }

    public String getIn_ramp_at() {
        return in_ramp_at;
    }

    public void setIn_ramp_at(String in_ramp_at) {
        this.in_ramp_at = in_ramp_at;
    }

    public String getMoved_from_ramp_at() {
        return moved_from_ramp_at;
    }

    public void setMoved_from_ramp_at(String moved_from_ramp_at) {
        this.moved_from_ramp_at = moved_from_ramp_at;
    }

    public String getIn_parking_space_at() {
        return in_parking_space_at;
    }

    public void setIn_parking_space_at(String in_parking_space_at) {
        this.in_parking_space_at = in_parking_space_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(String creator_id) {
        this.creator_id = creator_id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getEditor_id() {
        return editor_id;
    }

    public void setEditor_id(String editor_id) {
        this.editor_id = editor_id;
    }

    public String getShipping_status() {
        return shipping_status;
    }

    public void setShipping_status(String shipping_status) {
        this.shipping_status = shipping_status;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getInitial_yard_mule_driver() {
        return initial_yard_mule_driver;
    }

    public void setInitial_yard_mule_driver(String initial_yard_mule_driver) {
        this.initial_yard_mule_driver = initial_yard_mule_driver;
    }

    public String getFinal_yard_mule_driver() {
        return final_yard_mule_driver;
    }

    public void setFinal_yard_mule_driver(String final_yard_mule_driver) {
        this.final_yard_mule_driver = final_yard_mule_driver;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getTrailer_status() {
        return trailer_status;
    }

    public void setTrailer_status(String trailer_status) {
        this.trailer_status = trailer_status;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

