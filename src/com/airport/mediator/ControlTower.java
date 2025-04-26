package com.airport.mediator;

import com.airport.aircraft.Aircraft;
import java.util.*;

public class ControlTower implements TowerMediator {
    private final Queue<Aircraft> landingQueue = new LinkedList<>();
    private final Queue<Aircraft> takeoffQueue = new LinkedList<>();

    @Override
    public synchronized void broadcast(String msg, Aircraft sender) {
        if ("MAYDAY".equals(msg)) {
            System.out.println("[Tower] EMERGENCY from " + sender.getId());
            landingQueue.remove(sender);
            landingQueue.add(sender); // jump to front
            for (Aircraft a : getAll()) {
                if (!a.equals(sender)) a.receive("Hold position");
            }
            sender.receive("Cleared to land NOW");
        } else {
            for (Aircraft a : getAll()) {
                if (!a.equals(sender)) a.receive(msg);
            }
        }
    }

    @Override
    public synchronized boolean requestRunway(Aircraft a) {
        if (a.isLanding()) {
            landingQueue.add(a);
            if (landingQueue.peek().equals(a)) {
                System.out.println("[Tower] " + a.getId() + " cleared to land.");
                landingQueue.poll();
                return true;
            }
        } else {
            takeoffQueue.add(a);
            if (takeoffQueue.peek().equals(a)) {
                System.out.println("[Tower] " + a.getId() + " cleared to take off.");
                takeoffQueue.poll();
                return true;
            }
        }
        return false;
    }

    private List<Aircraft> getAll() {
        List<Aircraft> all = new ArrayList<>();
        all.addAll(landingQueue);
        all.addAll(takeoffQueue);
        return all;
    }
}