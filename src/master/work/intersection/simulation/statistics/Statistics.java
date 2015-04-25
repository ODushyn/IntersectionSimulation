package master.work.intersection.simulation.statistics;

import master.work.intersection.simulation.intersec.util.Direction;
import master.work.intersection.simulation.intersec.util.Phase;
import master.work.intersection.simulation.main.Intersection;

/**
 * Created by Oleksander.Dushyn on 4/25/2015.
 */
public class Statistics {

    private Intersection intersection;

    public Statistics(Intersection intersection) {
        this.intersection = intersection;
    }

    public void getNumberOfVehiclesOnEachPhase(){
        int currentPhaseNumber = intersection.getCurrentPhase().getPhaseName();
        outputPhaseInfo(intersection.getCurrentPhase());
        for(Phase phase : intersection.getPhases()){
            if(phase.getPhaseName() != currentPhaseNumber)
            outputPhaseInfo(phase);
        }
    }

    private void outputPhaseInfo(Phase phase){
        System.out.println();
        System.out.print(phase.getPhaseTime());
        System.out.println(" ");
        for(Direction direction : phase.getActiveDirections()){
            System.out.print(direction.getDirectionName());
            System.out.print(" ");
            System.out.print(direction.getNumberOfVehicles());
            System.out.print(" ");
            System.out.println(direction.getWaitingTime());
        }
        System.out.println();
    }
}
