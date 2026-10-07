package goonline;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.*;

public class GoogleMapInFrame extends JFrame
{

    private static final int ZOOM = 5;

    private JFXPanel jfxPanel;

    private String SourceStation;
    private String DestinationStation;

    public GoogleMapInFrame(String SourceStation,String DestinationStation)
    {
        setTitle("Google Map From : "+SourceStation+"	To : "+DestinationStation);
        setSize(1000, 800);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.SourceStation=SourceStation;
    	this.DestinationStation=DestinationStation;

        // Initialize JavaFX components
        initJavaFXComponents();
        setVisible(true);
    }

    private void initJavaFXComponents() {
        jfxPanel = new JFXPanel();
        add(jfxPanel);

        // Run JavaFX initialization on the JavaFX thread
        Platform.runLater(() -> {
            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();

            // Load Google Maps URL with API key
	   			String url ="https://www.google.com/maps/dir/"+SourceStation+"/"+DestinationStation;

			webEngine.load(url);

			Scene scene = new Scene(webView);
			jfxPanel.setScene(scene);
		    });
		}

		public static void showGoogleMap(String SourceStation,String DestinationStation)
		{
		    SwingUtilities.invokeLater(() -> {
			new GoogleMapInFrame(SourceStation,DestinationStation);
		    });
		}
}
