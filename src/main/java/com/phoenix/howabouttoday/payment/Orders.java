
package com.phoenix.howabouttoday.payment;

import com.phoenix.howabouttoday.reserve.domain.Reservation.Reservation;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Orders {

    @Id
    @GeneratedValue
    private Long ordersNum;

    @NotNull
    @Column(length = 50)
    private String ordersTel;

    @NotNull
    @Column(length = 50)
    private String ordersName;


    @Column(length = 50)
    private String ordersDate;

    @NotNull
    private Long ordersPrice;

    @NotNull
    @Column(length = 50)
    private String ordersType;

    @NotNull
    @Column(length = 50)
    private String ordersStatus;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<Reservation> reservation = new ArrayList<>(); //이미지 fk를 위한 매핑

    @Builder
    public Orders(Long ordersNum, String ordersTel, String ordersName, String ordersDate, Long ordersPrice, String ordersType, String ordersStatus) {
        this.ordersNum = ordersNum;
        this.ordersTel = ordersTel;
        this.ordersName = ordersName;
        this.ordersDate = ordersDate;
        this.ordersPrice = ordersPrice;
        this.ordersType = ordersType;
        this.ordersStatus = ordersStatus;
    }
}