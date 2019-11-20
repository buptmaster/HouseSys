package com.housesys.demo.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "houses")
public class House {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBuiltTime() {
        return builtTime;
    }

    public void setBuiltTime(String builtTime) {
        this.builtTime = builtTime;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String location;

    @Column(name = "built_time")
    private String builtTime;

    @Column(name = "sale_time")
    private Date saleTime;

    private double price;

    private String status;

    @OneToOne(cascade = CascadeType.DETACH)
    private User user;

}
