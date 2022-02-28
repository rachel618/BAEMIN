package com.example.demo.src.order;

import com.example.demo.src.order.model.GetOrderRes;
import com.example.demo.src.user.model.GetUserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrderDao {
    private JdbcTemplate jdbcTemplate;

//    @Autowired
//    public void setDataSource(DataSource dataSource){
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }

//    public List<String> getMenus(int userIdx){
//        String getOrderQuery="select orderIdx from Order where userIdx=?";
//        String getMenuQuery="select me"
//    }
//    public List<GetOrderRes> getOrders(int userIdx){
//        String getOrdersQuery = "select storeName, price, orderDate from Order where userIdx=?";
//        int getOrdersQueryParams= userIdx;
//        return this.jdbcTemplate.query(getOrdersQuery,
//                (rs, rowNum) -> new GetOrderRes(
//                        rs.getInt("orderIdx"),
//                        rs.getString("storeName"),
//                        rs.getString("orderDate"))
//        );
//
//    }
}
