package com.example.demo.src.review.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Review {
    private int userIdx;
    private int storeIdx;
    private double rating;
    private String comment;
    private String createdAt;
    private int status;
    private int orderIdx;
    private int photoUrl;
}
