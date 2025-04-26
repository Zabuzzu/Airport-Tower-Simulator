package com.airport.aircraft;

import com.airport.mediator.TowerMediator;

public class PassengerPlane extends Aircraft {
    public PassengerPlane(String id, boolean landing, TowerMediator tower) {
        super(id, landing, tower);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[Passenger " + id + "] " + msg);
    }
}