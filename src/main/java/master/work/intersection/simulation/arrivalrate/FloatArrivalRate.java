package master.work.intersection.simulation.arrivalrate;

import master.work.intersection.simulation.intersec.util.Direction;
import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.util.Constants;

import java.util.Random;

/**
 * Created by Oleksander.Dushyn on 5/19/2015.
 */
public class FloatArrivalRate extends ArrivalRate {

    private double bottomArrivalRate;
    private double topArrivalRate;
    private long intervalChangeTime;

    public FloatArrivalRate(double bottomArrivalRate, double topArrivalRate, long intervalChangeTime){
        this.bottomArrivalRate = bottomArrivalRate;
        this.topArrivalRate = topArrivalRate;
        this.intervalChangeTime = intervalChangeTime;
    }

    /**
     * Returns FloarArrivalRate with average bottomArrivalRate, topArrivalRate
     * and default intervalChangeTime
     */
    public FloatArrivalRate(){
        this.bottomArrivalRate = Constants.DEFAULT_MID_TRAFFIC_BOTTOM_AR;
        this.topArrivalRate = Constants.DEFAULT_MID_TRAFFIC_TOP_AR;
        this.intervalChangeTime = Constants.DEFAULT_ARRIVALRATE_CHANGE_TIME;
    }

    @Override
    public synchronized void run(){
        while(Controller.isOn()) {
            try {
                updateArrivalRate();
                this.wait(intervalChangeTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateArrivalRate(){
        Random r = new Random();
        updateArrivalRate(bottomArrivalRate + (topArrivalRate - bottomArrivalRate) * r.nextDouble());
    }


    public FloatArrivalRate lowTrafficRate(){
        this.bottomArrivalRate = Constants.DEFAULT_LOW_TRAFFIC_BOTTOM_AR;
        this.topArrivalRate = Constants.DEFAULT_LOW_TRAFFIC_TOP_AR;
        this.intervalChangeTime = Constants.DEFAULT_ARRIVALRATE_CHANGE_TIME;
        return this;
    }

    public FloatArrivalRate middleTrafficRate(){
        this.bottomArrivalRate = Constants.DEFAULT_MID_TRAFFIC_BOTTOM_AR;
        this.topArrivalRate = Constants.DEFAULT_MID_TRAFFIC_TOP_AR;
        this.intervalChangeTime = Constants.DEFAULT_ARRIVALRATE_CHANGE_TIME;
        return this;
    }

    public FloatArrivalRate highTrafficRate(){
        this.bottomArrivalRate = Constants.DEFAULT_HIGH_TRAFFIC_BOTTOM_AR;
        this.topArrivalRate = Constants.DEFAULT_HIGH_TRAFFIC_TOP_AR;
        this.intervalChangeTime = Constants.DEFAULT_ARRIVALRATE_CHANGE_TIME;
        return this;
    }

    public FloatArrivalRate trafficRate(){
        this.bottomArrivalRate = 0.05;
        this.topArrivalRate = Constants.DEFAULT_HIGH_TRAFFIC_TOP_AR;
        this.intervalChangeTime = Constants.DEFAULT_ARRIVALRATE_CHANGE_TIME;
        return this;
    }


}
