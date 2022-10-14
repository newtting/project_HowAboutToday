package com.phoenix.howabouttoday.accom.entity;

import com.phoenix.howabouttoday.accom.RegionType;
import com.phoenix.howabouttoday.accom.RegionTypeConverter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table
public class Region {

  @Id @GeneratedValue
  private Long regionNum;

  @Column(length = 50)
  @Convert(converter = RegionTypeConverter.class)
  private RegionType region;

  private int regionParentNum;
}
