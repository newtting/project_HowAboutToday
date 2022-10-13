package com.phoenix.howabouttoday.board.entity;

import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.payment.Order;
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
@Table(name="T_REPLY")

public class Reply {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long reply_num;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_num")
    private Member member;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_num")
    private Review review;




}
