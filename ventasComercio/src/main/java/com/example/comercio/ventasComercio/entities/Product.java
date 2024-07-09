package com.example.comercio.ventasComercio.entities;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @Basic
    @Getter @Setter private String descripcion;
    @Getter @Setter private String code;
    @Getter @Setter private Integer stock;
    @Getter @Setter private Double precio;
}
