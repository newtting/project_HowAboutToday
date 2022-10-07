package com.phoenix.howabouttoday.payment.repository;


import com.phoenix.howabouttoday.payment.entity.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    Accommodation findByAccomnum(Long number);

    @Override
    List<Accommodation> findAll();
}
