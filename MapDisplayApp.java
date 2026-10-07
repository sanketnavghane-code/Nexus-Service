import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.*;

public class MapDisplayApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a WebView to show the map
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        // Google Maps embed URL with a specific location (e.g., New York)
        String googleMapsUrl = "https://www.google.com/maps/embed/v1/place?key=YOUR_API_KEY&q=New+York";

        // Load the Google Maps URL
        webEngine.load(googleMapsUrl);

        // Create a scene and add the WebView
        Scene scene = new Scene(webView, 800, 600);
        primaryStage.setTitle("Google Map Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
