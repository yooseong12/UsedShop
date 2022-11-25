package com.example.usedshop.controller;

import com.example.usedshop.DTO.MemberRequest;
import com.example.usedshop.entity.Member;
import com.example.usedshop.jwt.JwtTokenProvider;
import com.example.usedshop.repository.MemberRepository;
import com.example.usedshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/join")
    public Long join(@RequestBody Map<String,String> user){
        return memberRepository.save(Member.builder()
                .email(user.get("email"))
                .password(passwordEncoder.encode(user.get("password")))
                .build()).getId();
    }


    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user){
        Member member = memberRepository.findByEmail(user.get("email"))
                .orElseThrow(()-> new IllegalArgumentException("가입되지 않은 이메일 입니다."));

        if(!passwordEncoder.matches(user.get("password"), member.getPassword())){
            throw new IllegalArgumentException("잘못된 비밀번호 입니다.");
        }

        return jwtTokenProvider.getUserPk(member.getEmail());
    }






}
