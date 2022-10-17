package com.phoenix.howabouttoday.payment.repository;

import com.phoenix.howabouttoday.payment.testDriver.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
}
