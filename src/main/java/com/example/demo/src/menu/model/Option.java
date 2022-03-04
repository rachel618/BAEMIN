package com.example.demo.src.menu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Option {
    private int optionIdx;
    private int menuIdx;
    private String optionName;
    private int optionCategory;
    private int optionPrice;
    public Option(){}
}
