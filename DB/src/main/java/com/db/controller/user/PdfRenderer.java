package com.db.controller.user;

public interface PdfRenderer {
    byte[] render(String html);
}

