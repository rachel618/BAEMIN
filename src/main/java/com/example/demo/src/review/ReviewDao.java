package com.example.demo.src.review;

import com.example.demo.src.review.model.GetReviewRes;
import com.example.demo.src.user.model.GetUserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ReviewDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

//    public List<GetReviewRes> getReviews(int storeIdx){
//        String getReviewsQuery="select * from review where storeIdx=?";
//        int getReviewsParams= storeIdx;
//
//        return this.jdbcTemplate.query(getReviewsQuery,
//                (rs,rowNum) -> new GetReviewRes(
//                        rs.getInt("sIdx"),
//                        rs.getString("userName"),
//                        rs.getString("nickname"),
//                        rs.getString("password"),
//                        rs.getString("phoneNum"),
//                        rs.getString("userEmail"),
//                        rs.getInt("status")));
//
//    }
}
