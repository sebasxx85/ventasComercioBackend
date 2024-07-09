package com.example.comercio.ventasComercio.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "invoiceDetails")

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class InvoiceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    @Getter @Setter private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @Getter @Setter private Product product;

    @Basic
    @Getter @Setter private Integer amount;
    @Getter @Setter private Double price;
}
