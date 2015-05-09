package master.work.intersection.simulation.main;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Detector {

    private Intersection intersection;


    public Detector(Intersection intersection) {
        this.intersection = intersection;
    }

    public int waitingVehiclesOfRedPhase() {
        return 0;
    }

    public int waitingVehiclesOfNextGreenPhase() {
        return 0;
    }

    public int waitingVehiclesOfCurrentGreenPhase() {
        return 0;
    }

}
