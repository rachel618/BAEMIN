package com.example.demo.src.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetStoreSortRes {
    private String storeName;
    private double rating;
    private int minPriceDelivery;
    private double distance;
    private int deliveryTime;
    private int deliveryTip;
    private String newStore;
    private String couponAvailable;

}
