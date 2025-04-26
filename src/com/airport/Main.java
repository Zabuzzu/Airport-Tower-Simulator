package com.airport;

import com.airport.mediator.ControlTower;
import com.airport.aircraft.*;
import com.airport.mediator.TowerMediator;

public class Main {
    public static void main(String[] args) {
        TowerMediator tower = new ControlTower();

        Aircraft p1 = new PassengerPlane("P1", true, tower);
        Aircraft c1 = new CargoPlane("C1", false, tower);
        Aircraft h1 = new Helicopter("H1", true, tower);

        p1.requestRunway();
        c1.requestRunway();
        h1.requestRunway();

        // Simulate emergency
        h1.send("MAYDAY");
    }
}