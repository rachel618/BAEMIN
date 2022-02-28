package com.example.demo.src.menu;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.menu.model.*;
import com.example.demo.src.user.model.PostLoginReq;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static com.example.demo.config.BaseResponseStatus.*;
import java.util.List;

@RestController
@RequestMapping("app/stores/{storeIdx}/menu")
public class MenuController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private final MenuProvider menuProvider;
    @Autowired
    private final  MenuDao menuDao;

    public MenuController(MenuProvider menuProvider, MenuDao menuDao) {
        this.menuProvider = menuProvider;
        this.menuDao = menuDao;
    }

    @ResponseBody
    @GetMapping("")
    public BaseResponse<List<GetMenuRes>> getMenus(int storeIdx){
        try{
            List<GetMenuRes> getMenuRes=menuProvider.getMenus(storeIdx);
            return new BaseResponse<>(getMenuRes);
        }catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }
}
