package master.work.intersection.simulation.main;

import master.work.intersection.simulation.controller.FuzzyUrgencyAndDelayController;
import master.work.intersection.simulation.controller.PretimedController;
import master.work.intersection.simulation.detector.util.PoissonDistribute;
import master.work.intersection.simulation.intersec.FourWayIntersection;
import org.apache.commons.math3.distribution.PoissonDistribution;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        //TODO: consider what parameters should be passed into Intersection
        Intersection intersection = new FourWayIntersection(new PoissonDistribute(), 4, 12);

        Controller fuzzyController = new FuzzyUrgencyAndDelayController(intersection);
        Controller pretimedController = new PretimedController(intersection);

        fuzzyController.launch();
        pretimedController.launch();

        //testDistribution();
    }

    private static void  testDistribution(){
        PoissonDistribution p = new PoissonDistribution(1);
        for(int i=0; i<10; i++){
            System.out.println(p.probability(i));
        }
        System.out.println(p.getMean() + " " + p.getNumericalMean() + "" +  p.getNumericalVariance());
        System.out.println(p.getSupportLowerBound() + " " + p.getSupportUpperBound());

        long lastDistributionTime = Timer.currentTime();
        List<Integer> list = new ArrayList();
        while(Controller.isOn()){
            if(Timer.repeat(Timer.currentTime(), lastDistributionTime, Controller.UNIT_OF_TIME)) {
                System.out.println(p.sample());
                list.add(p.sample());
                lastDistributionTime = Timer.currentTime();
            }
        }
        int sum = 0;
        for(Integer sample : list){
            sum+=sample;
        }

        System.out.println(sum + " " + list.size());
    }
}
