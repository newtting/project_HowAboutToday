package com.phoenix.howabouttoday.accom.entity;

import com.phoenix.howabouttoday.accom.RegionType;
import com.phoenix.howabouttoday.accom.RegionTypeConverter;
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

  private String regionName;

  @Column(length = 50)
  @Convert(converter = RegionTypeConverter.class)
  private RegionType region;

  private Integer regionParentNum;

  @Builder
  public Region(RegionType region, Integer regionParentNum,String regionName){
    this.region = region;
    this.regionParentNum = regionParentNum;
    this.regionName = regionName;
  }
}
