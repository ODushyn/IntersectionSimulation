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
        Intersection intersection = new FourWayIntersection(4, 12);

        List<Controller> controllers = new ArrayList<Controller>();

        controllers.add(new PretimedController(intersection));
        //controllers.add(new FuzzyUrgencyAndDelayController(intersection));

        for(Controller contr: controllers){
            try {
                contr.launch();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

/*        try {
            testDistribution();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    private static void  testDistribution() throws InterruptedException {
        PoissonDistribution p = new PoissonDistribution(0.13);
        for(int i=0; i<10; i++){
            System.out.println(p.probability(i));
        }
        System.out.println(p.getMean() + " " + p.getNumericalMean() + "" +  p.getNumericalVariance());
        System.out.println(p.getSupportLowerBound() + " " + p.getSupportUpperBound());

        long lastDistributionTime = Timer.currentTime();
        List<Integer> list = new ArrayList();
        long start = Timer.currentTime();
        long duration = 3600000;
        while(Timer.currentTime() - start <  duration){

                System.out.println(p.sample());
                list.add(p.sample());
                lastDistributionTime = Timer.currentTime();

        }
        int sum = 0;
        for(Integer sample : list){
            sum+=sample;
        }

        System.out.println(sum + " " + list.size());
    }
}
