package com.phoenix.howabouttoday.reserve.service;

import com.phoenix.howabouttoday.accom.entity.Accommodation;
import com.phoenix.howabouttoday.room.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ReserveForm {

    private LocalDate reserveUseStartDate;
    private LocalDate reserveUseEndDate;

    private int reserveAdultCount;
    private int reserveChildCount;


}
