package com.example.demo.src.review;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.review.model.GetReviewRes;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("app/stores/{storeIdx}/reviews")
public class ReviewController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final ReviewProvider reviewProvider;
    @Autowired
    private final ReviewDao reviewDao;
    @Autowired
    private final ReviewService reviewService;

    public ReviewController(ReviewProvider reviewProvider, ReviewDao reviewDao, ReviewService reviewService) {
        this.reviewProvider = reviewProvider;
        this.reviewDao=reviewDao;
        this.reviewService=reviewService;
    }

//    @ResponseBody
//    @GetMapping("")
//    public BaseResponse<List<GetReviewRes>> getReviews(int storeIdx){
//        try{
//            List<GetReviewRes> getReviewsRes=ReviewProvider.getReviews(storeIdx);
//            return new BaseResponse<>(getReviewsRes);
//        } catch(BaseException exception){
//                return new BaseResponse<>((exception.getStatus()));
//        }
//    }

}
