package master.work.intersection.simulation.fuzzy;

import master.work.intersection.simulation.intersec.util.Phase;

import java.util.List;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class FuzzyUrgencyEvaluator {

    //TODO: make checking about each phase only one time in a cycle

    /**
     * Calculates urgency and decide what phase is next
     * @return number of next phase
     */
    public Phase nextGreenPhase(List<UrgencyEvaluatorInput> input){
        //TODO: do logic here
        return new Phase(1);
    }


}
