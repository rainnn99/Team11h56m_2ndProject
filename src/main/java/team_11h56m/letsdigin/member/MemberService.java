package team_11h56m.letsdigin.member;

import team_11h56m.letsdigin.dto.UserDTO;

import java.util.Optional;

public interface MemberService {
    Member signupUser(Member member);

    Member signupUser(UserDTO userDTO);

    Member getLoggedUser();
    Member getCoupon();
    Member receiveCoupon();

    Optional<Member> findOne(String UserId);
}
