package com.zeroskill.buytopia.controller;

import com.zeroskill.buytopia.dto.MemberDto;
import com.zeroskill.buytopia.dto.request.MemberRegistrationRequest;
import com.zeroskill.buytopia.dto.response.MemberRegistrationResponse;
import com.zeroskill.buytopia.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.zeroskill.buytopia.converter.ResponseConverter.convertToResponseEntity;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping({"", "/"})
    public ResponseEntity<MemberRegistrationResponse> register(@RequestBody @Validated MemberRegistrationRequest request) {
        MemberDto memberDto = MemberRegistrationRequest.toMemberDto(request);
        MemberRegistrationResponse memberRegistrationResponse = memberService.register(memberDto);
        return convertToResponseEntity(memberRegistrationResponse);
    }
}
