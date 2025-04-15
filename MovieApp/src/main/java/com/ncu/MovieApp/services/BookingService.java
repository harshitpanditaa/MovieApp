package com.ncu.MovieApp.services;

import com.ncu.MovieApp.entities.Booking;
import com.ncu.MovieApp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking insertBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBookingById(int id, Booking updatedBooking) {
        Optional<Booking> existingBooking = bookingRepository.findById(id);
        if (existingBooking.isPresent()) {
            Booking booking = existingBooking.get();
            booking.setCustomerName(updatedBooking.getCustomerName());
            booking.setNumberOfSeats(updatedBooking.getNumberOfSeats());
            booking.setMovie(updatedBooking.getMovie());
            return bookingRepository.save(booking);
        } else {
            return null;
        }
    }

    public Booking deleteBookingById(int id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isPresent()) {
            bookingRepository.deleteById(id);
            return booking.get();
        } else {
            return null;
        }
    }

    public Booking getBookingById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
