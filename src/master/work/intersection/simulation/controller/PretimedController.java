package master.work.intersection.simulation.controller;

import master.work.intersection.simulation.detector.util.Distribution;
import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Intersection;
import master.work.intersection.simulation.statistics.Statistics;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class PretimedController extends Controller {


    public PretimedController(Intersection intersection, Distribution distribution, Statistics statistics) {
        super(intersection, distribution, statistics);
    }

    @Override
    protected void launch() {
        intersection.setLastVehicleRemoveTime(currentTime());
        while(isOn()){
            statistics.getNumberOfVehiclesOnEachPhase();
            while(currentTime() - intersection.getCurrentPhase().getPhaseTime() < PHASE_TIME){
                System.out.println("Here");
                simulateTraffic();
            }
            nextPhase();
            statistics.getNumberOfVehiclesOnEachPhase();
        }
    }

    protected void simulateTraffic(){
        intersection.simulateDistribution();
        if((currentTime() - intersection.getLastVehicleRemoveTime()) > 2000) {
            intersection.simulateVehicleMoveAway();
        }
    }

    private void nextPhase() {

        intersection.switchOnNextPhaseFromQueue();
    }
}
