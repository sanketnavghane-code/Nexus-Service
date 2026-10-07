public class clsLocationManagement2
{
	private int CountryID;
	private String CountryName;
	private int StateID;
	private String StateName;

	public void setCountryID(int CountryID)
	{
		this.CountryID = CountryID;
	}

	public int getCountryID()
	{
		return CountryID;
	}

	public void setCountryName(String CountryName)
	{
		this.CountryName = CountryName;
	}

	public String getCountryName()
	{
		return CountryName;
    }

	public void setStateID(int StateID)
	{
		this.StateID = StateID;
	}

	public int getStateID()
	{
		return(StateID);
	}

	public void setStateName(String StateName)
	{
		this.StateName = StateName;

	}

	public String getStateName()
	{
		return(StateName);
	}

	public static void showLocationManagement2(clsLocationManagement2 temp)
	{
		System.out.println("Country ID : "+temp.CountryID);
		System.out.println("Country Name : "+temp.CountryName);
		System.out.println("State ID : "+temp.StateID);
		System.out.println("State Name : "+temp.StateName);
	}

	public static clsLocationManagement2 getLocationInfo(int mStateID)
	{
		return(dlsLocationManagement2.getLocationInfo(mStateID));
	}

	public static void main(String args[])
	{
		clsLocationManagement2 temp = clsLocationManagement2.getLocationInfo(6);
		clsLocationManagement2.showLocationManagement2(temp);
	}

}