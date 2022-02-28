package com.example.demo.src.review;

import com.example.demo.config.BaseException;
import com.example.demo.src.review.model.GetReviewRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class ReviewProvider {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ReviewDao reviewDao;

    public ReviewProvider(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

//    public List<GetReviewRes> getReviews(int storeIdx) throws BaseException {
//        try {
//            List<GetReviewRes> getReviewsRes = ReviewDao.getReviews(storeIdx);
//            return getReviewsRes;
//        }catch(Exception exception){
//            throw new BaseException(DATABASE_ERROR);
//        }
//    }
}
