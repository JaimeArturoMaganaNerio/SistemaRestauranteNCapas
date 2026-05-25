package com.example.sistemaderestaurante.repository;

import com.example.sistemaderestaurante.entity.PlatoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPlatoRepository  extends JpaRepository<PlatoEntidad,Long>{



}
