package com.example.demo.src.store;

import com.example.demo.src.store.model.GetStoreRes;
import com.example.demo.src.store.model.GetStoreSortRes;
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
        String getStoresQuery="select storeName, address, minPriceDelivery, minPriceTakeout, deliveryTime,deliveryTip, " +
                "profileImageUrl,rating, newStore,couponAvailable, takeOut from Store";
        return this.jdbcTemplate.query(getStoresQuery,
                (rs,rowNum) -> new GetStoreRes(
                        rs.getString("storeName"),
                        rs.getString("address"),
                        rs.getInt("minPriceDelivery"),
                        rs.getInt("minPriceTakeout"),
                        rs.getInt("deliveryTime"),
                        rs.getInt("deliveryTip"),
                        rs.getString("profileImageUrl"),
                        rs.getDouble("rating"),
                        rs.getString("newStore"),
                        rs.getString("couponAvailable"),
                        rs.getString("takeOut"))
        );
    }

    public List<GetStoreRes> getStoresbyStoreName(String storeName){
        String getStoresQuery="select storeName, address, minPriceDelivery, minPriceTakeout, deliveryTime,deliveryTip, " +
                "profileImageUrl,rating, newStore,couponAvailable, takeOut from Store where storeName=?";
        String getStoresbyStoreNameParams=storeName;
        return this.jdbcTemplate.query(getStoresQuery,
                (rs,rowNum) -> new GetStoreRes(
                        rs.getString("storeName"),
                        rs.getString("address"),
                        rs.getInt("minPriceDelivery"),
                        rs.getInt("minPriceTakeout"),
                        rs.getInt("deliveryTime"),
                        rs.getInt("deliveryTip"),
                        rs.getString("profileImageUrl"),
                        rs.getDouble("rating"),
                        rs.getString("newStore"),
                        rs.getString("couponAvailable"),
                        rs.getString("takeOut")),
                getStoresbyStoreNameParams);
    }
    public List<GetStoreSortRes> getStoresSorted(){
        String getStoresQuery="select storeName, rating, minPriceDelivery, distance, deliveryTime, deliveryTip, newStore, couponAvailable" +
                " from Store ";

        return this.jdbcTemplate.query(getStoresQuery,
                (rs,rowNum) -> new GetStoreSortRes(
                        rs.getString("storeName"),
                        rs.getDouble("rating"),
                        rs.getInt("minPriceDelivery"),
                        rs.getDouble("deliveryTime"),
                        rs.getInt("deliveryTime"),
                        rs.getInt("deliveryTip"),
                        rs.getString("newStore"),
                        rs.getString("couponAvailable"))
        );
    }

    public List<GetStoreSortRes> getStoresSorted(String order){
        if(order=="rating") order += " desc"; // 별점은 높은순서로
        else //배달팁, 거리는 낮은 순
            order +="asc";
        String getStoresQuery="select storeName, rating, minPriceDelivery, distance, deliveryTime, deliveryTip, newStore, couponAvailable" +
                " from Store order by " + order ;

        return this.jdbcTemplate.query(getStoresQuery,
                (rs,rowNum) -> new GetStoreSortRes(
                        rs.getString("storeName"),
                        rs.getDouble("rating"),
                        rs.getInt("minPriceDelivery"),
                        rs.getDouble("deliveryTime"),
                        rs.getInt("deliveryTime"),
                        rs.getInt("deliveryTip"),
                        rs.getString("newStore"),
                        rs.getString("couponAvailable"))
        );
    }
}
