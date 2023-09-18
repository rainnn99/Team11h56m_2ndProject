package team_11h56m.letsdigin.community;

import org.springframework.stereotype.Service;
import team_11h56m.letsdigin.dto.CommunityDTO;

import java.util.List;

@Service
public interface CommunityService {
    List<CommunityDTO> getCommunityPosts();

    public boolean createPost(String memberId, CommunityDTO postRequest);
}
