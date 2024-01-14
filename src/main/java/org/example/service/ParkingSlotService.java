package org.example.service;

import org.example.dto.ParkingSlot;
import org.example.dto.Ticket;
import org.example.dto.Vehicle;
import org.example.enums.ParkingSlotStatus;

public class ParkingSlotService {


    public Ticket parkVehicle(ParkingSlot slot , Vehicle vehicle){
        slot.setParkingSlotStatus(ParkingSlotStatus.UNAVAILABLE);
        Ticket ticket = TicketService.generateTicket(slot,vehicle);
        slot.setTicket(ticket);
        return ticket;
    }

    public void unPark(ParkingSlot slot, Vehicle vehicle) {
        slot.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);
        slot.setTicket(null);
    }

}
