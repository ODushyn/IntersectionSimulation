package master.work.intersection.simulation.controller;

import master.work.intersection.simulation.main.Controller;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class PretimedController extends Controller {

    @Override
    protected void launch() {
        while(isOn()){
            while(currentTime() - intersection.getCurrentPhase().getPhaseTime() < PHASE_TIME){
                simulateTraffic();
            }

            nextPhase();

        }
    }

    protected void simulateTraffic(){

    }

    private void nextPhase() {
        intersection.switchOnNextPhaseFromQueue();
    }
}
