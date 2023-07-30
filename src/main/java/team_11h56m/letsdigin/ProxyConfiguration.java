package team_11h56m.letsdigin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProxyConfiguration {
    @Bean
    public WebClient webClient(){
        return WebClient.create("http://localhost:3000");
    }
}
