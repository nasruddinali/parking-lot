package org.example.repository;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ParkingFloorRepository {
    public static Map<String , ParkingFloorRepository> parkingFloorRepositoryMap;

    public ParkingFloorRepository() {
        parkingFloorRepositoryMap = new HashMap<>();
    }
}
