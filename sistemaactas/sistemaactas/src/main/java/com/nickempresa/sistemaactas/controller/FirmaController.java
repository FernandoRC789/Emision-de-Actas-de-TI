package com.nickempresa.sistemaactas.controller;

import com.nickempresa.sistemaactas.entity.Firma;
import com.nickempresa.sistemaactas.service.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping("/firmas")
public class FirmaController {

    @Autowired
    private FirmaService firmaService;

    @GetMapping
    public String listarFirmas(Model model) {
        model.addAttribute("firmas", firmaService.listar());
        model.addAttribute("firma", new Firma());
        return "firmas"; // tu plantilla Thymeleaf
    }

    @PostMapping("/guardar")
    public String guardarFirma(@ModelAttribute Firma firma,
                               @RequestParam("firmaFile") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            String base64 = Base64.getEncoder().encodeToString(file.getBytes());
            firma.setImagenBase64(base64);
        }

        firmaService.crearFirma(firma);
        return "redirect:/firmas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFirma(@PathVariable Integer id) {
        firmaService.eliminar(id);
        return "redirect:/firmas";
    }
}
