package org.example.service;

import org.example.dto.ParkingSlot;
import org.example.dto.Ticket;
import org.example.dto.Vehicle;
import org.example.repository.TicketRepository;

public class TicketService {
    static Ticket generateTicket(ParkingSlot slot, Vehicle vehicle){
        String ticketId = generateTicketId(slot);
        Ticket ticket = new Ticket(ticketId,vehicle,slot);
        TicketRepository.getTicketMap().put(ticketId,ticket);
        return ticket;
    }

    private static String generateTicketId(ParkingSlot slot) {
        return String.valueOf(slot.getParkingLot() + "_"+slot.getParkingFloor() + slot.getId());
    }
    public static Ticket getTicketByTicketId(String ticketId){
        if (!TicketRepository.getTicketMap().containsKey(ticketId))
            throw new RuntimeException("INVALID TICKET");
        return TicketRepository.getTicketMap().get(ticketId);
    }
    static void deleteTicket(String ticketId){
        TicketRepository.getTicketMap().remove(ticketId);
    }
}
