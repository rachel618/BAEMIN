package com.example.demo.src.menu;

import com.example.demo.config.BaseException;
import com.example.demo.src.menu.model.GetMenuRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class MenuProvider {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MenuDao menuDao;

    public MenuProvider(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public List<GetMenuRes> getMenus(int storeIdx) throws BaseException{
        try{
//            System.out.println("flag 2");
            List<GetMenuRes> getMenusRes = menuDao.getMenus(storeIdx);
            return getMenusRes;
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
