package org.example.repository;

import lombok.Getter;
import org.example.dto.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {
    public static Map<String, ParkingLot> parkingLotRepositoryMap;
    public static List<ParkingLot> parkingLots;

    public ParkingLotRepository() {
        parkingLots = new ArrayList<>();
        parkingLotRepositoryMap = new HashMap<>();
    }

    public static Map<String, ParkingLot> getParkingLotRepositoryMap() {
        return parkingLotRepositoryMap;
    }

    public static List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
