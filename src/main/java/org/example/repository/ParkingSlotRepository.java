package org.example.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.dto.ParkingSlot;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ParkingSlotRepository {
    private static Map<String, ParkingSlot> parkingSlotMap;

    public ParkingSlotRepository() {
        parkingSlotMap = new HashMap<>();
    }
}
