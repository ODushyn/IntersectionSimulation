package master.work.intersection.simulation.statistics;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.ChartBuilder;
import com.xeiam.xchart.StyleManager;
import com.xeiam.xchart.SwingWrapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksander.Dushyn on 5/24/2015.
 */
public class PlotStatisctics {

    //TODO: test method. remove after GUI implemented
    public static void numOfVehiclesAndTime(String... files) throws IOException {
        Chart chart = new ChartBuilder().chartType(StyleManager.ChartType.Line).width(800).height(600).title("AreaChart01").xAxisTitle("X").yAxisTitle("Y").build();
        for(String file : files) {
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String line;
            List<Double> timeList = new ArrayList();
            List<Double> numOfVehiclesList = new ArrayList();
            while ((line = br.readLine()) != null){
                if(line.equals("Phase\tVehicles\tTime\tAverageVehiclesDelay")){
                    while ((line = br.readLine()) != null){
                        String s[] = line.split("\t");
                        timeList.add(Double.valueOf(s[0]) * 5);
                        numOfVehiclesList.add(Double.valueOf(s[1]));
                    }
                }
            }
            double time[] = new double[timeList.size()];
            for(int i=0; i < timeList.size(); i++){
                time[i] = timeList.get(i);
            }
            double numOfVehicles[] = new double[numOfVehiclesList.size()];
                for(int i=0; i < numOfVehiclesList.size(); i++){
                    numOfVehicles[i] = numOfVehiclesList.get(i);
                }
            chart.addSeries("a", time , numOfVehicles);
            br.close();

            new SwingWrapper(chart).displayChart();
        }
    }

    //TODO: test method. remove after GUI implemented
    public static void averageVehiclesDelay(String... files){

    }

    private void plotLineChart(){
        Chart chart = new ChartBuilder().chartType(StyleManager.ChartType.Line).width(800).height(600).title("AreaChart01").xAxisTitle("X").yAxisTitle("Y").build();
        chart.addSeries("a", new double[] { 0, 3, 5, 7, 9 }, new double[] { -3, 5, 9, 6, 5 });
        chart.addSeries("b", new double[] { 0, 2, 4, 6, 9 }, new double[] { -1, 6, 4, 0, 4 });
        chart.addSeries("c", new double[] { 0, 1, 3, 8, 9 }, new double[] { -2, -1, 1, 0, 1 });
    }

    private void plotBarChart(){

    }
}
