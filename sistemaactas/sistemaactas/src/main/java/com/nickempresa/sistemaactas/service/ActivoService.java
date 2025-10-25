package com.nickempresa.sistemaactas.service;

import com.nickempresa.sistemaactas.entity.ActivoTecnologico;

import java.util.List;
import java.util.Optional;

public interface ActivoService {
    ActivoTecnologico registrar(ActivoTecnologico activo);
    List<ActivoTecnologico> listar();
    Optional<ActivoTecnologico> buscarPorId(Integer id);
    void eliminar(Integer id);
}
