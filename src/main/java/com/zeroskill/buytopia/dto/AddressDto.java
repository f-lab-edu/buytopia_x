package com.zeroskill.buytopia.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressDto(
        @NotBlank(message = "메인주소는 필수입니다.")
        String mainAddress,

        @NotBlank(message = "서브주소는 필수입니다.")
        String subAddress,

        @NotBlank(message = "우편번호는 필수입니다.")
        String zipcode
) {
}
