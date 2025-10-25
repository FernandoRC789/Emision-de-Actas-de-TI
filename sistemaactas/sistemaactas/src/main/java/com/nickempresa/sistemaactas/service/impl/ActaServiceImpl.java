package com.nickempresa.sistemaactas.service.impl;

import com.nickempresa.sistemaactas.entity.Acta;
import com.nickempresa.sistemaactas.entity.FichaColaborador;
import com.nickempresa.sistemaactas.entity.Firma;
import com.nickempresa.sistemaactas.repository.ActaRepository;
import com.nickempresa.sistemaactas.service.ActaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActaServiceImpl implements ActaService {

    @Autowired
    private ActaRepository actaRepository;

    @Override
    public Acta guardarActa(Acta acta, MultipartFile firmaFile, Integer firmaId) {
        try {
            if (firmaFile != null && !firmaFile.isEmpty()) {
                Firma firma = new Firma();

                // Convertir archivo a Base64
                String base64 = java.util.Base64.getEncoder().encodeToString(firmaFile.getBytes());
                firma.setImagenBase64(base64);

                // Configuración básica de firma
                firma.setPersonaTipo("COLABORADOR"); // o "TI", según la lógica
                firma.setFechaRegistro(LocalDateTime.now());

                // Si se necesita asignar firmaId para actualizar, lo puedes hacer
                if (firmaId != null) {
                    firma.setId(firmaId);
                }

                // Inicializar lista de firmas si es null
                if (acta.getFirmas() == null) {
                    acta.setFirmas(new ArrayList<>());
                }
                acta.getFirmas().add(firma);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return actaRepository.save(acta);
    }

    @Override
    public List<Acta> listarActas() {
        return actaRepository.findAll();
    }

    @Override
    public Acta obtenerPorId(Integer id) {
        return actaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarActa(Integer id) {
        actaRepository.deleteById(id);
    }

    @Override
    public List<Acta> listarPorColaborador(FichaColaborador colaborador) {
        return actaRepository.findByFichaColaborador(colaborador);
    }

    @Override
    public List<String> listarTiposActa() {
        // Aquí podrías retornar los códigos de tipo_acta desde la base de datos
        // Por ahora retornamos vacío como placeholder
        return List.of();
    }
}
