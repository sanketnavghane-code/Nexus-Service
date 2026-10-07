import java.awt.Desktop;
import java.net.URI;

public class OpenGoogleMaps
{
	public static void showGoogleMap(String SourceStation, String DestinationStation)
	{
        try
        {
            String url = "https://www.google.com/maps/dir/" + SourceStation.replace(" ", "+") + "/" + DestinationStation.replace(" ", "+");

            Desktop.getDesktop().browse(new URI(url)); // Opens in the default web browser
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
