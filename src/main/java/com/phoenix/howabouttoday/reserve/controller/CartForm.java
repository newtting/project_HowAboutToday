package com.phoenix.howabouttoday.reserve.controller;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CartForm {

    private String check_in;
    private String check_out;
    private int adultQty;
    private int childQty;


}
