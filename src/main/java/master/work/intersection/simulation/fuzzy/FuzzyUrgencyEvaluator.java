package master.work.intersection.simulation.fuzzy;

import master.work.intersection.simulation.intersec.util.Phase;

import java.util.List;
import java.util.Stack;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class FuzzyUrgencyEvaluator {


    private int numberOfPhases;
    private Stack phaseCycle = new Stack();

    public FuzzyUrgencyEvaluator(int numberOfPhases) {
        this.numberOfPhases = numberOfPhases;
    }

    /**
     * Calculates urgency and decide what phase is next
     * @return number of next phase
     */
    public Phase nextGreenPhase(List<UrgencyEvaluatorInput> input, Phase currentPhase){
        //TODO: make checking about each phase only one time in a cycle
        return new Phase(1);
    }

    public boolean checkPhaseAccordingToCycle(Phase phase){
        if(phaseCycle.search(phase) != -1){
            phaseCycle.push(phase);
            if(phaseCycle.size() == numberOfPhases){
                phaseCycle.clear();
            }
            return true;
        }
        return false;
    }
}
