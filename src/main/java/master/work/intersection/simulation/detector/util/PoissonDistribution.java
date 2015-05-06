package master.work.intersection.simulation.detector.util;

import master.work.intersection.simulation.main.Controller;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class PoissonDistribution extends Distribution{

    private org.apache.commons.math3.distribution.PoissonDistribution distribution
            = new org.apache.commons.math3.distribution.PoissonDistribution(Controller.VEHICLE_ARRIVAL_RATE);

    @Override
    public int getNumberOfArrivedVehicles() {
        return distribution.sample();
    }
}
