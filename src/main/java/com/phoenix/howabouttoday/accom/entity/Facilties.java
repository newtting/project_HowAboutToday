package com.phoenix.howabouttoday.accom.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="T_FACILTIES")
public class Facilties {

    @Id
    @GeneratedValue
    @Column
    private Long faciltiesNum;//시설  번호

    @Column
    private String faciltiesName;//시설이름
}
