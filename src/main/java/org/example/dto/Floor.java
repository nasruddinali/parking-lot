package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Floor {
    private int AVAILABLE_BIKE_SLOTS;
    private int AVAILABLE_CAR_SLOTS;
    private int AVAILABLE_TRUCK_SLOTS;
    private String parkingLotName;
    private int floorNumber;
    private List<ParkingSlot> parkingSlots;

    public Floor(List<ParkingSlot> parkingSlots, int floorNumber, String parkingLotName) {
        this.parkingLotName = parkingLotName;
        this.floorNumber = floorNumber;
        this.parkingSlots = new ArrayList<>();
        this.AVAILABLE_BIKE_SLOTS = 3;
        this.AVAILABLE_TRUCK_SLOTS = 1;
        this.AVAILABLE_CAR_SLOTS = parkingSlots.size()-4;
       this.parkingSlots = parkingSlots;
    }
}
