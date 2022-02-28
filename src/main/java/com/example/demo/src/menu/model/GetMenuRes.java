package com.example.demo.src.menu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetMenuRes {
    private String menuName;
    private String menuDetail;
    private String foodImageUrl;
    private int price;
    private String mainMenu;
    private String popularMenu;
    private int menuCategory;
}
