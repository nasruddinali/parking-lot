package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Ticket {
    private String id;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;

}
