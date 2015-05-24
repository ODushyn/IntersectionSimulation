package master.work.intersection.simulation.detector.util;

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
