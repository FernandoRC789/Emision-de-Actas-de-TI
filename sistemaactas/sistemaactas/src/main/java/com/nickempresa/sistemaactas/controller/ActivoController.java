package com.nickempresa.sistemaactas.controller;

import com.nickempresa.sistemaactas.entity.ActivoTecnologico;
import com.nickempresa.sistemaactas.service.ActivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/activos")
public class ActivoController {

    @Autowired
    private ActivoService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("activos", service.listar());
        model.addAttribute("activo", new ActivoTecnologico()); // Para el formulario vacío
        return "activos";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute ActivoTecnologico activo) {
        service.registrar(activo);
        return "redirect:/activos?exito=true";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        ActivoTecnologico activo = service.buscarPorId(id)
                .orElse(new ActivoTecnologico());
        model.addAttribute("activo", activo);
        model.addAttribute("activos", service.listar());
        return "activos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/activos";
    }
}