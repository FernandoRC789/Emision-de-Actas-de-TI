package com.nickempresa.sistemaactas.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.nickempresa.sistemaactas.entity.Acta;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;

@Component
public class PdfGeneratorUtil {

    public void generarActaPDF(Acta acta) {
        try {
            String nombreArchivo = "Acta_" + acta.getCodigoActa() + ".pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:/ActasGeneradas/" + nombreArchivo));
            document.open();

            Font titulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Paragraph header = new Paragraph("ACTA DE " + acta.getTipoActa().getDescripcion().toUpperCase(), titulo);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Fecha de Emisión: " + acta.getFechaEmision().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))));
            document.add(new Paragraph("Colaborador: " + acta.getFichaColaborador().getNombres() + " " + acta.getFichaColaborador().getApellidos()));
            document.add(new Paragraph("Tipo de Acta: " + acta.getTipoActa().getDescripcion()));

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Observaciones:"));
            document.add(new Paragraph(acta.getObservaciones() != null ? acta.getObservaciones() : "Ninguna."));

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Firmas:"));
            document.add(new Paragraph("__________________________"));
            document.add(new Paragraph("Responsable de TI"));
            document.add(new Paragraph("__________________________"));
            document.add(new Paragraph("Colaborador"));

            document.close();
            System.out.println("✅ PDF generado correctamente: " + nombreArchivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}