package com.housesys.demo.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Buyer {

    private String name;

    @Id
    @NotNull
    @Column(name = "id_number", unique = true)
    private String idNumber;

    private String phone;

    private Integer houseId;

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
