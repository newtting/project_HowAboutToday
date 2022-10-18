package com.phoenix.howabouttoday.reserve.domain;

import com.phoenix.howabouttoday.payment.controller.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
