package com.example.demo.src.store;

import com.example.demo.config.BaseException;
import com.example.demo.src.store.model.GetStoreRes;
import com.example.demo.src.store.model.GetStoreSortRes;
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

    public List<GetStoreRes> getStores() throws BaseException {
        try{
//            System.out.println("flag 2");
            List<GetStoreRes> getStoreRes = storeDao.getStores();
            return getStoreRes;
        }
        catch (Exception exception) {
//            System.out.println("error here");
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public List<GetStoreRes> getStoresByStoreName(String storeName) throws BaseException {
        try{
            List<GetStoreRes> getStoreRes = storeDao.getStoresbyStoreName(storeName);
            return getStoreRes;
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public List<GetStoreSortRes> getStoresSorted() throws BaseException{
        try{
            List<GetStoreSortRes> getStoreSortRes=storeDao.getStoresSorted();
            return getStoreSortRes;
        }
        catch (Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public List<GetStoreSortRes> getStoresSorted(String order) throws BaseException{
        try{
            List<GetStoreSortRes> getStoreSortRes=storeDao.getStoresSorted(order);
            return getStoreSortRes;
        }
        catch (Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }



}
