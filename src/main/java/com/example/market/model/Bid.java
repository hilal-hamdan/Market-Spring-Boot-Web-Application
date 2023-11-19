package com.example.market.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "bid")

public class Bid extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native" , strategy = "native")
    private int bidId;

    @NotNull(message = "User ID must not be null")
    private int userId;

    @NotNull(message = "iPhone ID must not be null")
    private int iphoneId;

    @NotNull(message = "amount must not be null")
    private double bidAmount;

}
