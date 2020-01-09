package com.spyc.trackingone.data.network.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilaEmbarqueResponse {


    @Expose
    @SerializedName("carrier")
    private Carrier carrier;

    @Expose
    @SerializedName("client")
    private Client client;

    @Expose
    @SerializedName("creator")
    private Creator creator;

    @Expose
    @SerializedName("editor")
    private Editor editor;

    @Expose
    @SerializedName("driver")
    private Driver driver;

    @Expose
    @SerializedName("final_yard_mule_driver")
    private FinalYardMuleDriver final_yard_mule_driver;

    @Expose
    @SerializedName("initial_yard_mule_driver")
    private InitialYardMuleDriver initial_yard_mule_driver;

    @Expose
    @SerializedName("shipping_status ")
    private ShippingStatus shipping_status;

    @Expose
    @SerializedName("trailer_status")
    private TrailerStatus trailer_status;

    @Expose
    @SerializedName("warehouse")
    private Warehouse warehouse;

    @Expose
    @SerializedName("id")
    private Long id;

    @Expose
    @SerializedName("is_marked_as_rejected")
    private String is_marked_as_rejected;

    @Expose
    @SerializedName("shipping_number")
    private String shipping_number;

    @Expose
    @SerializedName("shipping_status_id")
    private Long shipping_status_id;

    @Expose
    @SerializedName("scheduled_date")
    private String scheduled_date;

    @Expose
    @SerializedName("warehouse_id")
    private Long warehouse_id;

    @Expose
    @SerializedName("carrier_id")
    private Long carrier_id;

    @Expose
    @SerializedName("driver_id")
    private Long driver_id;

    @Expose
    @SerializedName("client_id")
    private Long client_id;

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
    private Long trailer_status_id;

    @Expose
    @SerializedName("origin")
    private String origin;

    @Expose
    @SerializedName("destination")
    private String destination;

    @Expose
    @SerializedName("initial_yard_mule_driver_id")
    private Long initial_yard_mule_driver_id;

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
    private Long final_yard_mule_driver_id;

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
    private Long creator_id;

    @Expose
    @SerializedName("updated_at")
    private String updated_at;

    @Expose
    @SerializedName("deleted_at")
    private String deleted_at;

    @Expose
    @SerializedName("editor_id")
    private Long editor_id;

    @Expose
    @SerializedName("formatted_scheduled_date")
    private String formatted_scheduled_date;

    @Expose
    @SerializedName("formatted_created_at")
    private String formatted_created_at;

    @Expose
    @SerializedName("formatted_updated_at")
    private String formatted_updated_at;

    @Expose
    @SerializedName("formatted_deleted_at")
    private String formatted_deleted_at;


    // sets y gets raiz


    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public FinalYardMuleDriver getFinal_yard_mule_driver() {
        return final_yard_mule_driver;
    }

    public void setFinal_yard_mule_driver(FinalYardMuleDriver final_yard_mule_driver) {
        this.final_yard_mule_driver = final_yard_mule_driver;
    }

    public InitialYardMuleDriver getInitial_yard_mule_driver() {
        return initial_yard_mule_driver;
    }

    public void setInitial_yard_mule_driver(InitialYardMuleDriver initial_yard_mule_driver) {
        this.initial_yard_mule_driver = initial_yard_mule_driver;
    }

    public ShippingStatus getShipping_status() {
        return shipping_status;
    }

    public void setShipping_status(ShippingStatus shipping_status) {
        this.shipping_status = shipping_status;
    }

    public TrailerStatus getTrailer_status() {
        return trailer_status;
    }

    public void setTrailer_status(TrailerStatus trailer_status) {
        this.trailer_status = trailer_status;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getShipping_status_id() {
        return shipping_status_id;
    }

    public void setShipping_status_id(Long shipping_status_id) {
        this.shipping_status_id = shipping_status_id;
    }

    public String getScheduled_date() {
        return scheduled_date;
    }

    public void setScheduled_date(String scheduled_date) {
        this.scheduled_date = scheduled_date;
    }

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public Long getCarrier_id() {
        return carrier_id;
    }

    public void setCarrier_id(Long carrier_id) {
        this.carrier_id = carrier_id;
    }

    public Long getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Long driver_id) {
        this.driver_id = driver_id;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
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

    public Long getTrailer_status_id() {
        return trailer_status_id;
    }

    public void setTrailer_status_id(Long trailer_status_id) {
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

    public Long getInitial_yard_mule_driver_id() {
        return initial_yard_mule_driver_id;
    }

    public void setInitial_yard_mule_driver_id(Long initial_yard_mule_driver_id) {
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

    public Long getFinal_yard_mule_driver_id() {
        return final_yard_mule_driver_id;
    }

    public void setFinal_yard_mule_driver_id(Long final_yard_mule_driver_id) {
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

    public Long getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(Long creator_id) {
        this.creator_id = creator_id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Long getEditor_id() {
        return editor_id;
    }

    public void setEditor_id(Long editor_id) {
        this.editor_id = editor_id;
    }

    public String getFormatted_scheduled_date() {
        return formatted_scheduled_date;
    }

    public void setFormatted_scheduled_date(String formatted_scheduled_date) {
        this.formatted_scheduled_date = formatted_scheduled_date;
    }

    public String getFormatted_created_at() {
        return formatted_created_at;
    }

    public void setFormatted_created_at(String formatted_created_at) {
        this.formatted_created_at = formatted_created_at;
    }

    public String getFormatted_updated_at() {
        return formatted_updated_at;
    }

    public void setFormatted_updated_at(String formatted_updated_at) {
        this.formatted_updated_at = formatted_updated_at;
    }

    public String getFormatted_deleted_at() {
        return formatted_deleted_at;
    }

    public void setFormatted_deleted_at(String formatted_deleted_at) {
        this.formatted_deleted_at = formatted_deleted_at;
    }

    public static  class Carrier {
        @Expose
        @SerializedName("address")
        private String address;

        @Expose
        @SerializedName("user")
        private String user;

        @Expose
        @SerializedName("id")
        private Long id;

        @Expose
        @SerializedName("name")
        private String name;

        @Expose
        @SerializedName("rfc")
        private String rfc;

        @Expose
        @SerializedName("address_id")
        private Long address_id;

        @Expose
        @SerializedName("user_id")
        private Long user_id;

        @Expose
        @SerializedName("created_at")
        private String created_at;

        @Expose
        @SerializedName("updated_at")
        private String updated_at;

        @Expose
        @SerializedName("deleted_at")
        private String deleted_at;

        @Expose
        @SerializedName("formatted_created_at")
        private String formatted_created_at;

        @Expose
        @SerializedName("formatted_updated_at")
        private String formatted_updated_at;

        @Expose
        @SerializedName("formatted_deleted_at")
        private String formatted_deleted_at;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
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

        public String getRfc() {
            return rfc;
        }

        public void setRfc(String rfc) {
            this.rfc = rfc;
        }

        public Long getAddress_id() {
            return address_id;
        }

        public void setAddress_id(Long address_id) {
            this.address_id = address_id;
        }

        public Long getUser_id() {
            return user_id;
        }

        public void setUser_id(Long user_id) {
            this.user_id = user_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(String deleted_at) {
            this.deleted_at = deleted_at;
        }

        public String getFormatted_created_at() {
            return formatted_created_at;
        }

        public void setFormatted_created_at(String formatted_created_at) {
            this.formatted_created_at = formatted_created_at;
        }

        public String getFormatted_updated_at() {
            return formatted_updated_at;
        }

        public void setFormatted_updated_at(String formatted_updated_at) {
            this.formatted_updated_at = formatted_updated_at;
        }

        public String getFormatted_deleted_at() {
            return formatted_deleted_at;
        }

        public void setFormatted_deleted_at(String formatted_deleted_at) {
            this.formatted_deleted_at = formatted_deleted_at;
        }
    }


    public static class Client {
        @Expose
        @SerializedName("contact")
        private Contact contact;

        @Expose
        @SerializedName("provider")
        private String provider;

        @Expose
        @SerializedName("id")
        private String id;

        @Expose
        @SerializedName("rfc")
        private String rfc;

        @Expose
        @SerializedName("name")
        private String name;

        @Expose
        @SerializedName("first_lastname")
        private String first_lastname;

        @Expose
        @SerializedName("second_lastname")
        private String second_lastname;

        @Expose
        @SerializedName("contact_id")
        private String contact_id;

        @Expose
        @SerializedName("provider_id")
        private String provider_id;

        @Expose
        @SerializedName("active")
        private String active;

        public Contact getContact() {
            return contact;
        }

        public void setContact(Contact contact) {
            this.contact = contact;
        }

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRfc() {
            return rfc;
        }

        public void setRfc(String rfc) {
            this.rfc = rfc;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirst_lastname() {
            return first_lastname;
        }

        public void setFirst_lastname(String first_lastname) {
            this.first_lastname = first_lastname;
        }

        public String getSecond_lastname() {
            return second_lastname;
        }

        public void setSecond_lastname(String second_lastname) {
            this.second_lastname = second_lastname;
        }

        public String getContact_id() {
            return contact_id;
        }

        public void setContact_id(String contact_id) {
            this.contact_id = contact_id;
        }

        public String getProvider_id() {
            return provider_id;
        }

        public void setProvider_id(String provider_id) {
            this.provider_id = provider_id;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }
    }


    public static class Driver {
        @Expose
        @SerializedName("carrier")
        private Carrier carrier;

        @Expose
        @SerializedName("user")
        private User user;

        @Expose
        @SerializedName("id")
        private Long id;

        @Expose
        @SerializedName("name")
        private String name;

        @Expose
        @SerializedName("rfc")
        private String rfc;

        @Expose
        @SerializedName("address_id")
        private Long address_id;

        @Expose
        @SerializedName("user_id")
        private Long user_id;

        @Expose
        @SerializedName("created_at")
        private String created_at;

        @Expose
        @SerializedName("updated_at")
        private String updated_at;

        @Expose
        @SerializedName("deleted_at")
        private String deleted_at;

        @Expose
        @SerializedName("formatted_created_at")
        private String formatted_created_at;

        @Expose
        @SerializedName("formatted_updated_at")
        private String formatted_updated_at;

        @Expose
        @SerializedName("formatted_deleted_at")
        private String formatted_deleted_at;

        public Carrier getCarrier() {
            return carrier;
        }

        public void setCarrier(Carrier carrier) {
            this.carrier = carrier;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
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

        public String getRfc() {
            return rfc;
        }

        public void setRfc(String rfc) {
            this.rfc = rfc;
        }

        public Long getAddress_id() {
            return address_id;
        }

        public void setAddress_id(Long address_id) {
            this.address_id = address_id;
        }

        public Long getUser_id() {
            return user_id;
        }

        public void setUser_id(Long user_id) {
            this.user_id = user_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(String deleted_at) {
            this.deleted_at = deleted_at;
        }

        public String getFormatted_created_at() {
            return formatted_created_at;
        }

        public void setFormatted_created_at(String formatted_created_at) {
            this.formatted_created_at = formatted_created_at;
        }

        public String getFormatted_updated_at() {
            return formatted_updated_at;
        }

        public void setFormatted_updated_at(String formatted_updated_at) {
            this.formatted_updated_at = formatted_updated_at;
        }

        public String getFormatted_deleted_at() {
            return formatted_deleted_at;
        }

        public void setFormatted_deleted_at(String formatted_deleted_at) {
            this.formatted_deleted_at = formatted_deleted_at;
        }
    }


    public static class  User {
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
        private String auth;

        @Expose
        @SerializedName("status")
        private String status;

        @Expose
        @SerializedName("contact_id")
        private Long contact_id;

        @Expose
        @SerializedName("company_id")
        private Long company_id;

        public Contact getContact() {
            return contact;
        }

        public void setContact(Contact contact) {
            this.contact = contact;
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

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAuth() {
            return auth;
        }

        public void setAuth(String auth) {
            this.auth = auth;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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
    }


    public static class Contact {
        @Expose
        @SerializedName("address")
        private Address address;

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

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public Email getEmail() {
            return email;
        }

        public void setEmail(Email email) {
            this.email = email;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getEmail_id() {
            return email_id;
        }

        public void setEmail_id(Long email_id) {
            this.email_id = email_id;
        }

        public Long getAddress_id() {
            return address_id;
        }

        public void setAddress_id(Long address_id) {
            this.address_id = address_id;
        }
    }


    public static class Email {
        @Expose
        @SerializedName("id")
        private Long id;

        @Expose
        @SerializedName("email_address")
        private String email_address;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getEmail_address() {
            return email_address;
        }

        public void setEmail_address(String email_address) {
            this.email_address = email_address;
        }
    }

    public static class InitialYardMuleDriver {
        @Expose
        @SerializedName("incidence")
        private String incidence;

        @Expose
        @SerializedName("user")
        private String user;

        @Expose
        @SerializedName("id")
        private Long id;

        @Expose
        @SerializedName("first_name")
        private String first_name;

        @Expose
        @SerializedName("last_name")
        private String last_name;

        @Expose
        @SerializedName("incidence_id")
        private Long incidence_id;

        @Expose
        @SerializedName("social_security_number")
        private String social_security_number;

        @Expose
        @SerializedName("driver_license_number")
        private String driver_license_number;

        @Expose
        @SerializedName("user_id")
        private Long user_id;

        @Expose
        @SerializedName("created_at")
        private String created_at;

        @Expose
        @SerializedName("updated_at")
        private String updated_at;

        @Expose
        @SerializedName("deleted_at")
        private String deleted_at;

        @Expose
        @SerializedName("formatted_created_at")
        private String formatted_created_at;

        @Expose
        @SerializedName("formatted_updated_at")
        private String formatted_updated_at;

        @Expose
        @SerializedName("formatted_deleted_at")
        private String formatted_deleted_at;

        public String getIncidence() {
            return incidence;
        }

        public void setIncidence(String incidence) {
            this.incidence = incidence;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public Long getIncidence_id() {
            return incidence_id;
        }

        public void setIncidence_id(Long incidence_id) {
            this.incidence_id = incidence_id;
        }

        public String getSocial_security_number() {
            return social_security_number;
        }

        public void setSocial_security_number(String social_security_number) {
            this.social_security_number = social_security_number;
        }

        public String getDriver_license_number() {
            return driver_license_number;
        }

        public void setDriver_license_number(String driver_license_number) {
            this.driver_license_number = driver_license_number;
        }

        public Long getUser_id() {
            return user_id;
        }

        public void setUser_id(Long user_id) {
            this.user_id = user_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(String deleted_at) {
            this.deleted_at = deleted_at;
        }

        public String getFormatted_created_at() {
            return formatted_created_at;
        }

        public void setFormatted_created_at(String formatted_created_at) {
            this.formatted_created_at = formatted_created_at;
        }

        public String getFormatted_updated_at() {
            return formatted_updated_at;
        }

        public void setFormatted_updated_at(String formatted_updated_at) {
            this.formatted_updated_at = formatted_updated_at;
        }

        public String getFormatted_deleted_at() {
            return formatted_deleted_at;
        }

        public void setFormatted_deleted_at(String formatted_deleted_at) {
            this.formatted_deleted_at = formatted_deleted_at;
        }
    }


    public static class ShippingStatus  {
        @Expose
        @SerializedName("id")
        private Long id;

        @Expose
        @SerializedName("name")
        private String name;

        @Expose
        @SerializedName("label")
        private String label;

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

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }


    public static class TrailerStatus {
        @Expose
        @SerializedName("id")
        private Long id;

        @Expose
        @SerializedName("name")
        private String name;

        @Expose
        @SerializedName("label")
        private String label;

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

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }


    public  static class Warehouse {
        @Expose
        @SerializedName("address")
        private Address address;

        @Expose
        @SerializedName("id")
        private Long id;

        @Expose
        @SerializedName("name")
        private String name;

        @Expose
        @SerializedName("plant_id")
        private Long plant_id;

        @Expose
        @SerializedName("address_id")
        private Long address_id;

        @Expose
        @SerializedName("deleted")
        private String deleted;

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
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

        public Long getPlant_id() {
            return plant_id;
        }

        public void setPlant_id(Long plant_id) {
            this.plant_id = plant_id;
        }

        public Long getAddress_id() {
            return address_id;
        }

        public void setAddress_id(Long address_id) {
            this.address_id = address_id;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }
    }


    public static class Address {
        @Expose
        @SerializedName("id")
        private Long id;

        @Expose
        @SerializedName("zipcode")
        private String zipcode;

        @Expose
        @SerializedName("street")
        private String street;

        @Expose
        @SerializedName("ext_number")
        private String ext_number;

        @Expose
        @SerializedName("int_number")
        private String int_number;

        @Expose
        @SerializedName("neighborhood")
        private String neighborhood;

        @Expose
        @SerializedName("latitud")
        private String latitud;

        @Expose
        @SerializedName("Longitude")
        private String Longitude;

        @Expose
        @SerializedName("state")
        private String state;

        @Expose
        @SerializedName("country")
        private String country;

        @Expose
        @SerializedName("city")
        private String city;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getExt_number() {
            return ext_number;
        }

        public void setExt_number(String ext_number) {
            this.ext_number = ext_number;
        }

        public String getInt_number() {
            return int_number;
        }

        public void setInt_number(String int_number) {
            this.int_number = int_number;
        }

        public String getNeighborhood() {
            return neighborhood;
        }

        public void setNeighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
        }

        public String getLatitud() {
            return latitud;
        }

        public void setLatitud(String latitud) {
            this.latitud = latitud;
        }

        public String getLongitude() {
            return Longitude;
        }

        public void setLongitude(String longitude) {
            Longitude = longitude;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    public static class Creator {

    }

    public static class FinalYardMuleDriver {

    }

    public static class Editor {

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

