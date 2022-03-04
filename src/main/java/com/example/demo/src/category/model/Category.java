package com.example.demo.src.category.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Setter
@Getter
@AllArgsConstructor
public class Category {
    private int categoryIdx;
    private String imageUrl;
    private String categoryName;
    private Time createdAt;
    private Time updatedAt;
    private int categoryType; // 1.배민1, 2.배달 3.포장
}
