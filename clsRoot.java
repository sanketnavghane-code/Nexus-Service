import javax.swing.*;

public class clsRoot
{
    private int RootID ;
    private String RootName ;
	private int SourceStationID;
	private String StartTime;
	private int DestinationStationID;
	private int TimeShift;
	private int villagian;

    public void setRootID(int mRootID)
    {
        this.RootID = mRootID;
    }
    public int getRootID()
    {
        return RootID;
    }

    public void setRootName(String mRootName)
    {
        this.RootName = mRootName;
    }

    public String getRootName()
    {
        return RootName;
    }

    public void setSourceStationID(int mSourceStationID)
    {
		this.SourceStationID = mSourceStationID;
	}

	public int getSourceStationID()
	{
		return SourceStationID;
	}

	public void setVillagian(int mvillagian)
	{
		this.villagian = mvillagian;
	}
	public int getVillagian()
	{
		return villagian;
	}

    public void setDestinationStationID(int mDestinationStationID)
    {
		this.DestinationStationID = mDestinationStationID;
	}
	public int getDestinationStationID()
	{
		return DestinationStationID;
	}

	public void setTimeShift(int mTimeShift)
	{
		this.TimeShift = mTimeShift;
	}
	public int getTimeShift()
	{
		return TimeShift;
	}

	public String getTimeShiftText()
	{
		if(TimeShift == 0)
		{
			return("AM");
		}
		else
		{
			return("PM");
		}
	}

	public void setStartTime(String mStartTime)
	{
		this.StartTime = mStartTime;
	}
	public String getStartTime()
	{
		return StartTime;
	}


	public static int addNewRoot(clsRoot temp)
	{
		return (dlsRoot.addNewRoot(temp));
	}


	public static void updateRoot(clsRoot temp)
	{
		dlsRoot.updateRoot(temp);
	}

	public static void deleteRoot(clsRoot temp)
	{
		dlsRoot.deleteRoot(temp);
	}

	public static int getAllRootCount()
	{
		return(dlsRoot.getAllRootCount());
	}

	public static String[] getAllRootNames()
	{
		return(dlsRoot.getAllRootNames());
	}

	public static String [] getAllFreeRootNames(int TodaysDay,int TodaysMonth,int TodaysYear)
	{
		return(dlsRoot.getAllFreeRootNames( TodaysDay, TodaysMonth, TodaysYear));
	}

	public static clsRoot getRootInformation(int mRoot)
	{
		return(dlsRoot.getRootInformation(mRoot));
	}

	public static clsRoot[] getAllRootInformation()
	{
		return(dlsRoot.getAllRootInformation());
	}


	public static void addFreeRootRecords(JComboBox temp, int TodaysDay,int TodaysMonth,int TodaysYear)
	{
		temp.removeAllItems();
		temp.addItem("--Select Root--");
		String RootNames [] = clsRoot.getAllFreeRootNames( TodaysDay, TodaysMonth, TodaysYear);
		for(String name : RootNames)
		{
			temp.addItem(name);
		}
	}


	public static void addRootRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("--Select Root--");
		String RootNames [] = clsRoot.getAllRootNames();
		for(String name : RootNames)
		{
			temp.addItem(name);
		}
	}

	public static int getIDFromName(String mRootName)
	{
		return dlsRoot.getIDFromName(mRootName);
	}

	public static void showRoot(clsRoot temp)
	{
		System.out.println("Root ID   : "+temp.getRootID());
		System.out.println("Root Name : "+temp.getRootName());
		System.out.println("Source Station ID   : "+temp.getSourceStationID());
		System.out.println("Start Time   : "+temp.getStartTime());
		System.out.println("Time Shift   : "+temp.getTimeShift());
		System.out.println("Destination Station ID  : "+temp.getDestinationStationID());
		System.out.println("Villagian:"+temp.getVillagian());
    }

	public static void main(String args[])
	{
		String RootNames [] = clsRoot.getAllFreeRootNames(22,2,2025);

		for(String Rname : RootNames )
		{
			System.out.println(Rname);
		}
	}
}

