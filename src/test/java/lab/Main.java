package lab;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(2011);
        xAxis.setUpperBound(2016);
        BubbleChart bubbleChart = new BubbleChart(xAxis, yAxis);
        bubbleChart.setData(getChartData());
        bubbleChart.setTitle("Title");
        primaryStage.setTitle("Chart example");

        StackPane root = new StackPane();
        root.getChildren().add(bubbleChart);
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }

    private ObservableList<XYChart.Series<Integer, Double>> getChartData() {
        double aValue = 1.56;
        double bValue = 1.06;
        ObservableList<XYChart.Series<Integer, Double>> answer = FXCollections.observableArrayList();
        Series<Integer, Double> aSeries = new Series<Integer, Double>();
        Series<Integer, Double> bSeries = new Series<Integer, Double>();
        aSeries.setName("A");
        bSeries.setName("B");
        for (int i = 2011; i < 2016; i++) {
            double diff = Math.random();
            aSeries.getData().add(new XYChart.Data(i, aValue, diff));
            aValue = aValue + 10*diff - 5;
            diff = Math.random();
            bSeries.getData().add(new XYChart.Data(i, bValue, diff));
            bValue = bValue + 10*diff - 5;
            diff = Math.random();
        }
        answer.addAll(aSeries, bSeries);
        return answer;
    }
}