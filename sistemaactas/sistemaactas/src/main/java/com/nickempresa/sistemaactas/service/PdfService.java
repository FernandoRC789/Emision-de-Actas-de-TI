package com.nickempresa.sistemaactas.service;

import com.nickempresa.sistemaactas.entity.Acta;
public interface PdfService {
    byte[] generarPdfActa(Acta acta) throws Exception;
}
