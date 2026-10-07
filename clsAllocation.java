import javax.swing.*;

public class clsAllocation
{
    private int AllocationID ;
    private String AllocationDate ;
	private int RootID;
	private int DriverID;
	private int ConductorID;
	private int VehicleID;
	private int AllocationDayNo;
	private int AllocationMonthNo;
	private int AllocationYearNo;

    public void setAllocationID(int mAllocationID)
    {
        this.AllocationID = mAllocationID;
    }
    public int getAllocationID()
    {
        return AllocationID;
    }

    public void setAllocationDate(String mAllocationDate)
    {
        this.AllocationDate = mAllocationDate;
    }
	public String getAllocationDate()
    {
        return AllocationDate;
    }

    public void setRootID(int mRootID)
    {
		this.RootID = mRootID;
	}
	public int getRootID()
	{
		return RootID;
	}

    public void setDriverID(int mDriverID)
    {
		this.DriverID = mDriverID;
	}
	public int getDriverID()
	{
		return DriverID;
	}

    public void setConductorID(int mConductorID)
    {
		this.ConductorID = mConductorID;
	}
	public int getConductorID()
	{
		return ConductorID;
	}
    public void setVehicleID(int mVehicleID)
    {
		this.VehicleID = mVehicleID;
	}
	public int getVehicleID()
	{
		return VehicleID;
	}

    public void setAllocationDayNo(int mAllocationDayNo)
    {
        this.AllocationDayNo = mAllocationDayNo;
    }
    public int getAllocationDayNo()
    {
        return AllocationDayNo;
    }

     public void setAllocationMonthNo(int mAllocationMonthNo)
     {
         this.AllocationMonthNo = mAllocationMonthNo;
     }
     public int getAllocationMonthNo()
     {
         return AllocationMonthNo;
    }

     public void setAllocationYearNo(int mAllocationYearNo)
     {
         this.AllocationYearNo = mAllocationYearNo;
     }
     public int getAllocationYearNo()
     {
         return AllocationYearNo;
    }

	public static boolean isRootBusy(clsAllocation temp)
	{
		return(dlsAllocation.isRootBusy(temp));
	}
	public static void addNewAllocation(clsAllocation temp)
	{
		dlsAllocation.addNewAllocation(temp);
	}


	public static void updateAllocation(clsAllocation temp)
	{
		dlsAllocation.updateAllocation(temp);
	}

	public static void deleteAllocation(clsAllocation temp)
	{
		dlsAllocation.deleteAllocation(temp);
	}

	public static int getAllAllocationCount()
	{
		return(dlsAllocation.getAllAllocationCount());
	}

	public static String[] getAllAllocationNames()
	{
		return(dlsAllocation.getAllAllocationNames());
	}

	public static clsAllocation getAllocationInformation(int mAllocation)
	{
		return(dlsAllocation.getAllocationInformation(mAllocation));
	}

	public static clsAllocation[] getAllAllocationInformation()
	{
		return(dlsAllocation.getAllAllocationInformation());
	}



	public static void addAllocationRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("--Select Allocation--");
		String AllocationNames [] = clsAllocation.getAllAllocationNames();
		for(String name : AllocationNames)
		{
			temp.addItem(name);
		}
	}

	public static int getIDFromName(String mAllocationName)
	{
		return dlsAllocation.getIDFromName(mAllocationName);
	}

	public static void showAllocation(clsAllocation temp)
	{
		System.out.println("Allocation ID   : "+temp.getAllocationID());
		System.out.println("Root ID   : "+temp.getRootID());
		System.out.println("Driver ID   : "+temp.getDriverID());
		System.out.println("Conductor ID   : "+temp.getConductorID());
		System.out.println("Allocation Day : "+temp.getAllocationDayNo());
		System.out.println("Allocation Month : "+temp.getAllocationMonthNo());
		System.out.println("Allocation Year : "+temp.getAllocationYearNo());
    }

	public static void main(String args[])
	{
		 clsAllocation[] emp= clsAllocation.getAllAllocationInformation();
		 for(clsAllocation emps : emp)
		 {
			clsAllocation.showAllocation(emps);
		 }
	}
}

