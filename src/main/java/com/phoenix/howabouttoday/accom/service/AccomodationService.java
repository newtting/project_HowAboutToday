//package com.phoenix.howabouttoday.accom.service;
//
//import com.phoenix.howabouttoday.accom.entity.AccomImage;
//import com.phoenix.howabouttoday.accom.entity.Accommodation;
//import com.phoenix.howabouttoday.accom.repository.AccommodationRepository;
//import com.phoenix.howabouttoday.payment.AccomCategory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//
//
//@Service
//public class AccomodationService {
//
//
//    private final AccommodationRepository accommodationRepository;
////    private final AccommodationImageRepository accommodationImageRepository;
//
//    @Autowired
//    public AccomodationService(AccommodationRepository accommodationRepository){
//        this.accommodationRepository = accommodationRepository;
////        this.accommodationImageRepository = accommodationImageRepository;
//    }
//
//    @Transactional
//    public void createAccom() {
//
//        AccomImage image = AccomImage.builder()
//                .accomOriginFilename("image0.jpg")
//                .accomSaveFilename("image0.jpg")
//                .build();
//
//
//        Accommodation newMember = Accommodation.builder()
//        .accomName("보령(대천) 너울펜션")
//        .accomTel("050350577805")
//        .accomCategoryName(AccomCategory.PENSION)
//                .regionNum(8)
//        .accomAddress("충청남도 보령시 해수욕장13길 10-20")
//        .accomRating(4.4)
//        .accomWishlistCount(110)
//        .totalReviewNum(1103)
//        .latitude(36.3196)
//        .longitude(126.5092)
//        .lowPrice(45000)
//        .reserveRange(60)
//        .accommodationImage(new ArrayList<AccomImage>())
//        .build();
//
//
//        image.setAccommodation(newMember);
//        newMember.getAccommodationImage().add(image);
//
//
//
////        accommodationImageRepository.save(image);
//        accommodationRepository.save(newMember);
//    }
//}
