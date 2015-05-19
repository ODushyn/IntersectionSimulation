package master.work.intersection.simulation.detector.util;

import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.statistics.Statistics;
import master.work.intersection.simulation.util.Constants;
import org.apache.commons.math3.distribution.PoissonDistribution;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class PoissonDistribute extends Distribution{

    private PoissonDistribution distribution;

    public PoissonDistribute(double arrivalRate) {
        this.distribution = new PoissonDistribution(arrivalRate);
    }

    @Override
    protected int numberOfArrivedVehicles() {
        return distribution.sample();
    }

    @Override
    public void setArrivalRate(double rate) {
        this.distribution = new PoissonDistribution(rate);
    }

    @Override
    public double getArrivalRate() {
        return distribution.getMean();
    }

}
