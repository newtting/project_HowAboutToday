package com.phoenix.howabouttoday.reserve.cart.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;
import static lombok.AccessLevel.*;

@Entity
@Table(name = "T_CART")
@Getter
@NoArgsConstructor(access = PROTECTED)
@ToString(of = {"cartNum","useStart","useEnd","price"})
public class Cart {

    @Id @GeneratedValue
    @Column(name = "cartNum")
    private String cartNum;

//    @ManyToOne(fetch = LAZY)
//    @JoinColumn(name = "memberNum")
//    private Member member;

//    @ManyToOne(fetch = LAZY)
//    @JoinColumn(name = "accomNum")
//    private Accom accom;

//    @ManyToOne(fetch = LAZY)
//    @JoinColumn(name = "roomNum")
//    private Room room;

    @Column(name = "useStart")
    private LocalDateTime useStart;

    @Column(name = "useEnd")
    private LocalDateTime useEnd;

    @Column(name = "price")
    private int price;



}
