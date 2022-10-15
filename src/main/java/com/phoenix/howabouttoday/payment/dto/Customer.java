package com.phoenix.howabouttoday.payment.dto;

import com.phoenix.howabouttoday.member.entity.Code;
import com.phoenix.howabouttoday.payment.entity.Orders;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Customer {

    private Long num;

    private String name;

    private String tel;

    private Code code;


    //얘도 Customer와 마찬가지로 entity를 직접 가지고 있는 것은 좋아 보이지 않는다.
    private List<Orders> orders = new ArrayList<>();

    @Builder

    public Customer(Long num, String name, String tel, Code code, List<Orders> orders) {
        this.num = num;
        this.name = name;
        this.tel = tel;
        this.code = code;
        this.orders = orders;
    }
}
