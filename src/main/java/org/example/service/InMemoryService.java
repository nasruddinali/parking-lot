package org.example.service;

import org.example.dto.Ticket;
import org.example.repository.ParkingFloorRepository;
import org.example.repository.ParkingLotRepository;
import org.example.repository.ParkingSlotRepository;
import org.example.repository.TicketRepository;

public class InMemoryService {
  private ParkingLotRepository parkingLotRepository;
  private ParkingSlotRepository parkingSlotRepository;
  private ParkingFloorRepository parkingFloorRepository;
  private TicketRepository ticketRepository;

    public InMemoryService() {
        parkingLotRepository = new ParkingLotRepository();
        parkingSlotRepository = new ParkingSlotRepository();
        parkingFloorRepository = new ParkingFloorRepository();
        ticketRepository = new TicketRepository();
    }
}
