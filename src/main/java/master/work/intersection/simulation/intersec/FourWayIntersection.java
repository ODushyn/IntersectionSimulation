package master.work.intersection.simulation.intersec;

import master.work.intersection.simulation.arrivalrate.FloatArrivalRate;
import master.work.intersection.simulation.detector.util.Distribution;
import master.work.intersection.simulation.intersec.util.Direction;
import master.work.intersection.simulation.intersec.util.Phase;
import master.work.intersection.simulation.main.Intersection;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class FourWayIntersection extends Intersection {

    
    public FourWayIntersection(String name, int phases, int directions) {
        super(name, phases, directions);
    }

    @Override
    protected void init() {
                
        phases[0].setDirections(getDirection(3), getDirection(4), getDirection(9), getDirection(10));

        phases[1].setDirections(getDirection(5), getDirection(11));

        phases[2].setDirections(getDirection(6), getDirection(7), getDirection(0), getDirection(1));

        phases[3].setDirections(getDirection(2), getDirection(8));

        setCurrentPhase(phases[0]);
    }

}
