package com.sima.servicebook.model;

import javax.persistence.*;
import javax.swing.*;
import java.util.Date;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String spz;

    private String vin;

    private String farba;

    private String znacka;

    private Integer rokVyroby;

    private Long clientId;


    public Car() {
    }

    public Car(Long id, String spz, String vin, String farba, String znacka, Integer rokVyroby, Long clientId) {
        this.id = id;
        this.spz = spz;
        this.vin = vin;
        this.farba = farba;
        this.znacka = znacka;
        this.rokVyroby = rokVyroby;
        this.clientId = clientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getSpz() {
        return spz;
    }

    public void setSpz(String spz) {
        this.spz = spz;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin ) {
        this.vin = vin;
    }

    public String getFarba() {
        return farba;
    }

    public void setFarba(String farba) {
        this.farba = farba;
    }

    public Integer getRokVyroby() {
        return rokVyroby;
    }

    public void setRokVyroby(Integer rokVyroby) {
        this.rokVyroby = rokVyroby;
    }

    public String getZnacka() {
        return znacka;
    }

    public void setZnacka(String znacka) {
        this.znacka = znacka;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}