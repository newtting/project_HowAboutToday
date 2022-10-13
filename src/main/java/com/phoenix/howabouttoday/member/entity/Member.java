package com.phoenix.howabouttoday.member.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long memberNum;

  /*로그인할 회원 아이디(이메일)*/
  @Column(name = "email", nullable = false, length = 50, unique = true)
  private String email;

  @Column(name = "pwd", nullable = false,length = 100) //패스워드
  private String pwd;

  @Column(name= "nickname", nullable = false,unique = true) //닉네임
  private String nickname;

  @Column(nullable = true)
  private String memberTel;


  @Enumerated(EnumType.STRING)
  private Code memberCode;

  private LocalDateTime joinDate;
  private LocalDateTime withdrawdate;

  private String memberOriginalFileName;
  private String memberSaveFileName;

}
