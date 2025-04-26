package com.airport.aircraft;

public class CargoPlane extends Aircraft {
    public CargoPlane(String id, boolean landing, com.airport.mediator.TowerMediator tower) {
        super(id, landing, tower);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[Cargo " + id + "] " + msg);
    }
}