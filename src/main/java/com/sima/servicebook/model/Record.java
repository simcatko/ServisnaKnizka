package com.sima.servicebook.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "records")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private float price;

    private String poznamka;

    private Long carId;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;

    private Integer type;


    public Record() {
    }

    public Record(Long id, Float price, String poznamka, Long carId, Date date, Integer type) {
        this.id = id;
        this.price = price;
        this.poznamka = poznamka;
        this.carId = carId;
        this.date = date;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Number getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}