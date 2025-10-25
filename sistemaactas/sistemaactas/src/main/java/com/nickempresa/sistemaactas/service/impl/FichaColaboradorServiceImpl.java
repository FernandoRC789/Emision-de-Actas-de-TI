package com.nickempresa.sistemaactas.service.impl;

import com.nickempresa.sistemaactas.entity.FichaColaborador;
import com.nickempresa.sistemaactas.repository.FichaColaboradorRepository;
import com.nickempresa.sistemaactas.service.FichaColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaColaboradorServiceImpl implements FichaColaboradorService {

    @Autowired
    private FichaColaboradorRepository colaboradorRepository;

    @Override
    public FichaColaborador registrar(FichaColaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    @Override
    public List<FichaColaborador> listar() {
        return colaboradorRepository.findAll();
    }

    @Override
    public FichaColaborador buscarPorDni(String dni) {
        return colaboradorRepository.findByDni(dni);
    }

    @Override
    public void eliminar(Integer id) {
        colaboradorRepository.deleteById(id);
    }
}
