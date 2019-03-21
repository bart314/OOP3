package chart;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ChartDemo extends Application {
    static XYChart.Series data1;
    static XYChart.Series data2;

    @Override
    public void start(Stage mainStage) {
        NumberAxis xAs = new NumberAxis(2000, 2008,1);
        NumberAxis yAs_verdrinken = new NumberAxis(80,140,20);
        NumberAxis yAs_Cage = new NumberAxis(0,6,1);
        xAs.setLabel("Jaren");
        yAs_verdrinken.setLabel("Aantal scholen");
        LineChart lineChart_1 = new LineChart(xAs, yAs_verdrinken);
        LineChart lineChart_2 = new LineChart(xAs, yAs_Cage);

        data1 = new XYChart.Series();
        data1.setName("Verdrinkingen per jaar");
        lineChart_1.getData().add(data1);

        data2 = new XYChart.Series();
        data2.setName("Aantal films waarin Nicholas Cage speelt");
        lineChart_2.getData().add(data2);

        Group root = new Group(lineChart_1, lineChart_2);
        Scene scene = new Scene(root, 800, 600);
        mainStage.setScene(scene);
        mainStage.show();

        Thread t1 = new Thread(new DataClass());
        t1.start();
    }

    class DataClass implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                Platform.runLater( () -> {
                            chart.ChartDemo1.data1.getData().add(new XYChart.Data(2000, 120));
                            chart.ChartDemo1.data2.getData().add(new XYChart.Data(2000, 2));
                        } );

                Thread.sleep(500);
                Platform.runLater( () -> {
                    chart.ChartDemo1.data1.getData().add(new XYChart.Data(2001, 102));
                    chart.ChartDemo1.data2.getData().add(new XYChart.Data(2001,2));

                });

                Thread.sleep(500);
                Platform.runLater( () -> {
                    chart.ChartDemo1.data1.getData().add(new XYChart.Data(2002,98));
                    chart.ChartDemo1.data2.getData().add(new XYChart.Data(2002,3));

                });

                Thread.sleep(500);
                Platform.runLater( () -> {
                    chart.ChartDemo1.data1.getData().add(new XYChart.Data(2003,85));
                    chart.ChartDemo1.data2.getData().add(new XYChart.Data(2003,1));

                });

                Thread.sleep(500);
                Platform.runLater( () -> {
                    chart.ChartDemo1.data1.getData().add(new XYChart.Data(2004,95));
                    chart.ChartDemo1.data2.getData().add(new XYChart.Data(2004, 1));

                });

                Thread.sleep(500);
                Platform.runLater( () -> {
                    chart.ChartDemo1.data1.getData().add(new XYChart.Data(2005,96));
                    chart.ChartDemo1.data2.getData().add(new XYChart.Data(2005,2));

                });

                Thread.sleep(500);
                Platform.runLater( () -> {
                    chart.ChartDemo1.data1.getData().add(new XYChart.Data(2006,98));
                    chart.ChartDemo1.data2.getData().add(new XYChart.Data(2006, 3));

                });

                Thread.sleep(500);
                Platform.runLater( () -> {
                    chart.ChartDemo1.data1.getData().add(new XYChart.Data(2007,123));
                    chart.ChartDemo1.data2.getData().add(new XYChart.Data(2007, 4));

                });

                Thread.sleep(500);
                Platform.runLater( () -> {
                    chart.ChartDemo1.data1.getData().add(new XYChart.Data(2008,95));
                    chart.ChartDemo1.data2.getData().add(new XYChart.Data(2008, 1));

                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
