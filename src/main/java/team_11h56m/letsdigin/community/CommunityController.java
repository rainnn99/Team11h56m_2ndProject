package team_11h56m.letsdigin.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team_11h56m.letsdigin.dto.CommunityDTO;
import team_11h56m.letsdigin.member.LoggedMember;

import java.util.List;

@RestController
public class CommunityController {
    private final CommunityService communityService;
    private final LoggedMember loggedMember;

    @Autowired
    public CommunityController(CommunityService communityService, LoggedMember loggedMember) {
        this.communityService = communityService;
        this.loggedMember = loggedMember;
    }

    @PostMapping("/community/writing")
    public ResponseEntity<String> createPost(@RequestBody CommunityDTO postRequest) {
        String memberId = loggedMember.getLoggedMember();
        System.out.println("memberId = " + memberId);
        // 게시글 작성 로직 호출
        boolean isSaved = communityService.createPost(memberId, postRequest);

        if (isSaved) {
            return ResponseEntity.status(HttpStatus.CREATED).body("게시글이 성공적으로 작성되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시글 작성에 실패했습니다.");
        }
    }

    @GetMapping("/community/lists")
    public List<CommunityDTO> getAllCommunityPosts(){
        return communityService.getCommunityPosts();
    }
}
