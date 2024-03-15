package com.atguigu.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayDTO implements Serializable {

    private Integer id;
    //    支付流水号
    private String payNo;
    //    订单号
    private String orderNo;
    //    用户id
    private Integer userId;
    //    金额
    private BigDecimal amount;
}