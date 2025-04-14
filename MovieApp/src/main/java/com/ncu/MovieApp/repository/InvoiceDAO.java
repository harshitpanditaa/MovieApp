package com.ncu.MovieApp.repository;

import com.ncu.MovieApp.entities.Invoice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveInvoice(Invoice invoice) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(invoice);
            tx.commit();
        }
    }

    public Invoice getInvoiceById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Invoice.class, id);
        }
    }
}
