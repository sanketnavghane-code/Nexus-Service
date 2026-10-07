package myDesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import java.io.File;

public class VideoPanel
{
	public static JPanel getVideoPanel(JPanel currentPanel,String currentPath)
	{
		currentPanel.setLayout(new BorderLayout());
		Dimension ParentPanelSize = currentPanel.getSize();
		int vdoPanelWidth = ParentPanelSize.width;
		int vdoPanelHeight = ParentPanelSize.height;
		currentPanel.setBackground(Color.BLACK);

		/*JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, vdoPanelWidth, vdoPanelHeight);
		currentPanel.add(layeredPane);*/

		// JavaFX Panel for Video Background
		JFXPanel jfxPanel = new JFXPanel();
		//jfxPanel.setSize(vdoPanelWidth, vdoPanelHeight);
		//jfxPanel.setSize(300,300);
		jfxPanel.setBounds(10,10,100,100);
		jfxPanel.setLayout(new BorderLayout());
		jfxPanel.setBackground(Color.RED);
		currentPanel.add(jfxPanel,BorderLayout.CENTER);

		Platform.runLater(()->{
			File videoFile = new File(currentPath);

			Media media = new Media(videoFile.toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			MediaView mediaView = new MediaView(mediaPlayer);
			mediaView.setFitWidth(vdoPanelWidth);
			mediaView.setFitHeight(vdoPanelHeight);
			System.out.println("Width : "+vdoPanelWidth+"\nHeight : "+vdoPanelHeight);

			Scene scene = new Scene(new javafx.scene.Group(mediaView),vdoPanelWidth,vdoPanelHeight);
			jfxPanel.setScene(scene);
			//jfxPanel.setScene(new javafx.scene.Scene(new javafx.scene.layout.StackPane(mediaView)));
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			mediaPlayer.play();
		});

		return(currentPanel);
	}
}


