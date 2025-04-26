# Airport Tower Simulator (Mediator Pattern)

A demonstration of the **Mediator** design pattern via an airport control tower coordinating aircraft landings and take‐offs on a single runway.

---

## Table of Contents

1. [Overview](#overview)  
2. [Project Structure](#project-structure)  

---

## Overview

In a busy airport, letting aircraft communicate directly leads to chaos. The **ControlTower** acts as a central mediator, receiving requests from various `Aircraft` subclasses (PassengerPlane, CargoPlane, Helicopter) and coordinating runway access. It manages separate queues for landing and take‐off, and implements an emergency protocol (MAYDAY) that bumps low‐fuel planes to the front.

---

## Project Structure

- **mediator/TowerMediator.java** – mediator interface.  
- **mediator/ControlTower.java** – concrete mediator with landing/take‐off queues and emergency handling.  
- **aircraft/Aircraft.java** – abstract colleague class.  
- **aircraft/PassengerPlane.java**, **CargoPlane.java**, **Helicopter.java** – concrete colleagues with custom `receive()` behavior.  
- **Main.java** – simulation driver demonstrating normal requests and an emergency (MAYDAY).
