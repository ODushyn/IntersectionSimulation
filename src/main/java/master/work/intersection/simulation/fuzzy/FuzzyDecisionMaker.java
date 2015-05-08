package master.work.intersection.simulation.fuzzy;

import master.work.intersection.simulation.util.Decision;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class FuzzyDecisionMaker {

    /**
     * Create the decision about the further phase
     * @return decision with current green phase, delay time of it and next green phase
     */
    public Decision getFinalDecision(int nextGreenPhase, int waitingVehiclesOfNextGreenPhase, int waitingVehiclesOfCurrentGreenPhase){
        Decision decision =  new Decision();
        decision.setNextGreenPhase(nextGreenPhase);

        return decision;
    }


}
