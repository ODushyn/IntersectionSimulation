package master.work.intersection.simulation.statistics;

import master.work.intersection.simulation.intersec.util.Direction;
import master.work.intersection.simulation.intersec.util.Phase;
import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Intersection;
import master.work.intersection.simulation.main.Timer;
import master.work.intersection.simulation.util.Constants;

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
    private Controller controller;
    private String controllerName;
    //private long startTime;
    private int totalWaitingVehiclesForPhase;
    private int totalNumberOfPhases;
    private int totalVehiclesDelayForAllPhases;

    public Statistics(Controller controller) {
        this.controller = controller;
        this.intersection = controller.getIntersection();
        //this.startTime = controller.getStartTime();
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
        phasesInfo.add(new Parameters((Timer.currentTime() - controller.getStartTime()), totalWaitingVehiclesForPhase, totalNumberOfPhases, averageVehicleDelay()));
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
        System.out.println("Total time: " + (Timer.currentTime() - controller.getStartTime())/1000);
        System.out.println("Waiting vehicles on intersection: " + totalWaitingVehiclesForPhase);
        System.out.println("Average waiting vehicles on intersection: " + averageVehicleDelay());
        System.out.println("========================================================================================");
    }

    public double printAverageTimeDelay(){
        double totalAverageWaiting = 0;
        for(Phase p : intersection.getPhases()){
            for(Direction d: p.getDirections()){
                System.out.println("Direction: " + d.getName() + ". Average time: " + d.getAverageTimeVehicleDelay());
                totalAverageWaiting += d.getAverageTimeVehicleDelay();
            }
        }
        System.out.println("Average total time waiting: " + totalAverageWaiting/12);
        return totalAverageWaiting/12;
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

    public void  saveToFile(String fileName){
        String file = fileName(controllerName);
        if(fileName != null){
            file = fileName;
        }
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.println(controllerName + ". " + intersection.getName() + ".");
        pw.println("Average total time waiting: " + printAverageTimeDelay());
        pw.println("Total number of phases: " + totalNumberOfPhases);
        pw.println("Total time: " + (Timer.currentTime() - controller.getStartTime())/1000);
        if(phasesInfo.size() !=0)
        pw.println("Waiting vehicles for the last phase: " + phasesInfo.get(phasesInfo.size()).vehicles);
        pw.println("Average waiting vehicles for the last phase : " + String.format("%.2f", averageVehicleDelay()));
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

    private String  fileName(String controllerName){
        String name = "";
        if("Fuzzy Urgency And Delay".equals(controllerName)){
            name = "FU";
        }
        if("Fuzzy Delay".equals(controllerName)){
            name = "FD";
        }
        if("Pretimed".equals(controllerName)){
            name = "Pr";
        }
        name +="_" + intersection.getName().charAt(0);
        name +="_" + Constants.DEFAULT_PHASE_TIME;
        name += " " + Calendar.getInstance().getTime().getTime()/1000000;
        name += ".txt";

        return name;
    }

    class Parameters{
        long time;
        int vehicles;
        int phase;
        double averageVehiclesDelay;

        public Parameters(long time, int vehicles, int phase, double averageVehicleDelay) {
            this.time = time/1000;
            this.vehicles = vehicles;
            this.phase = phase;
            this.averageVehiclesDelay = averageVehicleDelay;
        }

        public String toString() {
            return phase + "\t" + vehicles + "\t"
                    + time + "\t" + String.format("%.2f",averageVehiclesDelay);
        }
    }

}

