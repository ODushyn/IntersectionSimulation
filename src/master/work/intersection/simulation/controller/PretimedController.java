package master.work.intersection.simulation.controller;

import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Intersection;
import master.work.intersection.simulation.statistics.Statistics;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class PretimedController extends Controller {


    public PretimedController(Intersection intersection, Statistics statistics) {
        super(intersection, statistics);
    }

    @Override
    protected void launch() {
        intersection.setLastVehicleRemoveTime(currentTime());
        intersection.setLastDistributionTime(currentTime());
        statistics.activePhaseStatistics();
        while(isOn()){
            while(intersection.greenPhaseTime() < PHASE_TIME){
                simulateTraffic();
            }
            statistics.allPhasesStatistics();
            nextPhase();
            statistics.activePhaseStatistics();
        }
    }

    protected void simulateTraffic(){
        intersection.simulateDistribution(4000);
        if((currentTime() - intersection.getLastVehicleRemoveTime()) > 1000) {
            intersection.simulateVehicleMoveAway();
        }
    }

    private void nextPhase() {

        intersection.switchOnNextPhaseFromQueue();
    }

}
