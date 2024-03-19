package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;

    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        ResultData resultData = payFeignApi.addPay(payDTO);
        return resultData;
    }

    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPay(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/get/" + id, ResultData.class, id);
    }

    @GetMapping("/consumer/pay/getAll")
    public ResultData getAllPays() {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/getAll", ResultData.class);
    }

    @GetMapping("/consumer/pay/delete/{id}")
    public ResultData deletePay(@PathVariable("id") Integer id) {
        restTemplate.delete(PAYMENT_URL + "/pay/delete/" + id);
        return ResultData.success("删除成功");
//        return restTemplate.getForObject(PAYMENT_URL + "/pay/delete/" + id, ResultData.class, id);
    }

    @GetMapping("/consumer/pay/update")
    public ResultData updatePay(PayDTO payDTO) {
        restTemplate.put(PAYMENT_URL + "/pay/update", payDTO);
//        return restTemplate.patchForObject(PAYMENT_URL + "/pay/update", payDTO, ResultData.class);
        return ResultData.success("修改成功");
    }

    @GetMapping("/consumer/pay/get/info")
    public String getInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/get/info", String.class);
    }



}
