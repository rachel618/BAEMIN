package com.example.demo.src.order;

import com.example.demo.config.BaseException;
import com.example.demo.src.order.model.GetOrderRes;
import com.example.demo.src.user.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class OrderProvider {
    private final OrderDao orderDao;

    public OrderProvider(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
//    public List<String> getMenus(int userIdx) throws BaseException{
//        try{
//            List<String> get
//        }
//    }
//    public List<GetOrderRes> getOrders(int userIdx) throws BaseException {
//        try{
//            List<GetOrderRes> getOrderRes = OrderDao.getOrders(userIdx);
//            return getOrderRes;
//        }
//        catch(Exception exception){
//            throw new BaseException(DATABASE_ERROR);
//        }
//    }

}
