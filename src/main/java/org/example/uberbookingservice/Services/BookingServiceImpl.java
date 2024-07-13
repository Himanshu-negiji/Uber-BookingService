package org.example.uberbookingservice.Services;

import org.example.uberbookingservice.dto.CreateBookingDto;
import org.example.uberbookingservice.dto.CreateBookingResponseDto;
import org.example.uberbookingservice.dto.DriverLocationDto;
import org.example.uberbookingservice.dto.NearByDriverRequestDto;
import org.example.uberbookingservice.repositories.BookingRepository;
import org.example.uberbookingservice.repositories.PassengerRepository;
import org.example.uberprojectentityservice.models.Booking;
import org.example.uberprojectentityservice.models.BookingStatus;
import org.example.uberprojectentityservice.models.Passenger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final PassengerRepository passengerRepository;
    private final RestTemplate restTemplate;
    private static final String LOCATION_SERVICE = "http://localhost:1111";

    public BookingServiceImpl(BookingRepository bookingRepository, PassengerRepository passengerRepository) {
        this.bookingRepository = bookingRepository;
        this.passengerRepository = passengerRepository;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public CreateBookingResponseDto createBooking(CreateBookingDto bookingDetails) {
        Optional<Passenger> passenger = passengerRepository.findById(bookingDetails.getPassengerId());
        Booking booking = Booking.builder()
                .status(BookingStatus.SCHEDULED)
                .startLocation(bookingDetails.getStartLocation())
//                .endLocation(bookingDetails.getEndLocation())
                .passenger(passenger.get())
                .build();

        Booking newBooking = bookingRepository.save(booking);

//        NearByDriverRequestDto nearByDriverRequestDto = NearByDriverRequestDto.builder()
//                .latitude(bookingDetails.getStartLocation().getLatitude())
//                .longitude(bookingDetails.getStartLocation().getLongitude())
//                .build();

//        ResponseEntity<DriverLocationDto[]> result = restTemplate.postForEntity(LOCATION_SERVICE +"/api/location/nearby/drivers", nearByDriverRequestDto, DriverLocationDto[].class);
//
//        List<DriverLocationDto> driverLocations = Arrays.asList(result.getBody());
//
//        driverLocations.forEach(driverLocationDto -> {
//            System.out.println(driverLocationDto.getDriverId() + " "  + "lat: " + driverLocationDto.getLatitude() + " " + "long: " + driverLocationDto.getLongitude());
//        });

        return CreateBookingResponseDto.builder()
                .bookingId(newBooking.getId())
                .bookingStatus(newBooking.getStatus().toString())
//                .driver(Optional.of(newBooking.getDriver()))
                .build();
    }
}
