package com.example.usedshop.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class MemberResponse {


    @Id
    private Long id;

    private String email;

    private String password;

    public MemberResponse(String email, String password){
        this.email = email;
        this.password = password;
    }
}
