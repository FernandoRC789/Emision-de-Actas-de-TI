package com.nickempresa.sistemaactas.service.impl;

import com.nickempresa.sistemaactas.entity.Acta;
import com.nickempresa.sistemaactas.entity.Firma;
import com.nickempresa.sistemaactas.service.PdfService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

@Service
public class PdfServiceImpl implements PdfService {

    @Override
    public byte[] generarPdfActa(Acta acta) throws Exception {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);
        document.open();

        // Título
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        Paragraph title = new Paragraph("Acta #" + acta.getId(), titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(new Paragraph(" "));
        document.add(new Paragraph("Tipo de Acta: " + acta.getTipoActa().getDescripcion()));
        document.add(new Paragraph("Colaborador: " + acta.getFichaColaborador().getNombres() + " " + acta.getFichaColaborador().getApellidos()));
        document.add(new Paragraph("Observaciones: " + acta.getObservaciones()));
        document.add(new Paragraph("Fecha: " + acta.getFechaEmision()));
        document.add(new Paragraph(" "));

        // Activos
        Paragraph activos = new Paragraph("Activos:");
        for (var a : acta.getActivos()) {
            activos.add("\n - " + a.getTipo() + " — " + a.getNumeroSerie());
        }
        document.add(activos);
        document.add(new Paragraph(" "));

        // Firmas
        for (Firma f : acta.getFirmas()) {
            byte[] decodedImg = Base64.getDecoder().decode(f.getImagenBase64());
            Image img = Image.getInstance(decodedImg);
            img.scaleToFit(150, 50);
            document.add(new Paragraph(f.getPersonaTipo() + ":"));
            document.add(img);
            document.add(new Paragraph(" "));
        }

        document.close();
        return out.toByteArray();
    }
}
