package com.phoenix.howabouttoday.accom.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="T_ACCOMMODATION")
public class AccomViewFacilties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long accomNum;

    @Column
    private String facilties;
}
