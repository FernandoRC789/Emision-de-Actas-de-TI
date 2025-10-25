package com.nickempresa.sistemaactas.controller;

import com.nickempresa.sistemaactas.entity.Acta;
import com.nickempresa.sistemaactas.entity.Firma;
import com.nickempresa.sistemaactas.repository.ActaRepository;
import com.nickempresa.sistemaactas.service.ActaService;
import com.nickempresa.sistemaactas.service.ActivoService;
import com.nickempresa.sistemaactas.service.FichaColaboradorService;
import com.nickempresa.sistemaactas.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
@RequestMapping("/actas")
public class ActaController {

    @Autowired
    private ActaService actaService;

    @Autowired
    private FichaColaboradorService colaboradorService;

    @Autowired
    private ActivoService activoService;

    @Autowired
    private PdfService pdfService;

    @Autowired
    private ActaRepository actaRepository;

    // LISTAR TODAS LAS ACTAS
    @GetMapping
    public String listarActas(Model model) {
        model.addAttribute("actas", actaService.listarActas());
        model.addAttribute("acta", new Acta());
        model.addAttribute("colaboradores", colaboradorService.listar());
        model.addAttribute("activos", activoService.listar());
        model.addAttribute("tipos", actaService.listarActas());
        return "actas";
    }

    // GUARDAR O ACTUALIZAR ACTA
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Acta acta,
                          @RequestParam(value = "firmaFile", required = false) MultipartFile firmaFile,
                          @RequestParam(value = "firmaSeleccionadaId", required = false) Integer firmaId) {
        actaService.guardarActa(acta, firmaFile, firmaId);
        return "redirect:/actas?exito=true";
    }

    // EDITAR ACTA
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Acta acta = actaService.obtenerPorId(id);
        model.addAttribute("acta", acta);
        model.addAttribute("actas", actaService.listarActas());
        model.addAttribute("colaboradores", colaboradorService.listar());
        model.addAttribute("activos", activoService.listar());
        model.addAttribute("tipos", actaService.listarTiposActa());
        return "actas";
    }

    // ELIMINAR ACTA
    @GetMapping("/eliminar/{id}")
    public String eliminarActa(@PathVariable Integer id) {
        actaService.eliminarActa(id);
        return "redirect:/actas";
    }

    // GENERAR PDF
    @GetMapping("/pdf/{id}")
    public ResponseEntity<InputStreamResource> generarPdf(@PathVariable Integer id) throws Exception {
        Acta acta = actaRepository.findById(id).orElseThrow();
        byte[] pdfBytes = pdfService.generarPdfActa(acta); // byte[] desde el servicio
        ByteArrayInputStream bis = new ByteArrayInputStream(pdfBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=acta_" + acta.getCodigoActa() + ".pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
