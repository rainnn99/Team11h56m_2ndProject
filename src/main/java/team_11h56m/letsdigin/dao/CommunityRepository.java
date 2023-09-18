package team_11h56m.letsdigin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team_11h56m.letsdigin.community.Community;

@Repository
public interface CommunityRepository extends JpaRepository<Community, String> {
    //
}
