import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import myUtility.*;
public class clsTalukaReport1
{
	private int DistrictID;
	private String DistrictName;
	private int TalukaID;
	private String TalukaName;

	public int getDistrictID()
	{
		return(DistrictID);
	}
	public void setDistrictID(int DistrictID)
	{
		this.DistrictID= DistrictID;
	}
	public String getDistrictName()
	{
		return(DistrictName);
	}
	public void setDistrictName(String DistrictName)
	{
		this.DistrictName=DistrictName;
	}

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
	public  static void showTalukaReport1(clsTalukaReport1 temp)
	{
		System.out.println("District ID :"+temp.getDistrictID());
		System.out.println("District Name :"+temp.getDistrictName());

		System.out.println("Taluka ID :"+temp.getTalukaID());
		System.out.println("Taluka Name :"+temp.getTalukaName());
	}
	public static clsTalukaReport1[] getTalukaReport1Info()
	{
		return(dlsTaluka.getTalukaReport1Info());
	}

	public static void main (String args[])
	{
		clsTalukaReport1  data[] = clsTalukaReport1.getTalukaReport1Info();

		for( clsTalukaReport1 temp : data)
		{
			showTalukaReport1(temp);
		}
	}
}