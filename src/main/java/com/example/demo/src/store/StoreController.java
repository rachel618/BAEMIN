package com.example.demo.src.store;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.store.model.GetOneStoreRes;
import com.example.demo.src.store.model.GetOneStoreSortRes;
import com.example.demo.src.store.model.GetOneDetailRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class StoreController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final StoreProvider storeProvider;
    
    public StoreController(StoreProvider storeProvider) {
        this.storeProvider = storeProvider;
    }

    /** 음식점 검색 API
      * [GET] /stores
      * 음식점 이름으로 검색 API
      * [GET] /stores? storeName=
      *  @return BaseResponse<List<GetUserRes>>
      **/
    @ResponseBody
    @GetMapping("/stores") // (GET) 127.0.0.1:9000/app/stores
    public BaseResponse<List<GetOneStoreRes>> getOneStores(@RequestParam(required = false) String storeName) {
        try{
            if(storeName == null){
                List<GetOneStoreRes> getStoresRes = storeProvider.getOneStores();
                return new BaseResponse<>(getStoresRes);
            }
            // Get Stores
            List<GetOneStoreRes> getStoresRes = storeProvider.getStoresByStoreName(storeName);
            return new BaseResponse<>(getStoresRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }
    /**
     * 카테고리별 매장조회
     * @param
     * @return store
     */
    @ResponseBody
    @GetMapping("/OneStores/{categoryIdx}") // (GET) 127.0.0.1:9000/app/stores
    public BaseResponse<List<GetOneStoreSortRes>> getStores(@PathVariable("categoryIdx") int categoryIdx) {
        try {
            System.out.println("error1");
            List<GetOneStoreSortRes> getStoresRes = storeProvider.getOneStores(categoryIdx);
            return new BaseResponse<>(getStoresRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    /**
     * 배민1 음식점 정렬 API
     * @param order
     * @return
     */
    @ResponseBody
    @GetMapping("/oneStores/sort") // (GET) 127.0.0.1:9000/app/stores
    public BaseResponse<List<GetOneStoreSortRes>> sortOneStoresSorted(@RequestParam(required = false) String order) {
        try{
            if(order == null){
                List<GetOneStoreSortRes> getStoresRes = storeProvider.getOneStoresSorted();
                return new BaseResponse<>(getStoresRes);
            }
            // Get Stores
            List<GetOneStoreSortRes> getStoresRes = storeProvider.getOneStoresSorted(order);
            return new BaseResponse<>(getStoresRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    /** 아직 테스트 안해
     * 배민 1 음식점 상세조회 => 댓글 수 까지 나오는 일반 배달 response 와 같음
     * @param storeIdx
     * @return
     */
    @ResponseBody
    @GetMapping("/oneStores/{storeIdx}") // (GET) 127.0.0.1:9000/app/users/:storeIdx
    public BaseResponse<GetOneDetailRes> getOneStores(@PathVariable("storeIdx") int storeIdx) {
        // Get Users
        try{
            GetOneDetailRes getOneDetailRes = storeProvider.getOneStoresDetail(storeIdx);
            return new BaseResponse<>(getOneDetailRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }

    }

    /**
     * 배달 음식점 정보조회 API
     * @param storeIdx
     * @return GetStoreRes
     */


}
