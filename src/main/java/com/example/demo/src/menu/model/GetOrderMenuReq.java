package com.example.demo.src.menu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetOrderMenuReq {
    private String storeName;
    private List<GetMenuOptionRes> menus;
    private int price;
    private int deliveryTip;
    private int totalPrice;
}
