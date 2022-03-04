package com.example.demo.src.store;

import com.example.demo.src.store.model.GetOneDetailRes;
import com.example.demo.src.store.model.GetOneStoreRes;
import com.example.demo.src.store.model.GetOneStoreSortRes;
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

    public List<GetOneStoreRes> getStores(){
        String getStoresQuery="select storeName, address, minPriceDelivery, minDeliveryTime, maxDeliveryTime,minDeliveryTip, " +
                "profileImageUrl,rating, newStore,couponAvailable, takeOut from Store where storeIdx";
        return this.jdbcTemplate.query(getStoresQuery,
                (rs,rowNum) -> new GetOneStoreRes(
                        rs.getString("storeName"),
                        rs.getString("address"),
                        rs.getInt("minPriceDelivery"),
                        rs.getInt("minDeliveryTime"),
                        rs.getInt("maxDeliveryTime"),
                        rs.getInt("minDeliveryTip"),
                        rs.getString("profileImageUrl"),
                        rs.getDouble("rating"),
                        rs.getString("newStore"),
                        rs.getString("couponAvailable"),
                        rs.getString("takeOut"))
        );
    }
    public List<GetOneStoreSortRes> getOneStores(int categoryIdx){

        String getStoresQuery="select storeName,rating,minPriceDelivery,distance,minDeliveryTime,maxDeliveryTime, minDeliveryTip, " +
                "maxDeliveryTip,newStore,couponAvailable from Store where Store.categoryIdx=?";
        int getStoresParams= categoryIdx;

        return this.jdbcTemplate.query(getStoresQuery,
                (rs,rowNum)->new GetOneStoreSortRes(
                        rs.getString("storeName"),
                        rs.getDouble("rating"),
                        rs.getInt("minPriceDelivery"),
                        rs.getInt("distance"),
                        rs.getInt("minDeliveryTime"),
                        rs.getInt("maxDeliveryTime"),
                        rs.getInt("minDeliveryTip"),
                        rs.getInt("maxDeliveryTip"),
                        rs.getString("newStore"),
                        rs.getString("couponAvailable")), getStoresParams
        );
    }
    public List<GetOneStoreRes> getStoresbyStoreName(String storeName){
        String getStoresQuery="select storeName, address, minPriceDelivery, minDeliveryTime, maxDeliveryminDeliveryTip, " +
                "profileImageUrl,rating, newStore,couponAvailable, takeOut from Store where storeName=?";
        String getStoresbyStoreNameParams=storeName;
        return this.jdbcTemplate.query(getStoresQuery,
                (rs,rowNum) -> new GetOneStoreRes(
                        rs.getString("storeName"),
                        rs.getString("address"),
                        rs.getInt("minPriceDelivery"),
                        rs.getInt("minDeliveryTime"),
                        rs.getInt("maxDeliveryTime"),
                        rs.getInt("minDeliveryTip"),
                        rs.getString("profileImageUrl"),
                        rs.getDouble("rating"),
                        rs.getString("newStore"),
                        rs.getString("couponAvailable"),
                        rs.getString("takeOut")),
                getStoresbyStoreNameParams);
    }
    public List<GetOneStoreSortRes> getOneStoresSorted(){
        String getStoresQuery="select storeName, rating, minPriceDelivery, distance, minDeliveryTime, minDeliveryTip, maxDeliveryTip, newStore, couponAvailable" +
                " from Store ";

        return this.jdbcTemplate.query(getStoresQuery,
                (rs,rowNum) -> new GetOneStoreSortRes(
                        rs.getString("storeName"),
                        rs.getDouble("rating"),
                        rs.getInt("minPriceDelivery"),
                        rs.getDouble("distance"),
                        rs.getInt("minDeliveryTime"),
                        rs.getInt("maxDeliveryTime"),
                        rs.getInt("minDeliveryTip"),
                        rs.getInt("maxDeliveryTip"),
                        rs.getString("newStore"),
                        rs.getString("couponAvailable"))
        );
    }

    public List<GetOneStoreSortRes> getOneStoresSorted(String order){
        if(order=="rating") order += " desc"; // 별점은 높은순서로
        else //배달팁, 거리는 낮은 순
            order +=" asc";
        System.out.println(order);
        String getStoresQuery="select storeName, rating, minPriceDelivery, distance, minDeliveryTime, maxDeliveryTime, " +
                "minDeliveryTip, maxDeliveryTip, newStore, couponAvailable" +
                " from Store order by " + order ;

        return this.jdbcTemplate.query(getStoresQuery,
                (rs,rowNum) -> new GetOneStoreSortRes(
                        rs.getString("storeName"),
                        rs.getDouble("rating"),
                        rs.getInt("minPriceDelivery"),
                        rs.getDouble("distance"),
                        rs.getInt("minDeliveryTime"),
                        rs.getInt("maxDeliveryTime"),
                        rs.getInt("minDeliveryTip"),
                        rs.getInt("maxDeliveryTip"),
                        rs.getString("newStore"),
                        rs.getString("couponAvailable"))
        );
    }

    public GetOneDetailRes getOneStoresDetail(int storeIdx){
        String getStoresQuery="select storeName,address,minPriceDelivery, minDeliveryTime, maxDeliveryTime," +
                "minDeliveryTip, maxDeliveryTip, rating, storeType, numOfReviews from Store where storeIdx=?";
        int getStoresQueryParams= storeIdx;
        return this.jdbcTemplate.queryForObject(getStoresQuery,
                (rs,rowNum)-> new GetOneDetailRes(
                        rs.getString("storeName"),
                        rs.getString("address"),
                        rs.getInt("minPriceDelivery"),
                        rs.getInt("minDeliveryTime"),
                        rs.getInt("maxDeliveryTime"),
                        rs.getInt("minDeliveryTip"),
                        rs.getInt("maxDeliveryTip"),
                        rs.getDouble("rating"),
                        rs.getInt("storeType"),
                        rs.getInt("numOfReviews")),getStoresQueryParams
                );
    }

}
