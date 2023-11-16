package com.br.ticketsales.domain.customer;

import com.br.ticketsales.domain.address.Address;
import com.br.ticketsales.domain.address.AddressDTO;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateCustomerDTO(
        @NotBlank
        String name,
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        String documentId,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String phone,
        @Embedded
        @NotNull @Valid AddressDTO address) {
}
