package com.ncu.MovieApp.services;

import com.ncu.MovieApp.entities.Booking;
import com.ncu.MovieApp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void insertBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public Booking updateBookingById(int id, Booking booking) {
        Optional<Booking> existingBooking = bookingRepository.findById(id);
        if (existingBooking.isPresent()) {
            booking.setBookingId(id);
            return bookingRepository.save(booking);
        }
        return null;
    }

    @Override
    public Booking deleteBookingById(int id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isPresent()) {
            bookingRepository.deleteById(id);
            return booking.get();
        }
        return null;
    }

    @Override
    public Booking getBookingById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
