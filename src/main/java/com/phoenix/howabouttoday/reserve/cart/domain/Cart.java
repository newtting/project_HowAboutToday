package com.phoenix.howabouttoday.reserve.cart.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "T_CART")
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
