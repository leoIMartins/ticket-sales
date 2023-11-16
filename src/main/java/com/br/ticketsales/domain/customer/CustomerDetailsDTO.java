package com.br.ticketsales.domain.customer;

import com.br.ticketsales.domain.address.Address;

public record CustomerDetailsDTO(Long id, String name, String documentId, String email, String phone, Address address) {

    public CustomerDetailsDTO(Customer customer) {
        this(customer.getId(), customer.getName(), customer.getDocumentId(),
                customer.getEmail(), customer.getPhone(), customer.getAddress());
    }
}
