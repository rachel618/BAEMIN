package com.example.demo.src.order;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.menu.model.GetOrderMenuReq;
import com.example.demo.src.order.model.PostOrderReq;
import com.example.demo.src.order.model.PostOrderRes;
import com.example.demo.utils.JwtService;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/orders")
public class OrderController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final OrderProvider orderProvider;
    @Autowired
    private final OrderService orderService;
    @Autowired
    private final JwtService jwtService;

    public OrderController(OrderProvider orderProvider, OrderService orderService, JwtService jwtService) {
        this.orderProvider = orderProvider;
        this.orderService = orderService;
        this.jwtService = jwtService;
    }
//
//    @ResponseBody
//    @GetMapping("")
//    public BaseResponse<List<GetOrderRes>> getOrders(@PathVariable("orderIdx")int orderIdx){
//        try{
//            List<GetOrderRes> getOrderRes = orderProvider.getOrders(orderIdx);
//            return new BaseResponse<>(getOrderRes);
//        } catch(BaseException exception){
//            return new BaseResponse<>((exception.getStatus()));
//        }
//    }

    /**
     *
     * @param GEtOrderReq
     * @return BaseResponse<postOrderRes>
     */
//    @ResponseBody
//    @PostMapping("/{userIdx}/order")
//    public BaseResponse<PostOrderRes> createOrder(@RequestBody GetOrderMenuReq getOrderMenuReq){
//        PostOrderReq postOrderReq;
//        try {
//            postOrderReq = orderService.orderMenu(getOrderMenuReq);
//        }catch(BaseException exception){
//            return new BaseResponse<>((exception.getStatus()));
//
//        try{
//            PostOrderRes postOrderRes=orderService.createOrder(postOrderReq);
//            return new BaseResponse<>(postOrderRes);
//        }catch(BaseException exception_){
//            return new BaseResponse<>((exception_.getStatus()));
//        }
//    }



}
