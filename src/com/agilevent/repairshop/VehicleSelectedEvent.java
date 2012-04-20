package com.agilevent.repairshop;

public class VehicleSelectedEvent {
    protected String vehicle;

    public VehicleSelectedEvent(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicle() {
        return vehicle;
    }
}
