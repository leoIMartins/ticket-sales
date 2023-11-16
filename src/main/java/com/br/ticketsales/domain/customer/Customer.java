package com.br.ticketsales.domain.customer;

import com.br.ticketsales.domain.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "customers")
@Entity(name = "Customer")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String documentId;
    private String email;
    private String phone;
    @Embedded
    private Address address;

    public Customer(CreateCustomerDTO customer) {
        this.name = customer.name();
        this.documentId = customer.documentId();
        this.email = customer.email();
        this.phone = customer.phone();
        this.address = new Address(customer.address());
    }
}