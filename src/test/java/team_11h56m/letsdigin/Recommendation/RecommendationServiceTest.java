package team_11h56m.letsdigin.Recommendation;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import team_11h56m.letsdigin.recommendation.RecommendationService;

@SpringBootTest
public class RecommendationServiceTest {



    @Test
    public void runRecommendation() {
        String userId = "test";

        JSONObject result = RecommendationService.runRecommendation(userId);
        System.out.println("result : " + result);
    }


}


