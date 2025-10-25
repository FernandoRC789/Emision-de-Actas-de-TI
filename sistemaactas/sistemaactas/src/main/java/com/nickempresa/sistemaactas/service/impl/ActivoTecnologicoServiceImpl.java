package com.nickempresa.sistemaactas.service.impl;

import com.nickempresa.sistemaactas.entity.ActivoTecnologico;
import com.nickempresa.sistemaactas.repository.ActivoTecnologicoRepository;
import com.nickempresa.sistemaactas.service.ActivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivoTecnologicoServiceImpl implements ActivoService {

    @Autowired
    private ActivoTecnologicoRepository repository;

    @Override
    public ActivoTecnologico registrar(ActivoTecnologico activo) {
        return repository.save(activo);
    }

    @Override
    public List<ActivoTecnologico> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<ActivoTecnologico> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
