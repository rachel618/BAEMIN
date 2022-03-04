package com.example.demo.src.order;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.menu.model.GetOrderMenuReq;
import com.example.demo.src.order.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.config.BaseResponseStatus.*;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class OrderService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final OrderDao orderDao;
    @Autowired
    private final OrderProvider orderProvider;

    public OrderService(OrderDao orderDao, OrderProvider orderProvider) {
        this.orderDao = orderDao;
        this.orderProvider = orderProvider;
    }

//    public PostOrderRes createOrder(PostOrderReq postOrderReq) throws BaseException {
//        try{
//            PostOrderRes postOrderRes=orderDao.createOrder(postOrderReq);
//            return postOrderRes;
//        }catch(Exception ignored){
//          throw new BaseException(DATABASE_ERROR);
//        }
//    }

//    public PostOrderReq orderMenu(GetOrderMenuReq getOrderMenuReq) throws BaseException{
//        try{
//            PostOrderReq postOrderReq= orderDao.orderMenu(getOrderMenuReq);
//            return postOrderReq;
//        }catch(BaseException exception){
//            return new BaseResponse(DATABASE_ERROR);
//        }


}
