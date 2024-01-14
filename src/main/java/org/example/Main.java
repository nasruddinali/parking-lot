package org.example;

import org.example.enums.DisplayType;
import org.example.enums.VehicleType;
import org.example.service.InMemoryService;
import org.example.service.ParkingLotService;
import org.example.constants.Commands;
import org.example.util.VehicleUtil;

import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        Scanner scanner = new Scanner(System.in);
        InMemoryService inMemoryService = new InMemoryService();
        ParkingLotService parkingLotService = new ParkingLotService();
        while (true) {
            String[] inp = scanner.nextLine().trim().split(" ");
            try {
                switch (inp[0]) {
                    case Commands.CREATE -> {
                        parkingLotService.createParkingLot(inp[1], Integer.parseInt(inp[2]), Integer.parseInt(inp[3]));
                    }
                    case Commands.DISPLAY -> {
                        System.out.println(DisplayType.valueOf(inp[1]));
                        parkingLotService.display(DisplayType.valueOf(inp[1]) , VehicleType.valueOf(inp[2]));
                    }
                    case Commands.PARK -> {
                        parkingLotService.parkVehicle(VehicleUtil.generateVehicleDTO(VehicleType.valueOf(inp[1]) , inp[2], inp[3]));
                    }
                    case Commands.UNPARK -> {
                        parkingLotService.unParkVehicle(inp[1]);
                    }
                    case Commands.EXIT -> {
                        System.exit(0);
                    }

                    default -> {
                        System.out.println("INVALID INPUT");
                    }
                }
            } catch (RuntimeException e){
                System.out.println(e);
            }
        }
    }
}