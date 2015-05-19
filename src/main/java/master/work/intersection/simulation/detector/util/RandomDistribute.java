package master.work.intersection.simulation.detector.util;

import java.util.Random;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class RandomDistribute extends Distribution{

    private Random rand = new Random();
    private double VEHICLES = 2;

    public RandomDistribute(double arrivalRate) {
        this.VEHICLES = arrivalRate;
    }

    @Override
    protected int numberOfArrivedVehicles() {
        return rand.nextInt((int)VEHICLES);
    }

    @Override
    public void setArrivalRate(double rate) {
        this.VEHICLES = rate;
    }

    @Override
    public double getArrivalRate() {
        return VEHICLES;
    }
}
