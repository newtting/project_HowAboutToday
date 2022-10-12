package com.phoenix.howabouttoday.accom.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor

public class Facilties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long faciltiesNum;

    @Column
    private String faciltiesName;
}
