import javax.swing.*;

public class clsDistrict
{
	private int DistrictID;
	private String DistrictName;
	private int StateID;

	public void setDistrictID(int DistrictID)
	{
		this.DistrictID = DistrictID;
	}

	public int getDistrictID()
	{
		return(DistrictID);
	}

	public void setDistrictName(String DistrictName)
	{
		this.DistrictName = DistrictName;
	}

	public String getDistrictName()
	{
		return(DistrictName);
	}

	public void setStateID(int StateID)
	{
		this.StateID = StateID;
	}

	public int getStateID()
	{
		return(StateID);
	}

	public static void addNewDistrict(clsDistrict temp)
	{
		dlsDistrict.addNewDistrict(temp);
	}

	public static int getIDFromName(String mDistrictName)
	{
		return(dlsDistrict.getIDFromName(mDistrictName));
	}

	public static clsDistrict getDistrictInformation(int mDistrictID)
	{
		return(dlsDistrict.getDistrictInformation(mDistrictID));
	}

	public static void updateDistrict(clsDistrict temp)
	{
		dlsDistrict.updateDistrict(temp);
	}

	public static void deleteDistrict(clsDistrict temp)
	{
		dlsDistrict.deleteDistrict(temp);
	}

	public static String[] getAllStateNames()
	{
		return(dlsDistrict.getAllStateNames());
	}

	public static String[] getAllStateNames(int mCountryID)
	{
		return(dlsDistrict.getAllStateNames(mCountryID));
	}

	public static String[] getAllDistrictNames(int mState)
	{
		return(dlsDistrict.getAllDistrictNames(mState));
	}

	public static String[] getAllDistrictNames()
	{
		return(dlsDistrict.getAllDistrictNames());
	}

	public static void addStateRecords(JComboBox temp, int mCountryID)
	{
		temp.removeAllItems();
		temp.addItem("--Select State--");
		String StateNames[] = clsDistrict.getAllStateNames(mCountryID);
		for(String name : StateNames)
		{
			temp.addItem(name);
		}
	}

	public static void addDistrictRecords(JComboBox temp, int mStateID)
	{
		temp.removeAllItems();
		temp.addItem("--Select District--");
		String DistrictNames[] = clsDistrict.getAllDistrictNames(mStateID);
		for(String name : DistrictNames)
		{
			temp.addItem(name);
		}
	}


	public static void addDistrictRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("--Select District--");
		String DistrictNames[] = clsDistrict.getAllDistrictNames();
		for(String name : DistrictNames)
		{
			temp.addItem(name);
		}
	}

	public static void showDistrict(clsDistrict temp)
	{
		System.out.println("DistrictID : "+temp.getDistrictID());
		System.out.println("District Name : "+temp.getDistrictName());
		System.out.println("State ID: "+temp.getStateID());

	}

	public static void main(String args[])
	{
		clsDistrict temp = new clsDistrict();
		temp.setDistrictID(0);
		temp.setDistrictName("My District");
		temp.setStateID(5);
		clsDistrict.addNewDistrict(temp);
	}


}
