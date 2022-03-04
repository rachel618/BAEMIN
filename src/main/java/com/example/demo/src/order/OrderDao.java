package com.example.demo.src.order;

import com.example.demo.src.order.model.*;
import com.example.demo.src.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class OrderDao {
    private JdbcTemplate jdbcTemplate;
    UserDao userDao = new UserDao();

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

//    public List<String> getMenus(int userIdx){
//        String getOrderQuery="select orderIdx from Order where userIdx=?";
//        String getMenuQuery="select me"
//    }
//    public List<GetOrderRes> getOrders(int userIdx){
//        String getOrdersQuery = "select orderIdx,price,orderDate from Order where userIdx="+ userIdx;
//        List<GetOrderRes> Orders= this.jdbcTemplate.query(getOrdersQuery,
//                (rs, rowNum) -> new GetOrderRes(
//                        rs.getInt("orderIdx"),
//                        rs.getInt("price"),
//                        rs.getString("orderDate"))
//        );
//        String storeName,storeImageUrl;
//        for(GetOrderRes getOrderRes: Orders){
//            String getStoreNameQuery="select storeName, profileImage from Order,Store" +
//                    " where Order.storeIdx=store.storeIdx and Order.orderIdx="+ getOrderRes.getOrderIdx();
//            storeName=this.jdbcTemplate.queryForObject(getStoreNameQuery,String.class);
//
//            String getStoreIMageQuery="select profileImage from Order,Store" +
//                    " where Order.storeIdx=store.storeIdx and Order.orderIdx="+ getOrderRes.getOrderIdx();
//            storeImageUrl=this.jdbcTemplate.queryForObject(getStoreNameQuery,String.class);
//
//            String menuNamesQuery="select menuName from Menu,OrderMenu where OrderMenu.menuIdx=Menu.menuIdx and orderIdx="+getOrderRes.getOrderIdx();
//
//            getOrderRes.setStoreName(storeName);
//            getOrderRes.setProfileImage(storeImageUrl);
//        }
//
//    }
//
}
