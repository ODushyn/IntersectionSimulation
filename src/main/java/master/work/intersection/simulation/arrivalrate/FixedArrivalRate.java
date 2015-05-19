package master.work.intersection.simulation.arrivalrate;

import master.work.intersection.simulation.intersec.util.Direction;

/**
 * Created by Oleksander.Dushyn on 5/19/2015.
 */
public class FixedArrivalRate extends ArrivalRate{

    private double arrivalRate;

    public FixedArrivalRate(Direction direction, double arrivalRate) {
        this.direction = direction;
        this.arrivalRate = arrivalRate;
    }

    @Override
    public void run(){
        updateArrivalRate(arrivalRate);
    }
}
