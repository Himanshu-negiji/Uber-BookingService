package org.example.uberbookingservice.dto;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DriverLocationDto {

    String driverId;

    Double latitude;

    Double longitude;

}
