package com.br.ticketsales.domain.customer;

public record CustomerListDTO(Long id, String name, String documentId, String email, String phone) {

    public CustomerListDTO(Customer customer) {
        this(customer.getId(), customer.getName(), customer.getDocumentId(),
                customer.getEmail(), customer.getPhone());
    }
}
