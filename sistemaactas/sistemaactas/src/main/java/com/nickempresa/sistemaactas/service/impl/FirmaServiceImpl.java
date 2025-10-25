package com.nickempresa.sistemaactas.service.impl;

import com.nickempresa.sistemaactas.entity.Firma;
import com.nickempresa.sistemaactas.repository.FirmaRepository;
import com.nickempresa.sistemaactas.service.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirmaServiceImpl implements FirmaService {

    @Autowired
    private FirmaRepository firmaRepository;

    @Override
    public Firma crearFirma(Firma firma) {
        return firmaRepository.save(firma);
    }

    @Override
    public List<Firma> listar() {
        return firmaRepository.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        firmaRepository.deleteById(id);
    }
}
