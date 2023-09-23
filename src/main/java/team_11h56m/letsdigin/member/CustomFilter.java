//package team_11h56m.letsdigin.member;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class CustomFilter extends OncePerRequestFilter {
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        if ("POST".equals(request.getMethod()) && "/authenticate".equals(request.getRequestURI())) {
//            // Content-Type 헤더 확인
//            String contentType = request.getContentType();
//            if (contentType != null && contentType.contains("application/x-www-form-urlencoded")) {
//                // 폼 데이터를 읽어서 로깅하거나 처리
//                String memberId = request.getParameter("memberId");
//                String password = request.getParameter("password");
//
//                System.out.println("Form Data - memberId: " + memberId);
//                System.out.println("Form Data - password: " + password);
//            }
//        }
//
//        // 다음 필터로 요청을 전달
//        filterChain.doFilter(request, response);
//    }
//}
