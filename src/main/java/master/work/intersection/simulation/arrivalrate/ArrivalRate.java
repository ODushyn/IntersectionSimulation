package master.work.intersection.simulation.arrivalrate;

import master.work.intersection.simulation.detector.util.Distribution;
import master.work.intersection.simulation.detector.util.PoissonDistribute;
import master.work.intersection.simulation.intersec.util.Direction;
import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Timer;
import master.work.intersection.simulation.util.Constants;

import java.util.Random;

/**
 * Created by Oleksander.Dushyn on 5/18/2015.
 */
public class ArrivalRate extends Thread{

    protected Direction direction;
    protected Distribution distribution = new PoissonDistribute(Constants.DEFAULT_TRAFFIC_AR);

    public void control(Direction direction){
        this.direction = direction;
        this.start();
    }

    public double arrivedVehicles() {
        return distribution.arrivedVehicles();
    }

    protected void updateArrivalRate(double rate){
        System.out.println("Arrival rate of " + direction.getName() + " is updated to: " + rate);
        this.distribution.setArrivalRate(rate);
    }

    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

    public double getArrivalRate(){
        return distribution.getArrivalRate();
    }
}
