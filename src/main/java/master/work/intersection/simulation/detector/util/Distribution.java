package master.work.intersection.simulation.detector.util;

import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.util.Constants;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public abstract class Distribution {

    private int totalNumberOfArrivedVehicles = 0;

    public abstract void setArrivalRate(double rate);

    public abstract double getArrivalRate();

    public int arrivedVehicles(){
        int vehicles = numberOfArrivedVehicles();
        totalNumberOfArrivedVehicles += vehicles;
        return vehicles;
    }

    protected abstract int numberOfArrivedVehicles();

    public int getTotalNumberOfArrivedVehicles() {
        return totalNumberOfArrivedVehicles;
    }

}
