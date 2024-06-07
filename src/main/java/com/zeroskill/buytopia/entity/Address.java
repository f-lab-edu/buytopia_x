package com.zeroskill.buytopia.entity;

import com.zeroskill.buytopia.dto.AddressDto;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Address {
    @Column(name = "main_address")
    private String mainAddress;

    @Column(name = "sub_address")
    private String subAddress;

    @Column(name = "zipcode")
    private String zipcode;

    public Address(String mainAddress, String subAddress, String zipcode) {
        this.mainAddress = mainAddress;
        this.subAddress = subAddress;
        this.zipcode = zipcode;
    }

    public static Address toEntity(AddressDto addressDto) {
        return new Address(addressDto.mainAddress(), addressDto.subAddress(), addressDto.zipcode());
    }
}