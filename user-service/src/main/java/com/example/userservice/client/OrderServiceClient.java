package com.example.userservice.client;

import com.example.userservice.vo.ResponseOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order-service") // 호출하려는 마이크로서비스 이름
public interface OrderServiceClient {

    @GetMapping("/order-service/{userId}/orders") //해당 주소 직접 호출
    List<ResponseOrder> getOrders(@PathVariable String userId);
}
