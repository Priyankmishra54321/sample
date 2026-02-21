package com.db.controller.user;

import org.springframework.stereotype.Service;

@Service
public class PdfService {

    private final PdfRenderer renderer;

    public PdfService(PdfRenderer renderer) {
        this.renderer = renderer;
    }

    public byte[] generateFromHtml(String html) {
        validate(html);
        return renderer.render(html);
    }

    private void validate(String html) {
        if (html == null || html.isBlank()) {
            throw new IllegalArgumentException("HTML cannot be empty");
        }
        if (html.length() > 1_000_000) {
            throw new IllegalArgumentException("HTML too large");
        }
    }
}
