package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.dto.Floor;

import java.util.List;

@Getter
@Setter
public class ParkingLot {

    private final String id;
    private int numberOfFloors;
    private final int numberOfSlotsPerFloor;
    List<Floor>  floors;

    public ParkingLot(String id, int numberOfFloors, int numberOfSlotsPerFloor, List<Floor> floors) {
        this.id = id;
        this.numberOfFloors = numberOfFloors;
        this.numberOfSlotsPerFloor = numberOfSlotsPerFloor;
        this.floors = floors;
    }
}
