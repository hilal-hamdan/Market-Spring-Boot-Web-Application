package com.example.market.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "iphonemobile")
public class IphoneMobile extends BaseEntity{

    @Id
    private int iphoneId;
    private String iphoneName;
    private String processor;
    private String camera;
    private Date released;
    private String screenSize;
    private String os;
    private String notableFeature;
    private String connectivity;
    private String storageOptions;
    private String batteryLife;
    private String dimensions;
    private double price;
    private Double maxBidAmount;
    private String img;


}
