package com.nickempresa.sistemaactas.service;

import com.nickempresa.sistemaactas.entity.FichaColaborador;

import java.util.List;

public interface FichaColaboradorService {
    FichaColaborador registrar(FichaColaborador colaborador);
    List<FichaColaborador> listar();
    FichaColaborador buscarPorDni(String dni);
    void eliminar(Integer id);
}
