package team_11h56m.letsdigin.member;

import org.springframework.beans.factory.annotation.Autowired;
import team_11h56m.letsdigin.dao.MemberRepository;
import team_11h56m.letsdigin.dto.MemberDTO;

import java.util.Optional;

public interface MemberService {

    String signUp(MemberDTO memberDTO);
    int getCouponCount(String userId);
    int receiveCoupon(String userId);

    Optional<Member> findOne(String UserId);
}
