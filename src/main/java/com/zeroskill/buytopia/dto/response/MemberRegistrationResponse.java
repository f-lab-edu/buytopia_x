package com.zeroskill.buytopia.dto.response;

import com.zeroskill.buytopia.entity.Address;
import com.zeroskill.buytopia.entity.Grade;
import com.zeroskill.buytopia.entity.Member;

public record MemberRegistrationResponse(
    Long id,
    String name,
    String email,
    Grade grade,
    Address address
) {
     public MemberRegistrationResponse(Member member){
         this(member.getId(), member.getName(), member.getEmail(), member.getGrade(), member.getAddress());
     }
}
