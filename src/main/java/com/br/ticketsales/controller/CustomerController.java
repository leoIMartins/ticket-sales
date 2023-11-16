package com.br.ticketsales.controller;

import com.br.ticketsales.domain.customer.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreateCustomerDTO customerData, UriComponentsBuilder uriBuilder) {
        var customer = new Customer(customerData);
        repository.save(customer);

        var uri = uriBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri();

        return ResponseEntity.created(uri).body(new CustomerDetailsDTO(customer));
    }

    @GetMapping
    public ResponseEntity<Page<CustomerListDTO>> list(@PageableDefault(size = 10, sort = {"id"}) Pageable pagination) {
        var page = repository.findAll(pagination).map(CustomerListDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var customer = repository.getReferenceById(id);
        return ResponseEntity.ok(new CustomerDetailsDTO(customer));
    }
}
