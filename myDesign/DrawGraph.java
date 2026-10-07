import com.example.fxgraphs.FXGraphPanel;
import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import javax.swing.*;

public class DrawGraph {
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JavaFX Graph in JPanel");
            frame.setSize(700, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Initialize JavaFX runtime (needed for JFXPanel)
            Platform.startup(() -> {});

            // Create a sample JavaFX LineChart
            NumberAxis xAxis = new NumberAxis();
            NumberAxis yAxis = new NumberAxis();
            LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
            XYChart.Series<Number, Number> series = new XYChart.Series<>();
            series.getData().add(new XYChart.Data<>(1, 5));
            series.getData().add(new XYChart.Data<>(2, 9));
            series.getData().add(new XYChart.Data<>(3, 6));
            lineChart.getData().add(series);

            // Create FXGraphPanel instance
            FXGraphPanel fxGraphPanel = new FXGraphPanel(lineChart);

            // Add the panel to JFrame
            frame.add(fxGraphPanel.getPanel());
            frame.setVisible(true);
        });
    }
}