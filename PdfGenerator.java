package com.example.notification.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;

@Component
public class PdfGenerator {

    public byte[] generateTicketPdf(String ticketInfo) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document doc = new Document();
        PdfWriter.getInstance(doc, out);
        doc.open();
        doc.add(new Paragraph("Ticket Resolved"));
        doc.add(new Paragraph(ticketInfo));
        doc.close();
        return out.toByteArray();
    }
}
