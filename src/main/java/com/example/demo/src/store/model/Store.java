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
    private int categoryIdx;
    private int minPriceDelivery;
    private int maxDeliveryTip;
    private String operatingHours;
    private String profileImageUrl;
    private int minDeliveryTime;
    private int maxDeliveryTime;
    private int minDeliveryTip;
    private String holiday;
    private String introduction;
    private String origin;
    private String brandName;
    private double rating;
    private String newStore;
    private String couponAvailable;
    private String takeOut;
    private String address;
    private double distance;
    private int storeType;
    private int numOfReviews;
    private Time createdAt;
    private Time updatedAt;
    private int status;
}
