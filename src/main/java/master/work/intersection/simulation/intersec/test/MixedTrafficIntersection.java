package master.work.intersection.simulation.intersec.test;

import master.work.intersection.simulation.arrivalrate.FloatArrivalRate;
import master.work.intersection.simulation.intersec.util.Direction;
import master.work.intersection.simulation.intersec.util.Phase;
import master.work.intersection.simulation.main.Intersection;

/**
 * Created by Oleksander.Dushyn on 5/27/2015.
 */
public class MixedTrafficIntersection extends Intersection {

    public MixedTrafficIntersection(String name, int phases, int directions) {
        super(name, phases, directions);
    }

    @Override
    protected void init() {

        phases[0].setDirections(getDirection(3), getDirection(4), getDirection(9), getDirection(10));
        setFloatArrivalRateForPhase(phases[0]);

        phases[1].setDirections(getDirection(5), getDirection(11));
        setFloatArrivalRateForPhase(phases[1]);

        phases[2].setDirections(getDirection(6), getDirection(7), getDirection(0), getDirection(1));
        setFloatArrivalRateForPhase(phases[2]);

        phases[3].setDirections(getDirection(2), getDirection(8));
        setFloatArrivalRateForPhase(phases[3]);

        setCurrentPhase(phases[0]);
    }

    private void setFloatArrivalRateForPhase(Phase phase){
        for(Direction d : phase.getDirections()){
            d.setArrivalRate(new FloatArrivalRate().trafficRate());
        }
    }
}
