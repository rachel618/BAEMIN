package com.example.demo.src.menu;

import com.example.demo.src.menu.model.GetMenuRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MenuDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<GetMenuRes> getMenus(int storeIdx){
        String getMenusQuery="select menuName, menuDetail, foodImageUrl, price, mainMenu, popularMenu, menuCategory" +
                "from Store where storeIdx=? order by menuCategory asc";
        int getMenusParams=storeIdx;

        return this.jdbcTemplate.query(getMenusQuery,
                (rs,rowNum)-> new GetMenuRes(
                        rs.getString("menuName"),
                        rs.getString("menuDetail"),
                        rs.getString("foodImageUrl"),
                        rs.getInt("price"),
                        rs.getString("mainMenu"),
                        rs.getString("popularMenu"),
                        rs.getInt("menuCategory")), getMenusParams
                );

    }

}
