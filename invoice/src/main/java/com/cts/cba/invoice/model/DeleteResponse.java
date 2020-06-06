package com.cts.cba.invoice.model;

public class DeleteResponse {
    private int invoiceId;
    private String message;

    public DeleteResponse(int invoiceId) {
        this.invoiceId = invoiceId;
        this.message = "Invoice deleted successfully";
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}