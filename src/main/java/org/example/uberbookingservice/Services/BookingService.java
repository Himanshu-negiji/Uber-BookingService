package org.example.uberbookingservice.Services;


import org.example.uberbookingservice.dto.CreateBookingDto;
import org.example.uberbookingservice.dto.CreateBookingResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    CreateBookingResponseDto createBooking(CreateBookingDto bookingDetails);
}
