package com.ncu.MovieApp.controller;

import com.ncu.MovieApp.entities.Booking;
import com.ncu.MovieApp.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public String createBooking(@RequestBody Booking booking) {
        bookingService.insertBooking(booking);
        return "Booking created successfully!";
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.updateBookingById(id, booking);
    }

    @DeleteMapping("/{id}")
    public Booking deleteBooking(@PathVariable int id) {
        return bookingService.deleteBookingById(id);
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable int id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
}
