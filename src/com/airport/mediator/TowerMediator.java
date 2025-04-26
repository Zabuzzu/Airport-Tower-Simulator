package com.airport.mediator;

import com.airport.aircraft.Aircraft;

public interface TowerMediator {
    void broadcast(String msg, Aircraft sender);
    boolean requestRunway(Aircraft a);
}