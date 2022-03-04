package com.example.demo.src.category;

import com.example.demo.config.BaseException;
import com.example.demo.src.category.model.Category;
import com.example.demo.src.store.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class CategoryProvider {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private final CategoryDao categoryDao;

    public CategoryProvider(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
    public List<GetOneStoreSortRes> getOneStores(int categoryIdx) throws BaseException {
        try{
            List<GetOneStoreSortRes> getStores=categoryDao.getOneStores(categoryIdx);
            return getStores;
        } catch (Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }
}

