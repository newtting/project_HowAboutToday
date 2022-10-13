package com.phoenix.howabouttoday.board.entity;



import com.phoenix.howabouttoday.payment.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table

public class Review {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long reviewNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_num")
    private Orders order;







}
