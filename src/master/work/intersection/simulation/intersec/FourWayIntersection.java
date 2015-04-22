package master.work.intersection.simulation.intersec;

import master.work.intersection.simulation.intersec.util.Direction;
import master.work.intersection.simulation.intersec.util.Phase;
import master.work.intersection.simulation.main.Intersection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class FourWayIntersection extends Intersection {


    public FourWayIntersection(int phases, int directions) {
        super(phases, directions);
    }

    @Override
    protected void init() {
        getPhases()[0].setActiveDirections(getDirection(3), getDirection(4), getDirection(9), getDirection(10));
        getPhases()[0].setOrderNumber(1);

        getPhases()[1].setActiveDirections(getDirection(5), getDirection(11));
        getPhases()[1].setOrderNumber(1);

        getPhases()[2].setActiveDirections(getDirection(6), getDirection(7), getDirection(0), getDirection(1));
        getPhases()[2].setOrderNumber(2);

        getPhases()[3].setActiveDirections(getDirection(2), getDirection(8));
        getPhases()[3].setOrderNumber(4);

        setCurrentPhase(getPhases()[0]);

    }


}
