package master.work.intersection.simulation.statistics;

import master.work.intersection.simulation.intersec.util.Direction;
import master.work.intersection.simulation.intersec.util.Phase;
import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Intersection;
import master.work.intersection.simulation.main.Timer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Oleksander.Dushyn on 4/25/2015.
 */
public class Statistics {

    private Intersection intersection;
    private List<Parameters> params;
    private String name;
    private long startTime;
    private int totalWaitingVehiclesForPhase;
    private int totalNumberOfPhases;
    private int totalVehiclesDelayForAllPhases;

    public Statistics(Controller controller) {
        this.intersection = controller.getIntersection();
        this.startTime = controller.getStartTime();
        this.name = controller.getName();
        this.params = new ArrayList<Parameters>();
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
        params.add(new Parameters((Timer.currentTime() - startTime), totalWaitingVehiclesForPhase, totalNumberOfPhases));
        this.totalWaitingVehiclesForPhase = 0;
        //print2();
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
        System.out.println("============================================");
    }

    public void print2(){
        /*System.out.println("Total number of phases: " + totalNumberOfPhases);
        System.out.println("Total time: " + (Timer.currentTime() - Controller.START_TIME)/1000);
        System.out.println("Waiting vehicles on intersection: " + totalWaitingVehiclesForPhase);
        System.out.println("Average waiting vehicles on intersection: " + averageVehicleDelay());*/
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
            pw = new PrintWriter(new File(name + " " + Calendar.getInstance().getTime().getTime()/100000 +  ".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Parameters p : params) {
            pw.println(p);
        }
        pw.close();
    }

    class Parameters{
        long time;
        int vehicles;
        int phase;
        int averageVehicles;

        public Parameters(long time, int vehicles, int phase) {
            this.time = time/60000;
            this.vehicles = vehicles;
            this.phase = phase;
            this.averageVehicles = vehicles/phase;
        }

        public String toString() {
            return phase + "\t" + vehicles + "\t"
                    + time + "\t" + averageVehicles;
        }
    }

}

