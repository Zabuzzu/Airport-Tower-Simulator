package com.airport.aircraft;

public class Helicopter extends Aircraft {
    public Helicopter(String id, boolean landing, com.airport.mediator.TowerMediator tower) {
        super(id, landing, tower);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[Heli " + id + "] " + msg);
    }
}