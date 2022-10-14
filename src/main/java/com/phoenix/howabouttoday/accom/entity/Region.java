package com.phoenix.howabouttoday.accom.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Region {

  @Id @GeneratedValue
  private Long regionNum;

  @Column(length = 50)
  @Convert(converter = RegionTypeConverter.class)
  private RegionType region;

  private Integer regionParentNum;

  @Builder
  public Region(RegionType region, Integer regionParentNum){
    this.region = region;
    thi.regionParentNum = regionParentNum;
  }
}
