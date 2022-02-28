package com.example.demo.src.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetOrderMenuRes {
    private int orderIdx;
    private String storeName;
    private List<String> menuName;
    private int price;
    private String orderDate;
}
