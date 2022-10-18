package com.phoenix.howabouttoday.accom.repository;


import com.phoenix.howabouttoday.accom.dto.AccommodationDTO;
import com.phoenix.howabouttoday.accom.entity.Accommodation;
import com.phoenix.howabouttoday.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    @Override
    <S extends Accommodation> S save(S entity);

    Accommodation findByAccomNum(Long number);

    @Override
    List<Accommodation> findAll();

    List<Accommodation> findByAccomNameContaining(String keyword);

}
