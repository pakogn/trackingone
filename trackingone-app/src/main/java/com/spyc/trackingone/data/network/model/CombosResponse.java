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
    @SerializedName("password")
    private String password;

    @Expose
    @SerializedName("auth")
    private Long auth;

    @Expose
    @SerializedName("status")
    private Boolean status;

    @Expose
    @SerializedName("contact_id")
    private Long contact_id;

    @Expose
    @SerializedName("company_id")
    private Long company_id;


    @Expose
    @SerializedName("first_name")
    private String first_name;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Expose
    @SerializedName("label")
    private String label;


    public String getFirst_name() {
        return first_name;
    }

    public String getFullName() {
        return name+" "+ first_last_name+" "+second_last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getContact_id() {
        return contact_id;
    }

    public void setContact_id(Long contact_id) {
        this.contact_id = contact_id;
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
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
        private Double latitud;
        private Double longitude;
        private String state;
        private String country;
        private String city;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    public class Email {
        private Long id;
        private String email_address;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
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


