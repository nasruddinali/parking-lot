package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.VehicleType;

@Getter
@Setter
@AllArgsConstructor
public class Vehicle {
    private final String registrationNumber;
    private final String color;
    private final VehicleType vehicleType;

}
