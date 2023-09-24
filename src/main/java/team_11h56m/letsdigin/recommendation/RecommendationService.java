package team_11h56m.letsdigin.recommendation;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class RecommendationService {



    public static JSONObject runRecommendation(String userId) {
        String[] command = new String[3];
        command[0] = "python";
        command[1] = "src/main/resources/recommendation.py";
        command[2] = userId;

        JSONObject returnJson = null;
        try {
            returnJson = recommendationPython(command);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("returnJson : " + returnJson);
        return returnJson;

    }

    public static JSONObject recommendationPython(String[] command) throws IOException, InterruptedException {
        CommandLine commandLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            commandLine.addArgument(command[i]);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(outputStream);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(pumpStreamHandler);
        int exitValue = executor.execute(commandLine); // 파이썬 스크립트의 종료 코드 받기


        String output = outputStream.toString();
        //System.out.println("output : " + output);
        try {
            return new JSONObject(output);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return null;
        }

//        String output = outputStream.toString();
//        System.out.println("output : " + output);
//        try {
//            // 파이썬에서 생성한 JSON 문자열을 그대로 리턴
//            return output;
//        } catch (org.json.JSONException e) {
//            e.printStackTrace();
//            return null;
//        }
    }
}
