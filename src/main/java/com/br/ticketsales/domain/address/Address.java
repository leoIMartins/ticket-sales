package com.br.ticketsales.domain.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String country;
    private String city;
    private String state;

    private String postalCode;
    private String address;
    private String number;

    public Address(AddressDTO address) {
        this.country = address.country();
        this.city = address.city();
        this.state = address.state();
        this.postalCode = address.postalCode();
        this.address = address.address();
        this.number = address.number();
    }
}
