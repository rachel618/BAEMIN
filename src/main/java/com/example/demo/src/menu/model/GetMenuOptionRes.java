package com.example.demo.src.menu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetMenuOptionRes {
    private String menuName;
    private String foodImageURl;
    private int price;
    private List<Option> options;
    private int totalPrice;
}
