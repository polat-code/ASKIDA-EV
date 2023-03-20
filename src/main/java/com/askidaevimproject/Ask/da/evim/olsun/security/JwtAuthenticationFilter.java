package com.askidaevimproject.Ask.da.evim.olsun.security;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Member;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.MemberRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private JwtService jwtService;
    private MemberRepository memberRepository;

    public Authentication claimsToAuthentication(Jws<Claims> jws) {
        if (jws == null)
            return null;

        String email = jws.getBody().getSubject(); // email
        Member member = memberRepository.findByMemberMail(email);
        return new UsernamePasswordAuthenticationToken(member, null, member.getAuthorities());
    }


    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");
        Jws<Claims> jws = jwtService.verifyAuthHeader(authorizationHeader);
        Authentication authentication = claimsToAuthentication(jws);
        SecurityContextHolder.getContext().setAuthentication(authentication);


        filterChain.doFilter(request, response);
    }
}
