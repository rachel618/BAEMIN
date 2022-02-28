package com.example.demo.src.store;

import com.example.demo.config.BaseException;
import com.example.demo.src.store.model.GetOneDetailRes;
import com.example.demo.src.store.model.GetOneStoreRes;
import com.example.demo.src.store.model.GetOneStoreSortRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;
@Service
public class StoreProvider {
    private final StoreDao storeDao;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public StoreProvider(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public List<GetOneStoreRes> getOneStores() throws BaseException {
        try{
//            System.out.println("flag 2");
            List<GetOneStoreRes> getStoreRes = storeDao.getStores();
            return getStoreRes;
        }
        catch (Exception exception) {
//            System.out.println("error here");
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public List<GetOneStoreRes> getStoresByStoreName(String storeName) throws BaseException {
        try{
            List<GetOneStoreRes> getStoreRes = storeDao.getStoresbyStoreName(storeName);
            return getStoreRes;
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
    // 기본순 정렬
    public List<GetOneStoreSortRes> getOneStoresSorted() throws BaseException{
        try{
            List<GetOneStoreSortRes> getOneStoreSortRes=storeDao.getOneStoresSorted();
            return getOneStoreSortRes;
        }
        catch (Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }
    // 순서 지정할 때
    public List<GetOneStoreSortRes> getOneStoresSorted(String order) throws BaseException{
        try{
            System.out.println("flag");
            List<GetOneStoreSortRes> getOneStoreSortRes=storeDao.getOneStoresSorted(order);
            return getOneStoreSortRes;
        }
        catch (Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public GetOneDetailRes getOneStoresDetail(int storeIdx) throws BaseException {
        try{
            System.out.println("error provider");
            GetOneDetailRes getStoreRes = storeDao.getOneStoresDetail(storeIdx);
            return getStoreRes;
        }
        catch (Exception exception) {
            System.out.println("error here");
            throw new BaseException(DATABASE_ERROR);
        }
    }

}
