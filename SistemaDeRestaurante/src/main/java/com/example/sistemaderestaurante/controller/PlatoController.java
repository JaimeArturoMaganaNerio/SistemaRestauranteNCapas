package com.example.sistemaderestaurante.controller;
import com.example.sistemaderestaurante.dto.PlatoRequestDTO;
import com.example.sistemaderestaurante.dto.PlatoResponseDTO;
import com.example.sistemaderestaurante.service.PlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/platos")
public class PlatoController {

    private final PlatoService platoService;

    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    // 1. CREAR (POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlatoResponseDTO crear(@RequestBody PlatoRequestDTO requestDTO) {
        return platoService.crearPlato(requestDTO);
    }

    // 2. OBTENER TODOS (GET)
    @GetMapping
    public List<PlatoResponseDTO> obtenerTodos() {
        return platoService.obtenerPlatos();
    }

    // 3. OBTENER POR ID (GET)
    @GetMapping("/{id}")
    public PlatoResponseDTO obtenerPorId(@PathVariable Long id) {
        return platoService.obtenerPlatoPorId(id);
    }

    // 4. ACTUALIZAR (PUT)
    @PutMapping("/{id}")
    public PlatoResponseDTO actualizar(
            @PathVariable Long id,
            @RequestBody PlatoRequestDTO requestDTO) {
        return platoService.actualizarPlato(id, requestDTO);
    }

    // 5. ELIMINAR (DELETE)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        platoService.eliminarPlato(id);
    }

}