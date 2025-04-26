package com.airport.aircraft;

import com.airport.mediator.TowerMediator;

public abstract class Aircraft {
    protected final String id;
    protected final boolean landing;
    protected final TowerMediator tower;

    public Aircraft(String id, boolean landing, TowerMediator tower) {
        this.id = id;
        this.landing = landing;
        this.tower = tower;
    }

    public String getId() {
        return id;
    }

    public boolean isLanding() {
        return landing;
    }

    public abstract void receive(String msg);

    public void send(String msg) {
        tower.broadcast(msg, this);
    }

    public void requestRunway() {
        tower.requestRunway(this);
    }
}