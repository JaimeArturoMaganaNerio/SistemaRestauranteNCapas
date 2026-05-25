package com.example.sistemaderestaurante.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoRequestDTO {
    private String nombre;
    private String descripcion;
    private Double precio;

}