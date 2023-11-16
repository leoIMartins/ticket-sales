package com.br.ticketsales.controller;

import com.br.ticketsales.domain.ticket.CreateTicketDTO;
import com.br.ticketsales.domain.ticket.Ticket;
import com.br.ticketsales.domain.ticket.TicketDetailsDTO;
import com.br.ticketsales.domain.ticket.TicketRepository;
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
@RequestMapping("tickets")
public class TicketController {

    @Autowired
    private TicketRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreateTicketDTO ticketData, UriComponentsBuilder uriBuilder) {
        var ticket = new Ticket(ticketData);
        repository.save(ticket);

        var uri = uriBuilder.path("/tickets/{id}").buildAndExpand(ticket.getId()).toUri();

    return ResponseEntity.created(uri).body(new TicketDetailsDTO(ticket));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var ticket = repository.getReferenceById(id);
        ticket.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<TicketDetailsDTO>> list(@PageableDefault(size = 10, sort = {"id"}) Pageable pagination) {
        var page = repository.findAll(pagination).map(TicketDetailsDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var ticket = repository.getReferenceById(id);
        return ResponseEntity.ok(new TicketDetailsDTO(ticket));
    }
}
