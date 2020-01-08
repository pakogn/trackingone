package com.spyc.trackingone.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CombosResponse {

    @Expose
    @SerializedName("contact")
    private Contact contact;

    @Expose
    @SerializedName("id")
    private Long id;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("first_last_name")
    private String first_last_name;

    @Expose
    @SerializedName("second_last_name")
    private String second_last_name;

    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("auth")
    private Long auth;

    @Expose
    @SerializedName("status")
    private Boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_last_name() {
        return first_last_name;
    }

    public void setFirst_last_name(String first_last_name) {
        this.first_last_name = first_last_name;
    }

    public String getSecond_last_name() {
        return second_last_name;
    }

    public void setSecond_last_name(String second_last_name) {
        this.second_last_name = second_last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getAuth() {
        return auth;
    }

    public void setAuth(Long auth) {
        this.auth = auth;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public class Contact {
        @Expose
        @SerializedName("address")
        private Adress address;

        @Expose
        @SerializedName("email")
        private Email email;

        @Expose
        @SerializedName("id")
        private Long id;

        @Expose
        @SerializedName("email_id")
        private Long email_id;

        @Expose
        @SerializedName("address_id")
        private Long address_id;
    }

    public class Adress {
        private Long id;
        private Long zipcode;
        private String street;
        private Long ext_number;
        private Long int_number;
        private String neighborhood;
        private Long latitud;
        private Long longitude;
        private String state;
        private String country;
        private String city;
    }

    public class Email {
        private Long id;
        private String email_address;
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


