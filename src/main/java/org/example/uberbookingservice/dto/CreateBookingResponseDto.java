package org.example.uberbookingservice.dto;

import lombok.*;
import org.example.uberprojectentityservice.models.Driver;

import java.util.List;
import java.util.Optional;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateBookingResponseDto {

    private Long bookingId;
    private String bookingStatus;
    private Optional<Driver> driver;
}
