package com.phoenix.howabouttoday.accom.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
@Table(name="T_ACCOMMODATION")
public class Region {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long regionNum;

  @Column
  private String regionName;  //지역이름

  @Column
  private String regionParentNum;//부모번호


}
