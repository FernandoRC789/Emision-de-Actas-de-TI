package com.nickempresa.sistemaactas.service;

import com.nickempresa.sistemaactas.entity.Acta;
import com.nickempresa.sistemaactas.entity.FichaColaborador;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ActaService {

    // Crear o actualizar una acta
    Acta guardarActa(Acta acta, MultipartFile firmaFile, Integer firmaId);

    // Listar todas las actas
    List<Acta> listarActas();

    // Obtener acta por ID
    Acta obtenerPorId(Integer id);

    // Eliminar acta
    void eliminarActa(Integer id);

    // Listar actas por colaborador
    List<Acta> listarPorColaborador(FichaColaborador colaborador);

    // Listar tipos de acta (para combo en Thymeleaf)
    List<String> listarTiposActa();
}
