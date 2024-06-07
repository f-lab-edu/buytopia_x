package com.zeroskill.buytopia.service;

import com.zeroskill.buytopia.dto.MemberDto;
import com.zeroskill.buytopia.dto.response.MemberRegistrationResponse;
import com.zeroskill.buytopia.entity.Address;
import com.zeroskill.buytopia.entity.Member;
import com.zeroskill.buytopia.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberRegistrationResponse register(MemberDto memberDto) {
        Address address = Address.toEntity(memberDto.addressdto());
        Member member = Member.toEntity(memberDto, address);
        Member savedMember = memberRepository.save(member);
        return new MemberRegistrationResponse(savedMember);
    }
}

