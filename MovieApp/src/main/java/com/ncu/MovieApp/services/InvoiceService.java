package com.ncu.MovieApp.services;

import com.ncu.MovieApp.entities.Invoice;

public interface InvoiceService {
    void saveInvoice(Invoice invoice);
    Invoice getInvoiceById(int id);
}
