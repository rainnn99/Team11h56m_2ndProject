//package team_11h56m.letsdigin.Member;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import team_11h56m.letsdigin.dao.MemberRepository;
//import team_11h56m.letsdigin.dto.MemberDTO;
//import team_11h56m.letsdigin.member.Member;
//import team_11h56m.letsdigin.member.MemberService;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class MemberServiceTest {
//    @Autowired
//    private MemberService memberService;
//
//    @MockBean
//    private MemberRepository memberRepository;
//
//    @Test
//    void testSignUpSuccess() {
//        // 모의 객체의 메서드 호출에 대한 동작 정의
//        when(memberRepository.findByUserid(anyString())).thenReturn(Optional.empty());
//
//        MemberDTO signupRequest = new MemberDTO();
//        signupRequest.setId("testuser");
//        signupRequest.setPassword("password");
//        signupRequest.setName("Test User");
//        signupRequest.setPhone("1234567890");
//        signupRequest.setCoupon(0);
//
//        String result = memberService.signUp(signupRequest);
//
//        assertEquals("T", result);
//    }
//
//    @Test
//    void testSignUpFailureDueToDuplicateID() {
//        // 모의 객체의 메서드 호출에 대한 동작 정의
//        when(memberRepository.findByUserid(anyString())).thenReturn(Optional.of(new Member("testuser", "1233", "testuser", "01000000000", 2)));
//
//        MemberDTO signupRequest = new MemberDTO();
//        signupRequest.setId("testuser"); // 중복된 ID로 시도
//        signupRequest.setPassword("password");
//        signupRequest.setName("Test User");
//        signupRequest.setPhone("1234567890");
//
//        String result = memberService.signUp(signupRequest);
//
//        assertEquals("F", result);
//    }
//}
