package com.example.demo.src.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetOneStoreSortRes {
    private String storeName;
    private double rating;
    private int minPriceDelivery;
    private double distance;
    private int minDeliveryTime;
    private int maxDeliveryTime;
    private int minDeliveryTip;
    private int maxDeliveryTip;
    private String newStore;
    private String couponAvailable;
//    private int storeType;
}
