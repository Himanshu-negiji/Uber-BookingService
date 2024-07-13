package org.example.uberbookingservice.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NearByDriverRequestDto {

    Double latitude;

    Double longitude;
}
