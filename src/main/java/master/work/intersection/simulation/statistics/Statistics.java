package master.work.intersection.simulation.statistics;

import master.work.intersection.simulation.intersec.util.Direction;
import master.work.intersection.simulation.intersec.util.Phase;
import master.work.intersection.simulation.main.Intersection;

/**
 * Created by Oleksander.Dushyn on 4/25/2015.
 */
public class Statistics {

    private Intersection intersection;
    private int totalWaitingVehiclesForPhase;
    private int totalNumberOfPhases;
    private int totalVehiclesDelayForAllPhases;

    public Statistics(Intersection intersection) {
        this.intersection = intersection;
        this.totalWaitingVehiclesForPhase = 0;
        this.totalNumberOfPhases = 0;
        this.totalVehiclesDelayForAllPhases = 0;
    }

    public void update(){
        this.totalNumberOfPhases += 1;
        for(Phase phase : intersection.getPhases()){
            totalWaitingVehiclesForPhase += phase.waitingVehicles();
        }
        this.totalVehiclesDelayForAllPhases += totalWaitingVehiclesForPhase;
        print();
        totalWaitingVehiclesForPhase = 0;
    }

    public double averageVehicleDelayRatio(){
        return (double) totalVehiclesDelayForAllPhases /intersection.distribution.getTotalNumberOfArrivedVehicles();
    }

    public double averageVehicleDelay(){
        return (double) totalVehiclesDelayForAllPhases /totalNumberOfPhases;
    }

    public void print(){
        System.out.println("==============STATISCTICS===================");
        System.out.println("Total number of phases: " + totalNumberOfPhases);
        System.out.println("Waiting vehicles on intersection: " + totalWaitingVehiclesForPhase);
        System.out.println("Average waiting vehicles on intersection: " + averageVehicleDelay());
        System.out.println("Average delay ratio: " + averageVehicleDelayRatio());
        System.out.println("Total arrived vehicles: " + intersection.distribution.getTotalNumberOfArrivedVehicles());
        System.out.println("============================================");
    }


    private double vehiclesDelayInRedPhases(){
        double total = 0;
        for(Phase phase : intersection.redPhases()){
            total += phase.waitingVehicles();
        }
        return total;
    }

    private double vehiclesDelayInGreenPhase(){
        return intersection.getCurrentPhase().waitingVehicles();
    }

    public void activePhaseStatistics(){
        outputPhaseInfo(intersection.getCurrentPhase());
    }

    public void allPhasesStatistics(){
        System.out.println("=================================");
        System.out.println("=============ACTIVE=============");
        outputPhaseInfo(intersection.getCurrentPhase());
        System.out.println("=============------=============");
        for(Phase phase : intersection.getPhases()){
            if(phase != intersection.getCurrentPhase())
                outputPhaseInfo(phase);
        }
        System.out.println("=================================");
    }

    private void outputPhaseInfo(Phase phase){
        System.out.println("Phase: " + phase.getNumber());
        System.out.println("Urgency: " + phase.getUrgency());
        System.out.print("Red time: " + phase.redWaitingTime());
        System.out.print(" ");
        System.out.print("Green time: " + phase.greenWaitingTime());
        System.out.print(" ");
        System.out.println("Vehicles:" + phase.waitingVehicles());
        for(Direction direction : phase.getDirections()){
            System.out.print("Direction: " + direction.getName());
            System.out.print(" ");
            System.out.print("Vehicles: " + direction.getQueue());
            System.out.print(" ");
            System.out.println("Waiting time:" + direction.getRedWaitingTime());
        }
        System.out.println();
    }
}
