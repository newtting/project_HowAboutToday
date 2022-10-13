
package com.phoenix.howabouttoday.payment;

import com.phoenix.howabouttoday.reserve.domain.Reservation.Reservation;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private Long roomNum;

    @Column(length = 50)
    private String ordersData;

    @NotNull
    private Long reserveNum;

    @NotNull
    private Long ordersPrice;

    @NotNull
    @Column(length = 50)
    private String ordersType;

    @NotNull
    @Column(length = 50)
    private String ordersStatus;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<Reservation> reservation;    //이미지 fk를 위한 매핑




}