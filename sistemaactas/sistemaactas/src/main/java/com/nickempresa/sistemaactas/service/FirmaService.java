package com.nickempresa.sistemaactas.service;

import com.nickempresa.sistemaactas.entity.Firma;

import java.util.List;

public interface FirmaService {
    Firma crearFirma(Firma firma);
    List<Firma> listar();
    void eliminar(Integer id);
}
