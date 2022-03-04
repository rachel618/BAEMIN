package com.example.demo.src.menu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetMenuRes {
//    private int menuIdx;
//    private int storeIdx;
    private String menuName;
    private String menuDetail;
    private String foodImageUrl;
    private int price;
    private String popularMenu;
    private String recommendMenu;
    private int menuCategory;
}
