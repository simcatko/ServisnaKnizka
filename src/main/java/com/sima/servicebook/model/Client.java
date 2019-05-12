package com.sima.servicebook.model;

import javax.persistence.*;

@Entity
@Table(name = "clients")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String meno;

    private Long serviceId;

    private String address;

    public Client () {

    }
    public Client(Long id, String meno, Long serviceId, String address) {
        this.id = id;
        this.meno = meno;
        this.serviceId = serviceId;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public  String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
