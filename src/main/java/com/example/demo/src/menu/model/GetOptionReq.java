package com.example.demo.src.menu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetOptionReq {
    private int menuIdx;
    private String menuName;
    private int price;
    private List<Option> options;
    private int totalPrice;
}
