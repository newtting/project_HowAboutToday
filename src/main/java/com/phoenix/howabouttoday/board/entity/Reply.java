package com.phoenix.howabouttoday.board.entity;

import com.phoenix.howabouttoday.member.entity.Member;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_num")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_num")
    private Review review;




}
