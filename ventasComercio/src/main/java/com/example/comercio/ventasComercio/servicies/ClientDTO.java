package com.example.comercio.ventasComercio.servicies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
public class ClientDTO {

    @Getter @Setter private Long id;

    @Getter @Setter private String name;
    @Getter @Setter private String lastname;
    @Getter @Setter private Integer dni;
}
