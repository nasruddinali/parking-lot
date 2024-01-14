package org.example.dto;


import lombok.Getter;
import lombok.Setter;
import org.example.enums.ParkingSlotStatus;
import org.example.enums.VehicleType;

@Getter
@Setter
public class ParkingSlot {
    private final String id;
    private final String parkingLot;
    private final String  parkingFloor;
    private final VehicleType vehicleType;
    private Vehicle vehicle;
    private ParkingSlotStatus  parkingSlotStatus;
    private Ticket ticket;

    public ParkingSlot(String id, String parkingLot, String parkingFloor, VehicleType vehicleType, ParkingSlotStatus parkingSlotStatus) {
        this.id = id;
        this.parkingLot = parkingLot;
        this.parkingFloor = parkingFloor;
        this.vehicleType = vehicleType;
        this.parkingSlotStatus = parkingSlotStatus;
    }
}
