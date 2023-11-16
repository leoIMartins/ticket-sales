package com.br.ticketsales.domain.address;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO(
        @NotBlank
        String country,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        String postalCode,
        @NotBlank
        String address,
        String number) {
}
