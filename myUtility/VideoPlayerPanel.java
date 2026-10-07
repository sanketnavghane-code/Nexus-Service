import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1920, 1080);
        add(layeredPane);

		JFXPanel jfxPanel = new JFXPanel();
        jfxPanel.setBounds(0, 0, 1920, 1080);
        layeredPane.add(jfxPanel, JLayeredPane.DEFAULT_LAYER);

        Platform.runLater(() -> {
            File videoFile = new File("D:\\FinalYearProject\\images\\WhatsApp Video 2025-02-21 at 5.13.05 PM.mp4");
            Media media = new Media(videoFile.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            mediaView.setFitWidth(1920);
            mediaView.setFitHeight(1080);

            Scene scene = new Scene(new javafx.scene.Group(mediaView));
            jfxPanel.setScene(scene);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        });
