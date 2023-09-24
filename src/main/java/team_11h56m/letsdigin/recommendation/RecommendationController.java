package team_11h56m.letsdigin.recommendation;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/recommendation")
    public JSONObject getRecommendation(@RequestParam("id") String userId) {

        JSONObject response = recommendationService.runRecommendation(userId);
        return response;

    }
}
