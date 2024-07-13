package org.example.uberbookingservice.dto;

import lombok.*;
import org.example.uberprojectentityservice.models.ExactLocation;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateBookingDto {
    private Long passengerId;

    private ExactLocation startLocation;

    private ExactLocation endLocation;
}
