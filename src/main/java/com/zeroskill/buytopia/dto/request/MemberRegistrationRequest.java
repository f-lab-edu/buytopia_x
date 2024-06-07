package com.zeroskill.buytopia.dto.request;

import com.zeroskill.buytopia.dto.AddressDto;
import com.zeroskill.buytopia.dto.MemberDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record MemberRegistrationRequest(
        @NotBlank(message = "사용자 아이디는 필수입니다.")
        String loginId,

        @NotBlank(message = "이름은 필수입니다.")
        String name,

        @NotBlank(message = "이메일은 필수입니다.")
        @Email(message = "유효한 이메일 형식이 아닙니다.")
        String email,

        @NotBlank(message = "비밀번호는 필수입니다.")
        String password,

        AddressDto address
) {
        public static MemberDto toMemberDto(MemberRegistrationRequest request) {
                return new MemberDto(null, request.loginId(), request.name, request.email, request.password, (byte) 1, request.address);
        }
}
