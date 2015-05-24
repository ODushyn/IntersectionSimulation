package master.work.intersection.simulation.statistics;

import master.work.intersection.simulation.intersec.util.Direction;
import master.work.intersection.simulation.intersec.util.Phase;
import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Intersection;
import master.work.intersection.simulation.main.Timer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Oleksander.Dushyn on 4/25/2015.
 */
public class Statistics {

    private Intersection intersection;
    private List<Parameters> phasesInfo;
    private String controllerName;
    private long startTime;
    private int totalWaitingVehiclesForPhase;
    private int totalNumberOfPhases;
    private int totalVehiclesDelayForAllPhases;

    public Statistics(Controller controller) {
        this.intersection = controller.getIntersection();
        this.startTime = controller.getStartTime();
        this.controllerName = controller.getName();
        this.phasesInfo = new ArrayList<Parameters>();
        this.totalWaitingVehiclesForPhase = 0;
        this.totalNumberOfPhases = 0;
        this.totalVehiclesDelayForAllPhases = 0;
    }

    public void update(){
        this.totalNumberOfPhases += 1;
        for(Phase phase : intersection.getPhases()){
            totalWaitingVehiclesForPhase += phase.totalWaitingVehicles();
        }
        this.totalVehiclesDelayForAllPhases += totalWaitingVehiclesForPhase;
        phasesInfo.add(new Parameters((Timer.currentTime() - startTime), totalWaitingVehiclesForPhase, totalNumberOfPhases, averageVehicleDelay()));
        print2();
        this.totalWaitingVehiclesForPhase = 0;

    }

    public double averageVehicleDelay(){
        return (double) totalVehiclesDelayForAllPhases /totalNumberOfPhases;
    }

    public void print1(){
        System.out.println("==============STATISCTICS===================");
        System.out.println("Total number of phases: " + totalNumberOfPhases);
        System.out.println("Total waiting vehicles for all phases:" + totalVehiclesDelayForAllPhases);
        System.out.println("Waiting vehicles on intersection: " + totalWaitingVehiclesForPhase);
        System.out.println("Average waiting vehicles on intersection: " + averageVehicleDelay());
        //System.out.println("Average delay ratio: " + averageVehicleDelayRatio());
        //System.out.println("Total arrived vehicles: " + intersection.getDistribution().getTotalNumberOfArrivedVehicles());
        System.out.println("========================================================================================");
    }

    public void print2(){
        System.out.println("Total number of phases: " + totalNumberOfPhases);
        System.out.println("Total time: " + (Timer.currentTime() - startTime)/1000);
        System.out.println("Waiting vehicles on intersection: " + totalWaitingVehiclesForPhase);
        System.out.println("Average waiting vehicles on intersection: " + averageVehicleDelay());
        System.out.println("========================================================================================");
    }

    private double vehiclesDelayInRedPhases(){
        double total = 0;
        for(Phase phase : intersection.redPhases()){
            total += phase.totalWaitingVehicles();
        }
        return total;
    }

    private double vehiclesDelayInGreenPhase(){
        return intersection.getCurrentPhase().totalWaitingVehicles();
    }

    public void activePhaseStatistics(){
        outputPhaseInfo(intersection.getCurrentPhase());
    }

    private void outputPhaseInfo(Phase phase){
        System.out.println("Phase: " + phase.getNumber());
        System.out.println("Urgency: " + phase.getUrgency());
        System.out.print("Red time: " + phase.redWaitingTime());
        System.out.print(" ");
        System.out.print("Green time: " + phase.greenWaitingTime());
        System.out.print(" ");
        System.out.println("Vehicles:" + phase.totalWaitingVehicles());
        for(Direction direction : phase.getDirections()){
            System.out.print("Direction: " + direction.getName());
            System.out.print(" ");
            System.out.print("Vehicles: " + direction.getQueue());
            System.out.println("");
        }
        System.out.println();
    }

    public void  saveToFile(){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File(controllerName + " " + Calendar.getInstance().getTime().getTime()/1000000 +  ".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.println(controllerName + ". " + intersection.getName() + ".");
        pw.println("Total number of phases: " + totalNumberOfPhases);
        pw.println("Total time: " + (Timer.currentTime() - startTime)/1000);
        pw.println("Waiting vehicles for the last phase: " + phasesInfo.get(phasesInfo.size() - 1).vehicles);
        pw.println("Average waiting vehicles for the last phase : " + averageVehicleDelay());
        pw.println();
        pw.println("Phase\t" + "Vehicles\t" + "Time\t" + "AverageVehiclesDelay");
        for (Parameters p : phasesInfo) {
            pw.println(p);
        }
        pw.close();
    }

    public List<Parameters> getPhasesInfo() {
        return phasesInfo;
    }

    class Parameters{
        long time;
        int vehicles;
        int phase;
        double averageVehiclesDelay;

        public Parameters(long time, int vehicles, int phase, double averageVehicleDelay) {
            this.time = time/60000;
            this.vehicles = vehicles;
            this.phase = phase;
            this.averageVehiclesDelay = averageVehicleDelay;
        }

        public String toString() {
            return phase + "\t" + vehicles + "\t"
                    + time + "\t" + averageVehiclesDelay;
        }
    }

}

