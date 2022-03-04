package com.example.demo.src.menu;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.menu.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class MenuController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private final MenuProvider menuProvider;


    public MenuController(MenuProvider menuProvider) {
        this.menuProvider = menuProvider;
    }

    @ResponseBody
    @GetMapping("/stores/{storeIdx}/menu")
    public BaseResponse<List<GetMenuRes>> getMenus(@PathVariable("storeIdx") int storeIdx){
        try{
            List<GetMenuRes> getMenuRes =menuProvider.getMenus(storeIdx);
            return new BaseResponse<>(getMenuRes);
        }catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

//    @ResponseBody
//    @GetMapping("/oneStores/{storeIdx}")
//    public BaseResponse<List<GetMenuRes>> test(@PathVariable("storeIdx") int storeIdx){
//        try{
//            List<GetMenuRes> getOneStoreMenuRes =menuProvider.test(storeIdx);
//            return new BaseResponse<>(getOneStoreMenuRes);
//        }catch(BaseException exception){
//            return new BaseResponse<>((exception.getStatus()));
//        }
//    }

}
