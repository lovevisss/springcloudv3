package com.atguigu.cloud.apis;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "cloud-payment-service")
public interface PayFeignApi {

    @PostMapping("/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);

    @PostMapping("/pay/delete")
    public ResultData deletePay(@RequestBody Integer id);

    @PostMapping("/pay/update")
    public ResultData updatePay(@RequestBody PayDTO payDTO);

    @PostMapping("/pay/get/{id}")
    public ResultData getPay(@PathVariable("id") Integer id);

    @GetMapping("/pay/get/info")
    public ResultData getInfo();
}
