package com.example.demo.src.menu;

import com.example.demo.src.menu.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MenuDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


//    public List<GetMenuRes> test(int storeIdx){
//        String getMenusQuery="select * from Menu,Store where Store.storeIdx= Menu.storeIdx and Menu.storeIdx=?";
//
//        int getMenusParams=storeIdx;
//        return this.jdbcTemplate.query(getMenusQuery,
//                (rs,rowNum)-> new GetMenuRes(
//                        rs.getInt("menuIdx"),
//                        rs.getInt("storeIdx"),
//                        rs.getString("menuName"),
//                        rs.getString("menuDetail"),
//                        rs.getString("foodImageUrl"),
//                        rs.getInt("price"),
//                        rs.getString("mainMenu"),
//                        rs.getString("popularMenu"),
//                        rs.getString("recommendMenu"),
//                        rs.getInt("menuCategory")), getMenusParams
//        );
//
//    }menuIdx,Menu.storeIdx,
    public List<GetMenuRes> getMenus(int storeIdx){
        String getMenusQuery="select menuName,menuDetail,foodImageUrl,price,popularMenu,recommendMenu,menuCategory " +
                "from Store,Menu where Store.storeIdx= Menu.storeIdx and Menu.storeIdx=? order by menuCategory asc";
//        String getMenusQuery="select * from Menu,Store where Store.storeIdx= Menu.storeIdx and Menu.storeIdx=?";
        int getMenusParams=storeIdx;
        return this.jdbcTemplate.query(getMenusQuery,
                (rs,rowNum)-> new GetMenuRes(
                        rs.getString("menuName"),
                        rs.getString("menuDetail"),
                        rs.getString("foodImageUrl"),
                        rs.getInt("price"),
                        rs.getString("popularMenu"),
                        rs.getString("recommendMenu"),
                        rs.getInt("menuCategory")), getMenusParams
                );

    }

}
