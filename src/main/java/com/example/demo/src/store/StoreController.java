package com.example.demo.src.store;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.store.model.GetStoreRes;
import com.example.demo.src.store.model.GetStoreSortRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/stores")
public class StoreController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final StoreProvider storeProvider;
    
    public StoreController(StoreProvider storeProvider) {
        this.storeProvider = storeProvider;
    }
      /** 음식점 조회 API
      * [GET] /stores
      * 음식점 이름으로 검색 API
      * [GET] /stores? storeName=
      *  @return BaseResponse<List<GetUserRes>>
      **/
    @ResponseBody
    @GetMapping("") // (GET) 127.0.0.1:9000/app/stores
    public BaseResponse<List<GetStoreRes>> getStores(@RequestParam(required = false) String storeName) {
        try{
            if(storeName == null){
                System.out.println("flag1");
                List<GetStoreRes> getStoresRes = storeProvider.getStores();
                return new BaseResponse<>(getStoresRes);
            }
            // Get Stores
            List<GetStoreRes> getStoresRes = storeProvider.getStoresByStoreName(storeName);
            return new BaseResponse<>(getStoresRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    @ResponseBody
    @GetMapping("") // (GET) 127.0.0.1:9000/app/stores
    public BaseResponse<List<GetStoreSortRes>> sortStoresSorted(@RequestParam(required = false) String order) {
        try{
            if(order == null){
                List<GetStoreSortRes> getStoresRes = storeProvider.getStoresSorted();
                return new BaseResponse<>(getStoresRes);
            }
            // Get Stores
            List<GetStoreSortRes> getStoresRes = storeProvider.getStoresSorted(order);
            return new BaseResponse<>(getStoresRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }
}
