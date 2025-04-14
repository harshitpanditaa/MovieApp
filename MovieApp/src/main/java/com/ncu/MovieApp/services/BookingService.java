package com.ncu.MovieApp.services;

import com.ncu.MovieApp.entities.Booking;
import java.util.List;

public interface BookingService {
    void insertBooking(Booking booking);
    Booking updateBookingById(int id, Booking booking);
    Booking deleteBookingById(int id);
    Booking getBookingById(int id);
    List<Booking> getAllBookings();
}
