package master.work.intersection.simulation.intersec;

import master.work.intersection.simulation.detector.util.Distribution;
import master.work.intersection.simulation.main.Intersection;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class FourWayIntersection extends Intersection {


    public FourWayIntersection(Distribution distribution, int phases, int directions) {
        super(distribution, phases, directions);
    }

    @Override
    protected void init() {
        getPhases()[0].setDirections(getDirection(3), getDirection(4), getDirection(9), getDirection(10));

        getPhases()[1].setDirections(getDirection(5), getDirection(11));

        getPhases()[2].setDirections(getDirection(6), getDirection(7), getDirection(0), getDirection(1));

        getPhases()[3].setDirections(getDirection(2), getDirection(8));

        setCurrentPhase(getPhases()[0]);

    }


}
