package com.ncu.MovieApp.services;

import com.ncu.MovieApp.entities.Booking;
import com.ncu.MovieApp.jpadata.CustomerProfile;
import com.ncu.MovieApp.jpadata.CustomerProfileRepository;
import com.ncu.MovieApp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerProfileRepository customerProfileRepository;

    public Booking insertBooking(Booking booking) {
        // Save the booking first
        Booking savedBooking = bookingRepository.save(booking);

        // Try to fetch existing profile by name (case-insensitive match)
        List<CustomerProfile> matches = customerProfileRepository.findByFullNameContaining(booking.getCustomerName());

        Optional<CustomerProfile> existingProfileOpt = matches.stream()
                .filter(p -> p.getFullName().equalsIgnoreCase(booking.getCustomerName()))
                .findFirst();

        if (existingProfileOpt.isPresent()) {
            CustomerProfile existingProfile = existingProfileOpt.get();

            boolean updated = false;
            if ((existingProfile.getEmail() == null || existingProfile.getEmail().isEmpty())
                    && booking.getEmail() != null) {
                existingProfile.setEmail(booking.getEmail());
                updated = true;
            }

            if ((existingProfile.getLocation() == null || existingProfile.getLocation().isEmpty())
                    && booking.getLocation() != null) {
                existingProfile.setLocation(booking.getLocation());
                updated = true;
            }

            if (updated) {
                customerProfileRepository.save(existingProfile);
            }
        } else {
            // No match found — create a new profile
            CustomerProfile newProfile = new CustomerProfile();
            newProfile.setFullName(booking.getCustomerName());
            newProfile.setEmail(booking.getEmail());
            newProfile.setLocation(booking.getLocation());
            customerProfileRepository.save(newProfile);
        }

        return savedBooking;
    }

    public Booking updateBookingById(int id, Booking updatedBooking) {
        Optional<Booking> existingBooking = bookingRepository.findById(id);
        if (existingBooking.isPresent()) {
            Booking booking = existingBooking.get();
            booking.setCustomerName(updatedBooking.getCustomerName());
            booking.setNumberOfSeats(updatedBooking.getNumberOfSeats());
            booking.setMovie(updatedBooking.getMovie());
            booking.setEmail(updatedBooking.getEmail());
            booking.setLocation(updatedBooking.getLocation());
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
