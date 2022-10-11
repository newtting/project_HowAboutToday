package com.phoenix.howabouttoday.payment.repository;


import com.phoenix.howabouttoday.payment.entity.AccommodationImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccommodationImageRepository extends JpaRepository<AccommodationImage, Long> {

    @Override
    <S extends AccommodationImage> S save(S entity);


    AccommodationImage findByAccomNum(Long number);

    @Override
    List<AccommodationImage> findAll();
}
