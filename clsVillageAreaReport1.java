import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import myUtility.*;
public class clsVillageAreaReport1
{
	private int VillageID;
	private int VillageAreaID;
	private String VillageAreaName;

	public int getVillageID()
	{
		return(VillageID);
	}
	public void setVillageID(int VillageID)
	{
		this.VillageID= VillageID;
	}

	public int getVillageAreaID()
	{
		return(VillageAreaID);
	}
	public void setVillageAreaID(int VillageAreaID)
	{
		this.VillageAreaID= VillageAreaID;
	}
	public String getVillageAreaName()
	{
		return(VillageAreaName);
	}
	public void setVillageAreaName(String VillageAreaName)
	{
		this.VillageAreaName=VillageAreaName;
	}
	public  static void showVillageAreaReport1(clsVillageAreaReport1 temp)
	{
		System.out.println("Village ID :"+temp.getVillageID());
		System.out.println("VillageArea ID :"+temp.getVillageAreaID());
		System.out.println("VillageArea Name :"+temp.getVillageAreaName());
	}

	public static  clsVillageAreaReport1[] getVillageAreaReport1Info()
	{
		return(dlsVillageArea.getVillageAreaReport1Info());
	}

	public static void main (String args[])
	{
		clsVillageAreaReport1  data[] = clsVillageAreaReport1.getVillageAreaReport1Info();

		for( clsVillageAreaReport1 temp : data)
		{
			showVillageAreaReport1(temp);
		}
	}
}