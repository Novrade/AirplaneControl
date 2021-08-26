/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author nowakor
 */
public class FlightControl{
    private ArrayList<Airplane> planes;
    private  ArrayList<Flight> flights;
//    private ArrayList<Place> places;

    public FlightControl() {
        this.planes = new ArrayList<>();
        this.flights = new ArrayList<>();
    }

    public void addAirplane(String ID, int capacity){
        planes.add(new Airplane(ID, capacity));
    }

    public void addFlight(Airplane plane, String departure, String destination){
        flights.add(new Flight(plane,departure,destination));
    }

    public ArrayList<Airplane> getPlanes() {
        return planes;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

}
