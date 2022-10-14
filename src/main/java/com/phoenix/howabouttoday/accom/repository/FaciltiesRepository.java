package com.phoenix.howabouttoday.accom.repository;

import com.phoenix.howabouttoday.accom.dto.FaciltiesDTO;
import com.phoenix.howabouttoday.accom.entity.Facilties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaciltiesRepository extends JpaRepository<Facilties, Long> {

    static List<FaciltiesDTO> findByAll() {
        return null;
    }
}
