package com.nickempresa.sistemaactas.controller;

import com.nickempresa.sistemaactas.entity.FichaColaborador;
import com.nickempresa.sistemaactas.service.FichaColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/colaboradores")
public class FichaColaboradorController {

    @Autowired
    private FichaColaboradorService colaboradorService;

    // LISTAR + FORMULARIO (CRUD completo en una vista)
    @GetMapping
    public String listar(Model model, @RequestParam(value = "exito", required = false) String exito) {
        model.addAttribute("colaboradores", colaboradorService.listar());
        model.addAttribute("colaborador", new FichaColaborador());
        model.addAttribute("exito", exito);
        return "colaboradores";
    }

    // GUARDAR O ACTUALIZAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute FichaColaborador colaborador) {
        colaboradorService.registrar(colaborador);
        return "redirect:/colaboradores?exito=true";
    }

    // EDITAR: carga los datos del colaborador al formulario
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        FichaColaborador c = colaboradorService.listar()
                .stream()
                .filter(col -> col.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("colaborador", c);
        model.addAttribute("colaboradores", colaboradorService.listar());
        return "colaboradores";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        colaboradorService.eliminar(id);
        return "redirect:/colaboradores";
    }
}
