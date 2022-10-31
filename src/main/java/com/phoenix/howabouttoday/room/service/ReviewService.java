package com.phoenix.howabouttoday.room.service;

import com.phoenix.howabouttoday.room.dto.*;

import java.time.LocalDate;
import java.util.List;

public interface ReviewService {
    Boolean isReserve(Long memberNum, Long roomNum);
    Boolean isPassedTwoWeeks(Long memberNum, Long roomNum, LocalDate localDate);

}