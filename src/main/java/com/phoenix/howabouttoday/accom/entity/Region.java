package com.phoenix.howabouttoday.accom.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table
@Builder
@AllArgsConstructor
public class Region {

  @Id @GeneratedValue
  private Long regionNum;

  private String regionName;

  private int regionParentNum;
}
