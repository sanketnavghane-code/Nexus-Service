import javax.swing.*;

public class clsVillageArea
{
	private int VillageAreaID ;
	private String VillageAreaName ;
    private int VillageID;

	public void setVillageAreaID(int VillageAreaID)
    {
        this.VillageAreaID = VillageAreaID;
    }
    public int getVillageAreaID()
    {
        return VillageAreaID;
    }
	public void setVillageAreaName(String VillageAreaName)
    {
        this.VillageAreaName = VillageAreaName;
    }

    public String getVillageAreaName()
    {
        return VillageAreaName;
    }



	public void setVillageID(int VillageID)
    {
        this.VillageID = VillageID;
    }
    public int getVillageID()
    {
        return VillageID;
    }



	public static void addNewVillageArea(clsVillageArea temp)
	{
		dlsVillageArea.addNewVillageArea(temp);
	}

	public static String [] getAllVillageAreaNames()
	{
		return(dlsVillageArea.getAllVillageAreaNames());
	}
	public static String [] getAllVillageAreaNames(int mVillageAreaID)
	{
		return(dlsVillageArea.getAllVillageAreaNames(mVillageAreaID));
	}

	public static clsVillageArea getVillageAreaInformation(int mVillageAreaID)
	{
		return(dlsVillageArea.getVillageAreaInformation(mVillageAreaID));
	}
	public static clsVillageArea [] getAllVillageAreaInformation()
	{
		return(dlsVillageArea.getAllVillageAreaInformation());
	}


	public static void addVillageAreaRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("-- Select Village Area --");
		String VillageAreaNames [] = clsVillageArea.getAllVillageAreaNames();
		for(String name : VillageAreaNames)
		{
			temp.addItem(name);
		}
	}
	public static void addVillageAreaRecords(JComboBox temp, int mVillageID)
	{
		temp.removeAllItems();
		temp.addItem("-- Select Village Area--");
		String VillageAreaNames [] = clsVillageArea.getAllVillageAreaNames(mVillageID);
		for(String name : VillageAreaNames)
		{
			temp.addItem(name);
		}
	}


	public static int getIDFromName(String mVillageAreaName)
	{
		return dlsVillageArea.getIDFromName(mVillageAreaName);
	}
	public static void showVillageArea(clsVillageArea temp)
	{
		System.out.println("Village Area ID   : "+temp.getVillageAreaID());
		System.out.println("Village Area Name : "+temp.getVillageAreaName());
		System.out.println("Village ID  : "+temp.getVillageID());

	}

	public static void updateVillageArea(clsVillageArea temp)
	{
		dlsVillageArea.updateVillageArea(temp);
	}
	public static void deleteVillageArea(clsVillageArea temp)
	{
		dlsVillageArea.deleteVillageArea(temp);
	}

	public static void main(String args[])
	{
		clsVillageArea Data[]=clsVillageArea.getAllVillageAreaInformation();

		for(clsVillageArea temp : Data)
		{
			clsVillageArea.showVillageArea(temp);
		}
	}
}
