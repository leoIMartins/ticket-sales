package com.br.ticketsales.domain.ticket;

public record TicketDetailsDTO(Long id, String name, Long price, TicketType ticketType, boolean active) {

    public TicketDetailsDTO(Ticket ticket) {
        this(ticket.getId(), ticket.getName(), ticket.getPrice(), ticket.getTicketType(), ticket.isActive());
    }
}
