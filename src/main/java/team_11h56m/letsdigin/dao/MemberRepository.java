package team_11h56m.letsdigin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import team_11h56m.letsdigin.member.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberId(String memberId);
}
