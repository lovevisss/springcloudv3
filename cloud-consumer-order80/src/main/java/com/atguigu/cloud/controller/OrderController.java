package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PAYMENT_URL + "/pay/add", payDTO, ResultData.class);
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



}
