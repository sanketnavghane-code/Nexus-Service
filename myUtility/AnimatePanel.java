package myUtility;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AnimatePanel extends Thread
{
	JPanel currentPanel;
	JPanel pnlParentPanel;
	JPanel pnlScrollPanel;
	int MOVE_DIRECTION;
	int lblposition ;

	int startFrom;
	int endAt;

	int speed;

	int PanelX;
	int PanelY;
	int PanelWidth;
	int PanelHeight;
	int ResetValue;

	int StartValue;

	public AnimatePanel(JPanel currentPanel,int speed,JPanel pnlParentPanel,int startFrom, int endAt, int Direction)
	{
		this.currentPanel=currentPanel;
		this.pnlParentPanel=pnlParentPanel;
		this.speed=speed;
		this.startFrom = startFrom;
		this.endAt = endAt;
		this.MOVE_DIRECTION = Direction;

		Dimension parentPanel = pnlParentPanel.getSize();
		Dimension currentPanelSize = currentPanel.getSize();
		Point currentPanelLocation = currentPanel.getLocation();
		Point parentPanelLocation = pnlParentPanel.getLocation();
		PanelWidth=currentPanelSize.width;
		PanelHeight=currentPanelSize.height;
		PanelY=currentPanelLocation.y;
		StartValue=parentPanel.width;

		if(Direction == 0)
			PanelX=parentPanelLocation.x - PanelWidth;
		else
			PanelX=startFrom;

		ResetValue=0-PanelWidth;

		start();
	}

	public void run()
	{
		if(MOVE_DIRECTION == 0)
		{
			while(PanelX < endAt)
			{
				startRightMoving();
			}
		}
		else
		{
			while(PanelX > endAt)
			{
				startLeftMoving();
			}
		}
	}

	public void startRightMoving()
	{

		try
		{
			PanelX=PanelX+1;

		/*	if(LabelX < ResetValue)
			{
				LabelX=StartValue;
			}
		*/
			currentPanel.setBounds(PanelX,PanelY,PanelWidth,PanelHeight);
			Thread.sleep(speed);
		}
		catch(Exception e)
		{

		}
	}

	public void startLeftMoving()
	{

		try
		{
			PanelX=PanelX-1;

		/*	if(LabelX < ResetValue)
			{
				LabelX=StartValue;
			}
		*/
			currentPanel.setBounds(PanelX,PanelY,PanelWidth,PanelHeight);
			Thread.sleep(speed);
		}
		catch(Exception e)
		{

		}
	}

}

