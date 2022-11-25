package com.example.usedshop.DTO;

import com.example.usedshop.entity.Member;
import lombok.*;

import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberRequest {

    @Id
    private Long id;

    private String email;

    private String password;

    @Builder
    public MemberRequest(Long id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .email(email)
                .password(password)
                .build();
    }
}
