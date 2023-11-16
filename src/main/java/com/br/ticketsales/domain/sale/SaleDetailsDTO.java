package com.br.ticketsales.domain.sale;

public record SaleDetailsDTO(Long id, Long ticketId, Long customerId) {
    public SaleDetailsDTO(Sale sale) {
        this(sale.getId(), sale.getTicketId(), sale.getCustomerId());
    }
}
