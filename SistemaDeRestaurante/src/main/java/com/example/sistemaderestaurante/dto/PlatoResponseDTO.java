package com.example.sistemaderestaurante.dto;


import com.example.sistemaderestaurante.entity.PlatoEntidad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoResponseDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String estado;


    // Convertir Entity → DTO metodo estatico
    public static PlatoResponseDTO fromEntity(PlatoEntidad plato) {
        return new PlatoResponseDTO(
                plato.getId(),
                plato.getNombre(),
                plato.getDescripcion(),
                plato.getPrecio(),
                plato.getActivo() ? "Disponible" : "No disponible"
        );
    }
}


