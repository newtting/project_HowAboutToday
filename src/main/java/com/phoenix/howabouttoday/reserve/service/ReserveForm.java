package com.phoenix.howabouttoday.reserve.service;

import com.phoenix.howabouttoday.accom.entity.Accommodation;
import com.phoenix.howabouttoday.room.entity.Room;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReserveForm {


    private LocalDateTime reserveUseStartDate;
    private LocalDateTime reserveUseEndDate;

    private int reserveAdultCount;
    private int reserveChildCount;
}
