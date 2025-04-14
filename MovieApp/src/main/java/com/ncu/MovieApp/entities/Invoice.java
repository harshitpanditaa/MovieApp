package com.ncu.MovieApp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceId;

    private String customerName;
    private double amount;
    private String movieName;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public Invoice() {}

    public Invoice(String customerName, double amount, String movieName) {
        this.customerName = customerName;
        this.amount = amount;
        this.movieName = movieName;
    }

    public int getInvoiceId() { return invoiceId; }
    public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking) { this.booking = booking; }
}
