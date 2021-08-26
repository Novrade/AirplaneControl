/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.ui;

import FlightControl.domain.Airplane;
import FlightControl.logic.FlightControl;
import java.util.Scanner;

/**
 *
 * @author nowakor
 */
public class UserInterface {
    private final FlightControl flightControl;
    private final Scanner scanner;

    public UserInterface() {
        this.scanner  = new Scanner(System.in);
        this.flightControl = new FlightControl();
    }

    public void airportAssetControl(){
        label:
        while(true){
            System.out.println("Choose an action: ");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            System.out.print(">");
            String choise = scanner.nextLine();

            switch (choise) {
                case "x":
                    break label;
                case "1":
                    addAirplane();
                    System.out.println("Airplane added!");
                    break;
                case "2":
                    addFlight();
                    System.out.println("Flight added!");
                    break;
            }
        }
    }


    public void addAirplane(){
        System.out.print("Give the airplane id: ");
        String planeID = scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        flightControl.addAirplane(planeID, capacity);
    }
    public void addFlight(){
        System.out.print("Give the airplane ID: ");
        Airplane planeID = findPlane(scanner.nextLine());
        System.out.print("Give the departure airport id: ");
        String departureID = scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String destinationID = scanner.nextLine();
        flightControl.addFlight(planeID, departureID, destinationID);
    }

    public Airplane findPlane(String ID){
        for(Airplane plane : flightControl.getPlanes()){
            if(plane.getId().equals(ID)){
                return plane;
            }
        }
        return null;
    }

    public void startFlightControl(){
        label:
        while(true){
            System.out.println("Choose an action: ");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] quit");

            String userInput  = scanner.nextLine();

            switch (userInput) {
                case "x":
                    break label;
                case "1":
                    printAirplanes();
                    System.out.println("");
                    break;
                case "2":
                    printFlights();
                    System.out.println("");
                    break;
                case "3":
                    printAirplaneDetails();
                    System.out.println("");
                    break;
                default:
                    System.out.println("That option is not available");
            }
        }

    }

    private void printAirplanes(){
        flightControl.getPlanes().stream()
                .forEach(plane -> System.out.println(plane));
    }

    private void printFlights(){
        flightControl.getFlights().stream()
                .forEach(flight -> System.out.println(flight));
    }
    private void printAirplaneDetails(){
        System.out.println("Give the airplane ID: ");
        Airplane airplane = findPlane(scanner.nextLine());
        System.out.println(airplane);

    }

}
