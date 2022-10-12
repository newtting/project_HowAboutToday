package com.phoenix.howabouttoday.payment.repository;


import com.phoenix.howabouttoday.accom.entity.AccomImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccommodationImageRepository_ogirin extends JpaRepository<AccomImage, Long> {

    @Override
    <S extends AccomImage> S save(S entity);


    AccomImage findByAccomNum(Long number);

    @Override
    List<AccomImage> findAll();
}
