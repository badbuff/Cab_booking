package com.example.cabBooking.service;

import com.example.cabBooking.model.Booking;
import com.example.cabBooking.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setCustomerName(updatedBooking.getCustomerName());
            booking.setPickupLocation(updatedBooking.getPickupLocation());
            booking.setDropoffLocation(updatedBooking.getDropoffLocation());
            booking.setBookingTime(updatedBooking.getBookingTime());
            booking.setPrice(updatedBooking.getPrice());
            return bookingRepository.save(booking);
        }).orElseThrow(() -> new RuntimeException("Booking not found with id " + id));
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
