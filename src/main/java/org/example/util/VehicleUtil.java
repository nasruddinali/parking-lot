package org.example.util;

import org.example.dto.Vehicle;
import org.example.enums.VehicleType;

public class VehicleUtil {
    public static Vehicle generateVehicleDTO(VehicleType vehicleType, String regNo, String color) {
        return new Vehicle(regNo,color,vehicleType);
    }
}
