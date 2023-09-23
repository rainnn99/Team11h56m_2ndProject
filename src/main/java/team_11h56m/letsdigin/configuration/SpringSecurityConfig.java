//package team_11h56m.letsdigin.configuration;
//
//import jakarta.servlet.DispatcherType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import team_11h56m.letsdigin.member.CustomFilter;
//import team_11h56m.letsdigin.member.MyUserDetailsService;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig {
//
//    @Autowired
//    private CustomFilter customFilter;
//
//    private final MyUserDetailsService myUserDetailsService;
//
//    public SpringSecurityConfig(MyUserDetailsService myUserDetailsService) {
//        this.myUserDetailsService = myUserDetailsService;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf((csrf) -> csrf.disable())
//                .cors(cors -> cors.configurationSource(request -> {
//                    CorsConfiguration config = new CorsConfiguration();
//                    config.addAllowedOrigin("http://localhost:3000");
//                    config.addAllowedMethod("*");
//                    config.addAllowedHeader("*");
//                    return config;
//                }))
//                .authorizeHttpRequests(request -> request
//                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
//                        .requestMatchers("/", "/status", "/signup", "/images/**", "/login", "/authenticate", "/check", "/auth/**").permitAll() //로그인 없이 접속이 가능한 url 설정(수정 필요, 임시 설정)
//                        .anyRequest().permitAll()//.authenticated()	모든 페이지 login으로 리디렉션되서 일단 전면개방
//                )
//                .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class)
//                .formLogin(login -> login
//                        .loginPage("/login")
//                        .loginProcessingUrl("/authenticate")
//                        .usernameParameter("memberId")
//                        .passwordParameter("password")
//                        .defaultSuccessUrl("/check", true)
//                        .permitAll()
//                )
//                .logout(withDefaults());	// 로그아웃은 기본설정으로 (/logout으로 인증해제)
//
//        return http.build();
//    }
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() throws Exception{
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//
//        daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);
//        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
//
//        return daoAuthenticationProvider;
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//}