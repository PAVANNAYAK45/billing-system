package com.pavan.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.pavan.billing.model.Invoice;
import com.pavan.billing.service.InvoiceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    // CREATE
    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return service.saveInvoice(invoice);
    }

    // GET ALL
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return service.getAllInvoices();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Invoice getInvoice(@PathVariable Long id) {
        return service.getInvoiceById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteInvoice(@PathVariable Long id) {
        service.deleteInvoice(id);
        return "Invoice deleted successfully";
    }

    // UPDATE
    @PutMapping("/{id}")
    public Invoice updateInvoice(@PathVariable Long id, @Valid @RequestBody Invoice invoice) {
        invoice.setId(id);
        return service.saveInvoice(invoice);
    }
}