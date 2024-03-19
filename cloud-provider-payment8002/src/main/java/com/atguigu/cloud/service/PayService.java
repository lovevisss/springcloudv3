package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

public interface PayService {
    public int add(Pay pay);
    public Pay getPayById(Integer id);
    public int deletePayById(Integer id);
    public int updatePay(Pay pay);
    public List<Pay> getAllPays();
}
