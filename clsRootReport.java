import javax.swing.*;

public class clsRootReport
{
    private int RootID ;
    private String RootName ;
	private int SourceStationID;
	private String StartTime;
	private int DestinationStationID;
	private int TimeShift;
	private int villagian;
	private String SourceStationName;
	private String DestinationStationName;

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

    public void setSourceStationName(String mSourceStationName)
    {
		this.SourceStationName = mSourceStationName;
	}

	public String getSourceStationName()
	{
		return SourceStationName;
	}

    public void setDestinationStationName(String mDestinationStationName)
    {
		this.DestinationStationName = mDestinationStationName;
	}

	public String getDestinationStationName()
	{
		return DestinationStationName;
	}

	public void setVillagian(int mvillagian)
	{
		this.villagian = mvillagian;
	}
	public int getVillagian()
	{
		return villagian;
	}


	public String getVillagianText()
	{
		if(this.villagian == 0)
		{
			return "Yes";
		}
		else
		{
			return "No";
		}
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



	public static clsRootReport getRootReportInformation(int mRootID)
	{
		return(dlsRoot.getRootReportInformation(mRootID));
	}

	public static clsRootReport[] getAllRootReportInformation()
	{
		return(dlsRoot.getAllRootReportInformation());
	}

	public static clsRootReport[] getAllRootReportInformation(int mSearchStationID)
	{
		return(dlsRoot.getAllRootReportInformation(mSearchStationID));
	}



	public static void showRootReport(clsRootReport temp)
	{
		System.out.println("Root ID   : "+temp.getRootID());
		System.out.println("Root Name : "+temp.getRootName());
		System.out.println("Source Station ID   : "+temp.getSourceStationID());
		System.out.println("Start Time   : "+temp.getStartTime());
		System.out.println("Time Shift   : "+temp.getTimeShift());
		System.out.println("Destination Station ID  : "+temp.getDestinationStationID());
		System.out.println("Villagian:"+temp.getVillagian());
		System.out.println("Source Station Name   : "+temp.getSourceStationName());
		System.out.println("Desinstion Station Name   : "+temp.getDestinationStationName());

    }

	public static void main(String args[])
	{
		//clsRoot temp = new clsRoot

		clsRootReport temp = clsRootReport.getRootReportInformation(7);

		clsRootReport.showRootReport(temp);


	}
}

