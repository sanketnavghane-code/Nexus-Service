import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import myUtility.*;
public class clsVillageReport1
{
	private int TalukaID;
	private String TalukaName;
	private int VillageID;
	private String VillageName;

	public int getVillageID()
	{
		return(VillageID);
	}
	public void setVillageID(int VillageID)
	{
		this.VillageID= VillageID;
	}
	public String getVillageName()
	{
		return(VillageName);
	}
	public void setVillageName(String VillageName)
	{
		this.VillageName=VillageName;
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
	public  static void showVillageReport1(clsVillageReport1 temp)
	{
		System.out.println("Village ID :"+temp.getVillageID());
		System.out.println("Village Name :"+temp.getVillageName());

		System.out.println("Taluka ID :"+temp.getTalukaID());
		System.out.println("Taluka Name :"+temp.getTalukaName());
	}
	public static clsVillageReport1[] getVillageReport1Info()
	{
		return(dlsVillage.getVillageReport1Info());
	}

	public static void main (String args[])
	{
		clsVillageReport1  data[] = clsVillageReport1.getVillageReport1Info();

		for( clsVillageReport1 temp : data)
		{
			showVillageReport1(temp);
		}
	}
}