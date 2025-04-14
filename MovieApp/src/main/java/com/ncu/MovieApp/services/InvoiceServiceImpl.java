package com.ncu.MovieApp.services;

import com.ncu.MovieApp.entities.Invoice;
import com.ncu.MovieApp.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoice); // Changed this to default JPA save()
    }

    @Override
    public Invoice getInvoiceById(int id) {
        return invoiceRepository.findById(id).orElse(null); // Changed to standard JPA findById
    }
}
