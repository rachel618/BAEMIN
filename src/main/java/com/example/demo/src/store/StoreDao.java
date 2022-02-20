package com.example.demo.src.store;

import com.example.demo.src.store.model.GetStoreRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class StoreDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<GetStoreRes> getStores(){
        String getStoresQuery="select * from Store";
        return this.jdbcTemplate.query(getStoresQuery,
                (rs, rowNum) -> new GetStoreRes(
                        rs.getInt("storeIdx"),
                        rs.getString("storeName"),
                        rs.getString("address"),
                        rs.getInt("categoryIdx"),
                        rs.getInt("minPriceDelivery"),
                        rs.getInt("minPriceTakeout"),
                        rs.getInt("deliveryTime"),
                        rs.getInt("deliveryTip"),
//                        rs.getTime("operatingHours"),
                        rs.getString("profileImageUrl"),
                        rs.getString("introduction"),
                        rs.getString("origin"),
                        rs.getDouble("rating"),
                        rs.getString("newStore"),
                        rs.getString("couponAvailable"),
                        rs.getString("takeOut"))
                );

    }

}
