package com.nickempresa.sistemaactas.repository;

import com.nickempresa.sistemaactas.entity.ActivoTecnologico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivoTecnologicoRepository extends JpaRepository<ActivoTecnologico, Integer> {
    List<ActivoTecnologico> findByTipo(String tipo);
    List<ActivoTecnologico> findByEstado(String estado);
    ActivoTecnologico findByCodigoInterno(String codigoInterno);
}
