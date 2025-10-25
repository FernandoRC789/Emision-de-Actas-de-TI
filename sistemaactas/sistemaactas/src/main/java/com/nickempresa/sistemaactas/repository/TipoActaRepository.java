package com.nickempresa.sistemaactas.repository;

import com.nickempresa.sistemaactas.entity.TipoActa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoActaRepository extends JpaRepository<TipoActa, Integer> {
    TipoActa findByCodigo(String codigo);
}