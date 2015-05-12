package master.work.intersection.simulation.detector.util;

import master.work.intersection.simulation.main.Controller;
import org.apache.commons.math3.distribution.PoissonDistribution;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class PoissonDistribute extends Distribution{

    private PoissonDistribution distribution = new PoissonDistribution(Controller.VEHICLE_ARRIVAL_RATE);

    @Override
    protected int numberOfArrivedVehicles() {
        return distribution.sample();
    }
}
