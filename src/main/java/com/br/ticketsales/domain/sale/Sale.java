package com.br.ticketsales.domain.sale;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "sales")
@Entity(name = "Sale")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sale {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ticketId;
    private Long customerId;

    public Sale(CreateSaleDTO saleData) {
        this.ticketId = saleData.ticketId();
        this.customerId = saleData.customerId();
    }
}
