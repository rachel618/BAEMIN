package com.example.demo.src.store;

import com.example.demo.config.BaseException;
import com.example.demo.src.store.StoreDao;
import com.example.demo.src.store.StoreDao;
import com.example.demo.src.store.model.GetStoreRes;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

public class StoreProvider {
    private final StoreDao storeDao;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public StoreProvider(StoreDao storeDao) {
        this.storeDao = storeDao;
    }
    public List<GetStoreRes> getStores() throws BaseException {
        try{
            List<GetStoreRes> getStoreRes = storeDao.getStores();
            return getStoreRes;
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }


}
