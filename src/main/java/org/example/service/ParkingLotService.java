package org.example.service;

import org.example.dto.*;
import org.example.enums.DisplayType;
import org.example.enums.ParkingSlotStatus;
import org.example.enums.VehicleType;
import org.example.repository.ParkingFloorRepository;
import org.example.repository.ParkingLotRepository;
import org.example.repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLotService {
    List<ParkingLot>parkingLots = ParkingLotRepository.parkingLots;
    public void createParkingLot(String parkingLotId, int numberOfFloors, int noOfSlotsPerFloor){
        List<Floor> parkingFloorList = new ArrayList<>(numberOfFloors);

        for (int i = 0 ; i < numberOfFloors ; i++) {
            List<ParkingSlot> parkingSlotList = new ArrayList<>(noOfSlotsPerFloor);

            for (int j = 0; j <noOfSlotsPerFloor ; j++) {
                ParkingSlot slot;
                if(j == 0 ) {
                    slot = new ParkingSlot(String.valueOf(j + 1), parkingLotId, String.valueOf(i + 1), VehicleType.TRUCK, ParkingSlotStatus.AVAILABLE);
                }
                else if (j == 1 || j == 2) {
                    slot = new ParkingSlot(String.valueOf(j+1),parkingLotId,String.valueOf(i+1), VehicleType.BIKE, ParkingSlotStatus.AVAILABLE);
                }
                else  slot = new ParkingSlot(String.valueOf(j+1),parkingLotId,String.valueOf(i+1), VehicleType.CAR, ParkingSlotStatus.AVAILABLE);

                parkingSlotList.add(slot);
            }
            Floor floor = new Floor(parkingSlotList,i+1,parkingLotId);
            parkingFloorList.add(floor);
        }
        ParkingLot parkingLot = new ParkingLot(parkingLotId,numberOfFloors,noOfSlotsPerFloor,parkingFloorList);

        ParkingLotRepository.getParkingLotRepositoryMap().put(parkingLotId,parkingLot);
        ParkingLotRepository.getParkingLots().add(parkingLot);
        System.out.println("Created parking lot with " + numberOfFloors+" floors and "+ noOfSlotsPerFloor+" slots per floor");
    }
    public void parkVehicle(Vehicle vehicle) {
        ParkingLot parkingLot = parkingLots.get(0);
        List<Floor> parkingFloors = parkingLot.getFloors();
        int parkingFloorIndex = 0;
        int floorFloorIndex = 0;
        int floorFullCount = 0;
        for (Floor floor : parkingFloors){
            parkingFloorIndex++;
            if(ParkingFloorService.getFreeSlotCount(floor, vehicle.getVehicleType()) > 0) {
               Optional<Ticket> ticket = Optional.ofNullable(ParkingFloorService.parkVehicle(floor, vehicle));

                ticket.ifPresent(value -> System.out.println("Parked Vehicle, Ticket ID " + value.getId()));
                break;
            }
            else floorFullCount++;
        }
        if(floorFullCount == parkingLots.size()){
            System.out.println("Parking lot full");
        }
    }
    public void unParkVehicle(String ticketId){
        ParkingLot parkingLot = parkingLots.get(0);
        Ticket ticket = TicketService.getTicketByTicketId(ticketId);
        ParkingSlot parkingSlot = ticket.getParkingSlot();
        Vehicle vehicle = ticket.getVehicle();
        ParkingSlotService parkingSlotService = new ParkingSlotService();
        parkingSlotService.unPark(parkingSlot,vehicle);
        TicketService.deleteTicket(ticketId);
        System.out.println("un-parked vehicle with regisstation number "+vehicle.getRegistrationNumber() +" and color: "+vehicle.getColor());
    }
    public void display(DisplayType displayType, VehicleType vehicleType) {
        ParkingLot parkingLot = parkingLots.get(0);
        List<Floor> floors = parkingLot.getFloors();
        int parkingFloorIndex = 0;

        for (Floor floor : floors){
            parkingFloorIndex++;
            if(displayType.equals(DisplayType.free_count)){
                int freeSlotCount = ParkingFloorService.getFreeSlotCount(floor,vehicleType);
                System.out.println("Free Slots for "+ vehicleType +" on Floor "+parkingFloorIndex+" : "+ freeSlotCount);
            }
            else if(displayType.equals(DisplayType.free_slots)){
                System.out.print("Free slots for "+ vehicleType+" on Floor "+parkingFloorIndex+": ");
                ParkingFloorService.getFreeSlots(floor,vehicleType);
//                System.out.println("Free Slots for "+ vehicleType +" on Floor "+parkingFloorIndex+" : "+ freeSlotCount);
            }
            else if(displayType.equals(DisplayType.occupied_slots)) {
                System.out.print("Occupied slots for "+ vehicleType+"on Floor "+parkingFloorIndex+": ");
                ParkingFloorService.getOccupiedSlot(floor,vehicleType);
                System.out.println();
            }
        }
    }

}
