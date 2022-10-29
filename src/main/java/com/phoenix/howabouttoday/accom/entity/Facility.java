package com.phoenix.howabouttoday.accom.entity;

/**
 * TV,TWOBED는 예시로 넣어놓음
 */

public enum Facility {
    OCEANVIEW("오션뷰 있음"),RIVERVIEW("리버뷰 있음"),GOOD("상태 좋음"),THREESTAR("3성 호텔"),FOURSTAR("4성 호텔"),NO_CHARGE("추가요금 없음"),CHARGE("추가요금"),
    CANCELLATION("취소 불가"),;

    private String krName;

    Facility(String krName) {
        this.krName = krName;
    }

    public String getKrName() {
        return krName;
    }
}
