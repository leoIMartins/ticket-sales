package com.br.ticketsales.controller;

import com.br.ticketsales.domain.sale.CreateSaleDTO;
import com.br.ticketsales.domain.sale.Sale;
import com.br.ticketsales.domain.sale.SaleDetailsDTO;
import com.br.ticketsales.domain.sale.SaleRepository;
import com.br.ticketsales.domain.ticket.TicketRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("sales")
public class SaleController {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreateSaleDTO saleData, UriComponentsBuilder uriBuilder) {
        var sale = new Sale(saleData);
        saleRepository.save(sale);
        ticketRepository.getReferenceById(sale.getTicketId()).delete();

        var uri = uriBuilder.path("/sales/{id}").buildAndExpand(sale.getId()).toUri();

    return ResponseEntity.created(uri).body(new SaleDetailsDTO(sale));
    }
}
