package com.example.comercio.ventasComercio.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @Getter @Setter private Client client;

    @Basic
    @Getter @Setter private Date createdAt;
    @Getter @Setter private Double total;


}
