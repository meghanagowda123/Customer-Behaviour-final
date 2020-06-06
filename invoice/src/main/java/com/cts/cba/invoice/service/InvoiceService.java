package com.cts.cba.invoice.service;

import java.util.List;
import java.util.Optional;

import com.cts.cba.invoice.entity.Invoice;
import com.cts.cba.invoice.model.DeleteResponse;
import com.cts.cba.invoice.model.InvoiceResponse;
import com.cts.cba.invoice.repository.InvoiceRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

        @Autowired
        InvoiceRepo repo;

        public InvoiceResponse addInvoice(Invoice invoice) {
                Invoice inv = repo.save(invoice);
                return new InvoiceResponse(inv.getInvoiceId());
        }

        public DeleteResponse deleteInvoice(int invoiceId) {
                repo.deleteById(invoiceId);
                return new DeleteResponse(invoiceId);
        }

        public List<Invoice> getAll() {
                return (List<Invoice>) repo.findAll();
        }

        public Optional<Invoice> findById(int invoiceId) {
                return repo.findById(invoiceId);
        }
}