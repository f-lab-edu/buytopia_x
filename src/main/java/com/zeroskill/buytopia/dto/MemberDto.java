package com.zeroskill.buytopia.dto;

public record MemberDto(
        Long id,
        String loginId,
        String name,
        String email,
        String password,
        Byte grade,
        AddressDto addressdto
) {
}
