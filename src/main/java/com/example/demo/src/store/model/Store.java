package com.example.demo.src.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
public class Store {
    private int storeIdx;
    private String storeName;
    private String address;
    private int categoryIdx;
    private int minPriceDelivery;
    private int minPriceTakeout;
    private int minDeliveryTime;
    private int mixDeliveryTime;
    private int minDeliveryTip;
    private int maxDeliveryTip;
    private String operatingHours;
    private String profileImageUrl;
    private String introduction;
    private String origin;
    private double rating;
    private String newStore;
    private String couponAvailable;
    private String takeOut;
    private double distance;
    private int storeType;
    private int numOfReviews;
}
