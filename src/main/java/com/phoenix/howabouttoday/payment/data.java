package com.phoenix.howabouttoday.payment;

import com.phoenix.howabouttoday.accom.entity.AccomImage;
import com.phoenix.howabouttoday.accom.entity.Accommodation;
import com.phoenix.howabouttoday.accom.entity.Region;
import com.phoenix.howabouttoday.accom.repository.AccommodationRepository;
import com.phoenix.howabouttoday.global.AccomCategory;
import com.phoenix.howabouttoday.global.RegionType;
import com.phoenix.howabouttoday.member.entity.Code;
import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.member.repository.MemberRepository;
import com.phoenix.howabouttoday.payment.entity.Orders;
import com.phoenix.howabouttoday.payment.testDriver.AvailableDate;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Cart;
import com.phoenix.howabouttoday.reserve.domain.Reservation.ReserveStatus;
import com.phoenix.howabouttoday.room.entity.Room;
import com.phoenix.howabouttoday.room.entity.RoomImage;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class data {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    AccommodationRepository accommodationRepository;

    public void dataInput() {

        List<Region> regionList = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            regionList.add(Region.builder()
                    .region(RegionType.values()[i])
                    .regionParentNum(RegionType.EMPTY)
                    .build());
        }


        Member member100 = Member.builder()
                .email("northJPA@google.com")
                .pwd("1234")
                .nickname("김영운")
                .memberTel("010-4502-0614")
                .memberCode(Code.MEMBER)
                .joinDate(LocalDate.of(2019, 4, 5))
                .withdrawdate(null)
                .memberOriginalFileName("image27.jpg")
                .memberSaveFileName("image27.jpg")
                .build();

        Member member200 = Member.builder()
                .email("craftBlack@daum.net")
                .pwd("1234")
                .nickname("이예민")
                .memberTel("010-5637-2019")
                .memberCode(Code.MEMBER)
                .joinDate(LocalDate.of(2020, 7, 18))
                .withdrawdate(null)
                .memberOriginalFileName("image47.jpg")
                .memberSaveFileName("image47.jpg")
                .build();

        memberRepository.save(member100);
        memberRepository.save(member200);

        Accommodation accom100 = Accommodation.builder()
                .accomName("제주정원휴양펜션")
                .accomTel("050350577805")
                .accomCategory(AccomCategory.PENSION)
                .region(regionList.get(5))
                .accomAddress("제주특별자치도 서귀포시 성산읍 금백조로 87")
                .accomRating(3.9)
                .accomWishlistCount(248)
                .totalReviewNum(384)
                .latitude(36.3156)
                .longitude(126.5192)
                .lowPrice(35000)
                .reserveRange(30)
                .build();

        Accommodation accom200 = Accommodation.builder()
                .accomName("제주 포레스트 펜션")
                .accomTel("064-710-8666")
                .accomCategory(AccomCategory.PENSION)
                .region(regionList.get(5))
                .accomAddress("제주특별자치도 제주시 오남로 221")
                .accomRating(2.8)
                .accomWishlistCount(10)
                .totalReviewNum(133)
                .latitude(36.3596)
                .longitude(126.5002)
                .lowPrice(50000)
                .reserveRange(10)
                .build();

        AccomImage accomImage = AccomImage.builder()
                .accomOriginFilename("image110.jpg")
                .accomSaveFilename("image110.jpg")
                 .accommodation(accom100)
                .build();
        AccomImage accomImage1 = AccomImage.builder()
                .accomOriginFilename("image111.jpg")
                .accomSaveFilename("image111.jpg")
                 .accommodation(accom100)
                .build();
        AccomImage accomImage2 = AccomImage.builder()
                .accomOriginFilename("image112.jpg")
                .accomSaveFilename("image112.jpg")
                 .accommodation(accom100)
                .build();
        AccomImage accomImage3 = AccomImage.builder()
                .accomOriginFilename("image113.jpg")
                .accomSaveFilename("image113.jpg")
                 .accommodation(accom100)
                .build();

        AccomImage accomImage4 = AccomImage.builder()
                .accomOriginFilename("image114.jpg")
                .accomSaveFilename("image114.jpg")
                 .accommodation(accom200)
                .build();
        AccomImage accomImage5 = AccomImage.builder()
                .accomOriginFilename("image115.jpg")
                .accomSaveFilename("image115.jpg")
                .accommodation(accom200)
                .build();
        AccomImage accomImage6 = AccomImage.builder()
                .accomOriginFilename("image116.jpg")
                .accomSaveFilename("image116.jpg")
                .accommodation(accom200)
                .build();
        AccomImage accomImage7 = AccomImage.builder()
                .accomOriginFilename("image117.jpg")
                .accomSaveFilename("image117.jpg")
                .accommodation(accom200)
                .build();

        Room room = Room.builder()
                .roomName("커피향 룸")
                .defaultGuest(2)
                .maxGuest(4)
                .price(55000)
                .roomInfo("객실에서 취사 불가능합니다.")
                .accommodation(accom100)
                .build();
        Room room1 = Room.builder()
                .roomName("바닐라 룸")
                .defaultGuest(1)
                .maxGuest(3)
                .price(45000)
                .roomInfo("고객에게 최선을 다합니다.")
                .accommodation(accom100)
                .build();
        Room room2 = Room.builder()
                .roomName("외계인 룸")
                .defaultGuest(4)
                .maxGuest(6)
                .price(45000)
                .roomInfo("자다가 외계인을 만날지도 모르는 그런 방")
                .accommodation(accom200)
                .build();
        Room room3 = Room.builder()
                .roomName("베이스 룸")
                .defaultGuest(2)
                .maxGuest(4)
                .price(64000)
                .roomInfo("제일 깔끔하고 기본적인 방")
                .accommodation(accom200)
                .build();

        room.getRoomImage().addAll(createRoomImage(56, room));
        room1.getRoomImage().addAll(createRoomImage(48, room1));
        room2.getRoomImage().addAll(createRoomImage(14, room2));
        room3.getRoomImage().addAll(createRoomImage(89, room3));

        accom100.getRoom().add(room);
        accom100.getRoom().add(room1);
        accom200.getRoom().add(room2);
        accom200.getRoom().add(room3);

        Cart cart = Cart.builder()
                .member(member100)
                .accommodation(accom200)
                .room(room2)
                .reserveStatus(ReserveStatus.READY)
                .reserveUseStartDate(LocalDate.of(2022, 10, 18))
                .reserveUseEndDate(LocalDate.of(2022, 10, 20))
                .reservePrice(room2.getPrice())
                .reserveAdultCount(room2.getDefaultGuest())
                .build();

        Cart cart1 = Cart.builder()
                .member(member100)
                .accommodation(accom200)
                .room(room3)
                .reserveStatus(ReserveStatus.READY)
                .reserveUseStartDate(LocalDate.of(2022, 10, 25))
                .reserveUseEndDate(LocalDate.of(2022, 10, 28))
                .reservePrice(room3.getPrice())
                .reserveAdultCount(room3.getDefaultGuest())
                .build();

        AvailableDate r2_ad1 = AvailableDate.builder()
                .room(room2)
                .date(LocalDate.of(2022, 10, 18))
                .build();
        AvailableDate r2_ad2 = AvailableDate.builder()
                .room(room2)
                .date(LocalDate.of(2022, 10, 19))
                .build();

        AvailableDate r3_ad1 = AvailableDate.builder()
                .room(room3)
                .date(LocalDate.of(2022, 10, 25))
                .build();
        AvailableDate r3_ad2 = AvailableDate.builder()
                .room(room3)
                .date(LocalDate.of(2022, 10, 26))
                .build();
        AvailableDate r3_ad3 = AvailableDate.builder()
                .room(room3)
                .date(LocalDate.of(2022, 10, 27))
                .build();

        Orders newOrder = Orders.builder()
                .ordersTel("01045020614")
                .ordersName("김영운")
                .ordersDate(LocalDate.now())
                .ordersPrice(room2.getPrice()+room3.getPrice())
                .ordersType("카드")
                .ordersStatus("이용 전")
                .build();

        member100.getOrders().add(newOrder);
    }


    public List<RoomImage> createRoomImage(Integer number, Room room) {
        List<RoomImage> roomImageList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            number += i;
            roomImageList.add(RoomImage.builder()
                    .roomOriginFileName("image" + number + ".jpg")
                    .roomSaveFileName("image" + number + ".jpg")
                    .build());
        }
        return roomImageList;
    }
}
