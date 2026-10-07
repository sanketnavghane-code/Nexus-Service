import javax.swing.*;

public class clsRootStop
{
    private int RootStopID ;
	private int RootID;
	private int StationID;
	private String StopTime;

    public void setRootStopID(int RootStopID)
    {
        this.RootStopID = RootStopID;
    }
    public int getRootStopID()
    {
        return RootStopID;
    }

    public void setRootID(int mRootID)
    {
		this.RootID = mRootID;
	}
	public int getRootID()
	{
		return RootID;
	}

    public void setStationID(int StationID)
    {
		this.StationID = StationID;
	}
	public int getStationID()
	{
		return StationID;
	}
    public void setStopTime( String StopTime)
    {
		this.StopTime = StopTime;
	}
	public String getStopTime()
	{
		return StopTime;
	}



	public static void addNewRootStop(clsRootStop temp)
	{
		dlsRootStop.addNewRootStop(temp);
	}


	public static void updateRootStop(clsRootStop temp)
	{
		dlsRootStop.updateRootStop(temp);
	}

	public static void deleteRootStop(clsRootStop temp)
	{
		dlsRootStop.deleteRootStop(temp);
	}

	public static int getAllRootStopCount()
	{
		return(dlsRootStop.getAllRootStopCount());
	}

	/*public static String[] getAllRootStopID()
	{
		return(dlsRootStop.getAllRootStopID());
	}*/

	public static clsRootStop getRootStopInformation(int mRootStop)
	{
		return(dlsRootStop.getRootStopInformation(mRootStop));
	}

	public static clsRootStop[] getAllRootStopInformation()
	{
		return(dlsRootStop.getAllRootStopInformation());
	}



/*	public static void addRootStopRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("--Select RootStop--");
		clsRootStop Roots [] = clsRootStop.getAllRootStopInformation();
		for(clsRootStop roots : Roots)
		{
			temp.addItem(roots.getRootStop());
		}
	}*/

	public static int getIDFromName(String mRootStopName)
	{
		return dlsRootStop.getIDFromName(mRootStopName);
	}

	public static void showRootStop(clsRootStop temp)
	{
		System.out.println("RootStop ID   : "+temp.getRootStopID());
		System.out.println("Root ID   : "+temp.getRootID());
		System.out.println("Station ID   : "+temp.getStationID());
		System.out.println("Stop Time  : "+temp.getStopTime());
    }

	public static void main(String args[])
	{
		 clsRootStop[] emp= clsRootStop.getAllRootStopInformation();
		 for(clsRootStop emps : emp)
		 {
			clsRootStop.showRootStop(emps);
		 }
	}
}

