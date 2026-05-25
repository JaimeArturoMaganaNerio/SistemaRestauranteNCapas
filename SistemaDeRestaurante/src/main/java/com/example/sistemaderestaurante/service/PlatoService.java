package com.example.sistemaderestaurante.service;

import com.example.sistemaderestaurante.dto.PlatoRequestDTO;
import com.example.sistemaderestaurante.dto.PlatoResponseDTO;
import com.example.sistemaderestaurante.entity.PlatoEntidad;
import com.example.sistemaderestaurante.repository.IPlatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoService {

    private final IPlatoRepository platoRepository;

    public PlatoService(IPlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    // 1. CREAR plato (recibe RequestDTO, retorna ResponseDTO)
    public PlatoResponseDTO crearPlato(PlatoRequestDTO requestDTO) {
        // Convertir DTO → Entidad
        PlatoEntidad plato = new PlatoEntidad();
        plato.setNombre(requestDTO.getNombre());
        plato.setDescripcion(requestDTO.getDescripcion());
        plato.setPrecio(requestDTO.getPrecio());

        // Guardar en base de datos
        PlatoEntidad platoGuardado = platoRepository.save(plato);

        // Convertir Entidad → ResponseDTO y retornar
        return PlatoResponseDTO.fromEntity(platoGuardado);
    }

    // 2. OBTENER todos los platos
    public List<PlatoResponseDTO> obtenerPlatos() {
        return platoRepository.findAll()
                .stream()
                .map(PlatoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // 3. OBTENER plato por ID
    public PlatoResponseDTO obtenerPlatoPorId(Long id) {
        PlatoEntidad plato = platoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plato no encontrado con ID: " + id));
        return PlatoResponseDTO.fromEntity(plato);
    }

    // 4. ACTUALIZAR plato
    public PlatoResponseDTO actualizarPlato(Long id, PlatoRequestDTO requestDTO) {
        // Buscar si existe
        PlatoEntidad platoExistente = platoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plato no encontrado con ID: " + id));

        // Actualizar datos
        platoExistente.setNombre(requestDTO.getNombre());
        platoExistente.setDescripcion(requestDTO.getDescripcion());
        platoExistente.setPrecio(requestDTO.getPrecio());

        // Guardar cambios
        PlatoEntidad platoActualizado = platoRepository.save(platoExistente);

        return PlatoResponseDTO.fromEntity(platoActualizado);
    }

    // 5. ELIMINAR plato
    public void eliminarPlato(Long id) {
        // Verificar que existe
        PlatoEntidad plato = platoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plato no encontrado con ID: " + id));

        // Eliminar
        platoRepository.delete(plato);
    }


}
