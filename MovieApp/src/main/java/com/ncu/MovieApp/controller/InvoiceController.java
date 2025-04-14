package com.ncu.MovieApp.controller;

import com.ncu.MovieApp.entities.Invoice;
import com.ncu.MovieApp.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public String createInvoice(@RequestBody Invoice invoice) {
        invoiceService.saveInvoice(invoice);
        return "Invoice saved successfully!";
    }

    @GetMapping("/{id}")
    public Invoice getInvoice(@PathVariable int id) {
        return invoiceService.getInvoiceById(id);
    }
}
