package team_11h56m.letsdigin.recommendation;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team_11h56m.letsdigin.member.LoggedMember;

@RestController
public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private final LoggedMember loggedMember;

    public RecommendationController(LoggedMember loggedMember) {
        this.loggedMember = loggedMember;
    }

    @GetMapping("/recommendation")
    public String getRecommendation() {
        String memberId = loggedMember.getLoggedMember();

        JSONObject response = recommendationService.runRecommendation(memberId);
        System.out.println("response = " + response.toString());
        return response.toString();

    }

//    @GetMapping("/recommendation")
//    public JSONObject getRecommendation() {
//        String memberId = loggedMember.getLoggedMember();
//        System.out.println("rec. memberId = " + memberId);
//
//        JSONObject response = recommendationService.runRecommendation(memberId);
//        return response;
//
//    }
}
