package com.br.ticketsales.domain.sale;

import jakarta.validation.constraints.NotNull;

public record CreateSaleDTO(
        @NotNull
        Long ticketId,
        @NotNull
        Long customerId
) {
}
