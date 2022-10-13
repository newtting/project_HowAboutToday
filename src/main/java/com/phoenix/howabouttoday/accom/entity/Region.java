package com.phoenix.howabouttoday.accom.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="T_REGION")
public class Region {

  @Id @GeneratedValue
  private Long regionNum;

  private String regionName;

  private int regionParentNum;
}
