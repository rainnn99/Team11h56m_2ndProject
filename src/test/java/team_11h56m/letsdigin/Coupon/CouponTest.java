package team_11h56m.letsdigin.Coupon;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import team_11h56m.letsdigin.dao.MemberRepository;
import team_11h56m.letsdigin.member.Member;
import team_11h56m.letsdigin.member.MemberService;

import java.util.Optional;

// 작동안함

@SpringBootTest
@AutoConfigureMockMvc
public class CouponTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;
    @MockBean
    private MemberRepository memberRepository;

    @Test
    public void testGetCouponCount() throws Exception {
        // 가상의 사용자 정보를 생성
        UserDetails userDetails = User.withUsername("testuser").password("password").roles("USER").build();
        // 사용자 정보를 이용하여 Authentication 객체 생성
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, "password", userDetails.getAuthorities());
        // 컨트롤러 메서드 호출 전에 인증 정보를 설정
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(authentication);

        // MemberRepository Mock 설정
        when(memberRepository.findByUserid(anyString())).thenReturn(Optional.of(new Member("testuser", "password", "testuser", "01000000000", 2)));

        // GET 요청 수행 및 검증
        MvcResult result = mockMvc.perform(get("/coupon/count"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        System.out.println("Response Content: " + responseContent); // 결과를 로그로 출력

        // MemberRepository의 메서드가 호출되는지 검증
        verify(memberRepository, times(1)).findByUserid(anyString());

        // 반환된 쿠폰 수 확인
        int couponCount = Integer.parseInt(result.getResponse().getContentAsString());
        assertEquals(2, couponCount);
    }

    @Test
    public void testReceiveCoupon() throws Exception {
        Authentication authentication = new UsernamePasswordAuthenticationToken("testuser", "password");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        when(memberRepository.findByUserid(anyString())).thenReturn(Optional.of(new Member("testuser", "1233", "testuser", "01000000000", 2)));
        MvcResult result = mockMvc.perform(get("/coupon/receive"))
                .andExpect(status().isOk())
                .andReturn();
        int updateCouponCount = Integer.parseInt(result.getResponse().getContentAsString());
        assertEquals(3, updateCouponCount);
    }

    @BeforeEach
    public void setup() {
        SecurityContextHolder.clearContext();
    }
}