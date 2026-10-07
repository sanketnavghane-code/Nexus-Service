import javax.swing.*;

public class clsRootStopReport
{
    private int RootStopID ;
	private int RootID;
	private String RootName;
	private int StationID;
	private String TalukaName;
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

    public void setRootName( String RootName)
    {
		this.RootName = RootName;
	}
	public String getRootName()
	{
		return RootName;
	}

    public void setTalukaName( String TalukaName)
    {
		this.TalukaName = TalukaName;
	}
	public String getTalukaName()
	{
		return TalukaName;
	}


	public static clsRootStopReport[] getAllRootStopReportInformation()
	{
		return(dlsRootStop.getAllRootStopReportInformation());
	}

	public static clsRootStopReport[] getAllRootStopReportInformation(int mRootID)
	{
		return(dlsRootStop.getAllRootStopReportInformation(mRootID));
	}


	public static void showRootStop(clsRootStopReport temp)
	{
		System.out.println("RootStop ID   : "+temp.getRootStopID());
		System.out.println("Root ID   : "+temp.getRootID());
		System.out.println("Root Name  : "+temp.getRootName());
		System.out.println("Station ID   : "+temp.getStationID());
		System.out.println("Stop Time  : "+temp.getStopTime());
		System.out.println("Taluka Name  : "+temp.getTalukaName());
	}


	public static void showAllRootStop(clsRootStopReport temp[])
	{
		for(clsRootStopReport rootStop : temp)
		{
			System.out.println("RootStop ID   : "+rootStop.getRootStopID());
			System.out.println("Root ID   : "+rootStop.getRootID());
			System.out.println("Root Name  : "+rootStop.getRootName());
			System.out.println("Station ID   : "+rootStop.getStationID());
			System.out.println("Stop Time  : "+rootStop.getStopTime());
			System.out.println("Taluka Name  : "+rootStop.getTalukaName());
		}
	}
	public static void main(String args[])
	{
		 clsRootStopReport[] emp= clsRootStopReport.getAllRootStopReportInformation();
		 for(clsRootStopReport emps : emp)
		 {
			clsRootStopReport.showRootStop(emps);
		 }
  	}
}

