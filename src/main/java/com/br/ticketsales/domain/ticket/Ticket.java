package com.br.ticketsales.domain.ticket;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tickets")
@Entity(name = "Ticket")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ticket {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    private boolean active;

    public Ticket(CreateTicketDTO ticketData) {
        this.name = ticketData.name();
        this.price = ticketData.price();
        this.ticketType = ticketData.ticketType();
        this.active = true;
    }

    public void delete() {
        this.active = false;
    }
}
