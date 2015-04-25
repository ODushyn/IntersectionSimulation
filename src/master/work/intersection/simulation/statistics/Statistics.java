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

    public void activePhaseStatistics(){
        outputPhaseInfo(intersection.getCurrentPhase());
    }

    public void allPhasesStatistics(){
        for(Phase phase : intersection.getPhases()){
            outputPhaseInfo(phase);
        }
    }

    private void outputPhaseInfo(Phase phase){
        System.out.println("Phase: " + phase.getName());
        System.out.print("Red time: " + phase.redWaitingTime());
        System.out.print(" ");
        System.out.print("Green time: " + phase.greenWaitingTime());
        System.out.println(" ");
        for(Direction direction : phase.getActiveDirections()){
            System.out.print("Direction: " + direction.getName());
            System.out.print(" ");
            System.out.print("Vehicles: " + direction.getNumberOfVehicles());
            System.out.print(" ");
            System.out.println("Waiting time:" + direction.getRedWaitingTime());
        }
        System.out.println();
    }
}
