package com.phoenix.howabouttoday.payment.dto;

import com.phoenix.howabouttoday.accom.RegionType;
import com.phoenix.howabouttoday.accom.RegionTypeConverter;
import com.phoenix.howabouttoday.accom.entity.Region;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import java.time.LocalDateTime;

@Getter
@Builder
public class CheckOutAccomRoomDTO {

    private String accomName;
    private String roomName;
    private String checkIn;
    private String checkOut;
    private String region;
    private Integer night;
    private Integer guest;
    private String service;
    private Integer price;
}

