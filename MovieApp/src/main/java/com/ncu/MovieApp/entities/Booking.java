package com.ncu.MovieApp.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    private String customerName;
    private String movieName;
    private int quantity;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Invoice invoice;

    @OneToMany
    @JoinColumn(name = "booking_id")
    private List<Movie> movies;

    public Booking() {}

    public Booking(String customerName, String movieName, int quantity) {
        this.customerName = customerName;
        this.movieName = movieName;
        this.quantity = quantity;
    }

    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Invoice getInvoice() { return invoice; }
    public void setInvoice(Invoice invoice) { this.invoice = invoice; }

    public List<Movie> getMovies() { return movies; }
    public void setMovies(List<Movie> movies) { this.movies = movies; }
}
