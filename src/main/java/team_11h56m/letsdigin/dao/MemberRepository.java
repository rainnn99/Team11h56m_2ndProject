package team_11h56m.letsdigin.dao;

import team_11h56m.letsdigin.member.Member;

import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findByUserid(String userId);
}
