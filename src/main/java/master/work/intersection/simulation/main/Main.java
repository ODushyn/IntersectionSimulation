package master.work.intersection.simulation.main;

import master.work.intersection.simulation.controller.PretimedController;
import master.work.intersection.simulation.detector.util.PoissonDistribution;
import master.work.intersection.simulation.intersec.FourWayIntersection;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        //TODO: consider what parameters should be passed into Intersection
        Intersection intersection = new FourWayIntersection(new PoissonDistribution(), 4, 12);

        Controller controller = new PretimedController(intersection);

        controller.launch();

        /*PoissonDistribution p = new PoissonDistribution(0.1);
        for(int i=0; i<10; i++){
            System.out.println(p.probability(i));
        }
        System.out.println(p.getMean() + " " + p.getNumericalMean() + "" +  p.getNumericalVariance());
        System.out.println(p.getSupportLowerBound() + " " + p.getSupportUpperBound());
        while(true){
            System.out.println(p.sample());
        }*/

    }
}
