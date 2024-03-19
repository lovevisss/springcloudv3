package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Tag(name = "支付微服务模块", description = "支付CRUD")
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping("/pay/add")
    @Operation(summary = "新增", description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        System.out.println(pay.toString());
        int add = payService.add(pay);
        return ResultData.success("成功插入记录 返回值：" + add);
    }

    @DeleteMapping("/pay/delete/{id}")
    @Operation(summary = "删除", description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        int delete = payService.deletePayById(id);
        return ResultData.success(delete);
    }

    @PutMapping("/pay/update")
    @Operation(summary = "修改", description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int update = payService.updatePay(pay);
        return ResultData.success("成功更新记录 返回值：" + update);
    }

    @GetMapping("/pay/get/{id}")
    @Operation(summary = "按照ID查流水", description = "查询支付流水方法")
    public ResultData<Pay> getPay(@PathVariable("id") Integer id) {
        if (id == -4) {
            throw new RuntimeException("没有此记录");
        }
        return ResultData.success(payService.getPayById(id));
    }

    @GetMapping("/pay/getAll")
    @Operation(summary = "查询所有流水", description = "查询所有支付流水方法")
    public ResultData<String> getAllPays() {
        return ResultData.success(payService.getAllPays().toString());
    }

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/pay/get/info")
    public String getInfoFromConsul(@Value("${zufedfc.info}") String Info) {
        return "zufedfc.info: " + Info + " serverPort: " + serverPort;
    }
}
