package org.example.service;

import org.example.dto.Floor;
import org.example.dto.ParkingSlot;
import org.example.dto.Ticket;
import org.example.dto.Vehicle;
import org.example.enums.ParkingSlotStatus;
import org.example.enums.VehicleType;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingFloorService {
    static int getFreeSlotCount(Floor floor, VehicleType vehicleType) {
        List<ParkingSlot> parkingSlots  = floor.getParkingSlots();
        return (int) parkingSlots.stream().filter(slot-> slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE) &&
                slot.getVehicleType().equals(vehicleType)).count();
    }
    static void getFreeSlots(Floor floor,  VehicleType vehicleType){
        List<ParkingSlot> parkingSlots = floor.getParkingSlots();
        parkingSlots.stream().filter(slot -> slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE) &&
                slot.getVehicleType().equals(vehicleType)).forEach(e-> System.out.println(e.getId() +", "));
    }
    static void getOccupiedSlot(Floor floor,  VehicleType vehicleType){
        List<ParkingSlot> parkingSlots = floor.getParkingSlots();
        parkingSlots.stream().filter(slot -> slot.getParkingSlotStatus().equals(ParkingSlotStatus.UNAVAILABLE) &&
                slot.getVehicleType().equals(vehicleType)).forEach(e-> System.out.println(e.getId() +", "));
    }

    static Ticket parkVehicle(Floor floor, Vehicle vehicle){
        List<ParkingSlot> parkingSlots = floor.getParkingSlots();
        List<ParkingSlot> availableParkingSlots = parkingSlots.stream().filter(slot->slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE) &&
                slot.getVehicleType().equals(vehicle.getVehicleType())).toList();

        if(!availableParkingSlots.isEmpty()){
            ParkingSlot slot = availableParkingSlots.get(0);
            ParkingSlotService parkingSlotService = new ParkingSlotService();
            return parkingSlotService.parkVehicle(slot, vehicle);
        }
        return null;
    }



}
