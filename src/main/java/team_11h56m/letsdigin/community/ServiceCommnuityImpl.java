package team_11h56m.letsdigin.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team_11h56m.letsdigin.dto.CommunityDTO;
import team_11h56m.letsdigin.dao.CommunityRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class ServiceCommnuityImpl implements CommunityService{
    private final CommunityRepository communityRepository;

    @Autowired
    public ServiceCommnuityImpl(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @Override
    @Transactional
    public List<CommunityDTO> getCommunityPosts() {
        List<CommunityDTO> communityDTOs = new ArrayList<>();

        // 모든 Community 엔티티를 가져옴
        List<Community> communityList = communityRepository.findAll();

        // 엔티티를 DTO로 변환
        for (Community community : communityList) {
            CommunityDTO communityDTO = new CommunityDTO();
            communityDTO.setSerialNumber(community.getSerialNumber());
            communityDTO.setMemberId(community.getMemberId());
            communityDTO.setTitle(community.getTitle());
            communityDTO.setMainText(community.getMainText());
            communityDTOs.add(communityDTO);
        }

        return communityDTOs;
    }

    @Override
    public boolean createPost(String memberId, CommunityDTO postRequest) {
        try {
            // 클라이언트로부터 받아온 데이터로 게시글 엔티티 생성
            Community post = new Community();
            post.setTitle(postRequest.getTitle());
            post.setMemberId(memberId);
            post.setMainText(postRequest.getMainText());

            // 게시글 저장
            communityRepository.save(post);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
