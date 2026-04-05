package com.pavan.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.pavan.billing.model.Invoice;
import com.pavan.billing.repository.InvoiceRepository;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository repo;

    @Autowired
    private AiService aiService;

    public List<Invoice> getAllInvoices() {
        return repo.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteInvoice(Long id) {
        repo.deleteById(id);
    }

    public Invoice saveInvoice(Invoice invoice) {
    double tax = invoice.getAmount() * 0.18;
    invoice.setTax(tax);
    invoice.setTotalAmount(invoice.getAmount() + tax);

    String prompt = "Generate a short summary for invoice of amount "
            + invoice.getAmount() + " with tax " + tax;

    // String aiResponse = aiService.generateSummary(prompt);

    // invoice.setAiSummary(aiResponse); // 🔥 important

    invoice.setAiSummary("AI summary temporarily disabled");

    return repo.save(invoice);
}
}