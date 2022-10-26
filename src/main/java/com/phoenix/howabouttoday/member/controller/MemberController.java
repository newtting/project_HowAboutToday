package com.phoenix.howabouttoday.member.controller;


import com.phoenix.howabouttoday.config.auth.LoginUser;
import com.phoenix.howabouttoday.member.Service.MemberService;
import com.phoenix.howabouttoday.member.dto.MemberDTO;
import com.phoenix.howabouttoday.member.dto.SessionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;


import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;



    @GetMapping("/member/join")
    public String join() {
        return "/member/home";
    }



    @PostMapping("/member/join")
    public String joinProc(@Valid MemberDTO memberDTO, BindingResult result, Model model,
                           @RequestHeader("referer") String referer) {


        System.out.println("호출!!!!!!!!");
//        if (errors.hasErrors()) {
//            /* 회원가입 실패시 입력 데이터 값을 유지 */
//            model.addAttribute("memberDTO", memberDTO);
//
//
//
//
//            /* 유효성 통과 못한 필드와 메시지를 핸들링 */
//            Map<String, String> validatorResult = memberService.validateHandling(errors);
//            for (String key : validatorResult.keySet()) {
//                model.addAttribute(key, validatorResult.get(key));
//            }
//            /* 회원가입 페이지로 다시 리턴 */
//            return "redirect:/member/join";
//        }

        if(result.hasErrors()){

            System.out.println("리턴페이지 호출!!!!!!!");

            return  "/home";
        }


        System.out.println("referer = " + referer);
        System.out.println("memberDto = " + memberDTO.toString());
        memberService.join(memberDTO);
        String url = referer.substring(21);
        System.out.println("url = " + url);

        return "redirect:" + url;
    }


//    @PostMapping("/member/join")
//    public String joinProc(@Valid MemberDTO memberDTO, Errors errors, Model model,
//                           @RequestHeader("referer") String referer) {
//
//        if (errors.hasErrors()) {
//            /* 회원가입 실패시 입력 데이터 값을 유지 */
//            model.addAttribute("memberDTO", memberDTO);
//
//            /* 유효성 통과 못한 필드와 메시지를 핸들링 */
//            Map<String, String> validatorResult = memberService.validateHandling(errors);
//            for (String key : validatorResult.keySet()) {
//                model.addAttribute(key, validatorResult.get(key));
//            }
//            String url = referer.substring(21);
//            /* 회원가입 페이지로 다시 리턴 */
//            return "redirect:" + url;
//        }
//
//        memberService.join(memberDTO);
//        String url = referer.substring(21);
//
//        return "redirect:" + url;
//    }

//    @GetMapping("/loginProc")
//    public String login(@RequestHeader("referer") String referer) {
//        String url = referer.substring(21);
//        System.out.println("aaa");
//        return "/member/member-login";

    @GetMapping("/loginProc")
    public String login(@RequestHeader("referer") String referer) {
        String url = referer.substring(21);
        System.out.println("aaa");
        return "/member/member-login";

    }

    @GetMapping("/logout")
    public String logout() {
        return "member/logout";
    }



    @GetMapping("recover")
    public String getRecover(){
        return "member/recover";
    }
    @PostMapping("recover")
    public String postRecover(){
        return "member/recover";
    }

    @GetMapping("user-dashboard")
    public String getUserDashboard(@LoginUser SessionDTO sessionDTO, Model model) {

        if(sessionDTO != null) {
            model.addAttribute("sessionDTO", sessionDTO);
        }

        return "member/userdashboard/user-dashboard";
    }
    @PostMapping("user-dashboard")
    public String postUserDashboard() {
        return "member/userdashboard/user-dashboard";
    }
    private void addUsers(Model model) {
        List<String> users = Arrays.asList(new String("₩ 90,000"),
                new String("₩ 190,000"),
                new String("₩ 150,000"));

        model.addAttribute("users", users);
    }



//    @RestController
//    public class UserController {
//
//        private final UserRepository userRepository;
//
//        public UserController(UserRepository userRepository) {
//            this.userRepository = userRepository;
//        }
//
//        @GetMapping("/users")
//        public Page<User> getAllUsers() {
//            PageRequest pageRequest = PageRequest.of(0, 5);
//            return userRepository.findAll(pageRequest);
//        }
//
//        @PostConstruct
//        public void initializing() {
//            for (int i = 0; i < 100; i++) {
//                User user = User.builder()
//                        .username("User " + i)
//                        .address("Korea")
//                        .age(i)
//                        .build();
//                userRepository.save(user);
//            }
//        }
//    }

//   @GetMapping("user-dashboard-booking")
//    public String getUserDashboardBooking(Model model) {
//
//        addUsers(model);
//        return "member/userdashboard/user-dashboard-booking";
//    }
//    @PostMapping("user-dashboard-booking")
//    public String postUserDashboardBooking() {
//        return "member/userdashboard/user-dashboard-booking";
//    }

    @GetMapping("user-dashboard-profile")
    public String getUserDashboardProfile(@LoginUser SessionDTO sessionDTO, Model model) {

        if(sessionDTO != null) {
            model.addAttribute("sessionDTO", sessionDTO);
        }

        return "member/userdashboard/user-dashboard-profile";
    }
    @PostMapping("user-dashboard-profile")
    public String postUserDashboardProfile() {
        return "member/userdashboard/user-dashboard-profile";
    }

    @GetMapping("user-dashboard-reviews")
    public String getUserDashboardReviews(@LoginUser SessionDTO sessionDTO, Model model) {

        if(sessionDTO != null) {
            model.addAttribute("sessionDTO", sessionDTO);
        }

        return "member/userdashboard/user-dashboard-reviews";
    }
    @PostMapping("user-dashboard-reviews")
    public String postUserDashboardReviews() {
        return "member/userdashboard/user-dashboard-reviews";
    }

    @GetMapping("user-dashboard-settings")
    public String getUserDashboardSettings(@LoginUser SessionDTO sessionDTO, Model model) {

        if(sessionDTO != null) {
            model.addAttribute("sessionDTO", sessionDTO);
        }

        return "member/userdashboard/user-dashboard-settings";
    }
    @PostMapping("user-dashboard-settings")
    public String postUserDashboardSettings() {
        return "member/userdashboard/user-dashboard-settings";
    }


}
