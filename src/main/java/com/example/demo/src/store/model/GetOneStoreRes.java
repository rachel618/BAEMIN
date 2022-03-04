package com.example.demo.src.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
public class GetOneStoreRes {
    private String storeName;
    private String address;
    private int minPriceDelivery;
    private int minDeliveryTime;
    private int maxDeliveryTime;
    private int minDeliveryTip;
    private String profileImageUrl;
    private double rating;
    private String newStore;
    private String couponAvailable;
    private String takeOut;
}
