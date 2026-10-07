import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import myUtility.*;
public class clsTalukaAreaReport1
{
	private int TalukaID;
	private String TalukaName;
	private int TalukaAreaID;
	private String TalukaAreaName;

	public int getTalukaID()
	{
		return(TalukaID);
	}
	public void setTalukaID(int TalukaID)
	{
		this.TalukaID= TalukaID;
	}
	public String getTalukaName()
	{
		return(TalukaName);
	}
	public void setTalukaName(String TalukaName)
	{
		this.TalukaName=TalukaName;
	}

	public int getTalukaAreaID()
	{
		return(TalukaAreaID);
	}
	public void setTalukaAreaID(int TalukaAreaID)
	{
		this.TalukaAreaID= TalukaAreaID;
	}
	public String getTalukaAreaName()
	{
		return(TalukaAreaName);
	}
	public void setTalukaAreaName(String TalukaAreaName)
	{
		this.TalukaAreaName=TalukaAreaName;
	}
	public  static void showTalukaAreaReport1(clsTalukaAreaReport1 temp)
	{
		System.out.println("Taluka ID :"+temp.getTalukaID());
		System.out.println("Taluka Name :"+temp.getTalukaName());

		System.out.println("TalukaArea ID :"+temp.getTalukaAreaID());
		System.out.println("TalukaArea Name :"+temp.getTalukaAreaName());
	}

	public static  clsTalukaAreaReport1[] getTalukaAreaReport1Info()
	{
		return(dlsTalukaArea.getTalukaAreaReport1Info());
	}

	public static void main (String args[])
	{
		clsTalukaAreaReport1  data[] = clsTalukaAreaReport1.getTalukaAreaReport1Info();

		for( clsTalukaAreaReport1 temp : data)
		{
			showTalukaAreaReport1(temp);
		}
	}
}