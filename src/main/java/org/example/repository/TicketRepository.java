package org.example.repository;

import lombok.Getter;
import lombok.Setter;
import org.example.dto.Ticket;

import java.util.HashMap;
import java.util.Map;


public class TicketRepository {
    @Getter
    public static Map<String, Ticket> ticketMap;

    public TicketRepository() {
        ticketMap  = new HashMap<>();
    }

}
