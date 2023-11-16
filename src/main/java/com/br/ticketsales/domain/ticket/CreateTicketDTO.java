package com.br.ticketsales.domain.ticket;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateTicketDTO(
        @NotBlank
        String name,
        @NotNull
        Long price,
        @NotNull
        TicketType ticketType) {
}
