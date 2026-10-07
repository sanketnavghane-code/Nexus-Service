package myUtility;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class MovingLabel extends Thread
{
	JLabel currentLabel;
	JPanel pnlScrollPanel;
	int lblposition ;

	int speed;

	int LabelX;
	int LabelY;
	int LabelWidth;
	int LabelHeight;
	int ResetValue;

	int StartValue;

	private static javax.swing.Timer movelabel;
	java.util.Timer timerStarter;

	public MovingLabel(JLabel currentLabel,int speed,JPanel pnlScrollPanel)
	{
		this.currentLabel=currentLabel;
		this.pnlScrollPanel=pnlScrollPanel;
		this.speed=speed;
		Dimension parentPanel = pnlScrollPanel.getSize();
		Dimension currentLabelSize = currentLabel.getSize();
		Point currentLabelLocation = currentLabel.getLocation();
		LabelWidth=currentLabelSize.width;
		LabelHeight=currentLabelSize.height;
		LabelY=currentLabelLocation.y;
		StartValue=parentPanel.width;
		LabelX=StartValue;
		ResetValue=0-LabelWidth;

		//start();

		movelabel = new javax.swing.Timer(speed,new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e)
				{
					startMoving();
					//timerButtons.stop();
				}
			});

		timerStarter = new java.util.Timer(false);
		timerStarter.schedule(new TimerTask(){
				@Override
				public void run()
				{
					movelabel.start();
				}
			},0);


	}
/*	public void run()
	{
		while(true)
		{
			startScrolling();
		}
	}
*/

	public void startMoving()
	{

//		try
//		{
			LabelX=LabelX-1;

			if(LabelX < ResetValue)
			{
				LabelX=StartValue;
			}

			currentLabel.setBounds(LabelX,LabelY,LabelWidth,LabelHeight);
			pnlScrollPanel.repaint();
//			Thread.sleep(speed);
//		}
/*		catch(Exception e)
		{

		}
*/
	}
}

