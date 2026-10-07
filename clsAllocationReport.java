import javax.swing.*;

public class clsAllocationReport
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
	private String VehicleName;


	private String RootName;
	private String DriverName;
	private String DriverContactNo;
	private String ConductorName;
	private String ConductorContactNo;

	private String ConductorBillaNo;
	private String ConductorLicenceNo;
	private String DriverBillaNo;
	private String DriverLicenceNo;

	private int DesignationID;
	private String DesignationName;

	private int VehicleTypeID;
	private String VehicleTypeName;


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
		AllocationDate = String.valueOf(AllocationDayNo)+"/"+String.valueOf(AllocationMonthNo)+"/"+String.valueOf(AllocationYearNo);
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

    public void setRootName(String mRootName)
    {
		this.RootName = mRootName;
	}
	public String getRootName()
	{
		return RootName;
	}

    public void setDriverID(int mDriverID)
    {
		this.DriverID = mDriverID;
	}
	public int getDriverID()
	{
		return DriverID;
	}

    public void setDriverName(String mDriverName)
    {
		this.DriverName = mDriverName;
	}
	public String getDriverName()
	{
		return DriverName;
	}

    public void setConductorID(int mConductorID)
    {
		this.ConductorID = mConductorID;
	}
	public int getConductorID()
	{
		return ConductorID;
	}

    public void setConductorName(String mConductorName)
    {
		this.ConductorName = mConductorName;
	}
	public String getConductorName()
	{
		return ConductorName;
	}

    public void setDesignationID(int mDesignationID)
    {
		this.DesignationID = mDesignationID;
	}
	public int getDesignationID()
	{
		return DesignationID;
	}

    public void setDesignationName(String mDesignationName)
    {
		this.DesignationName = mDesignationName;
	}
	public String getDesignationName()
	{
		return DesignationName;
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


    public void setVehicleID(int mVehicleID)
    {
		this.VehicleID = mVehicleID;
	}
	public int getVehicleID()
	{
		return VehicleID;
	}
    public void setVehicleName(String mVehicleName)
    {
		this.VehicleName = mVehicleName;
	}
	public String getVehicleName()
	{
		return VehicleName;
	}
    public void setVehicleTypeID(int mVehicleTypeID)
    {
		this.VehicleTypeID = mVehicleTypeID;
	}
	public int getVehicleTypeID()
	{
		return VehicleTypeID;
	}
    public void setVehicleTypeName(String mVehicleTypeName)
    {
		this.VehicleTypeName = mVehicleTypeName;
	}
	public String getVehicleTypeName()
	{
		return VehicleTypeName;
	}
	//Driver
    public void setDriverContactNo(String mDriverContactNo)
    {
		this.DriverContactNo = mDriverContactNo;
	}
	public String getDriverContactNo()
	{
		return DriverContactNo;
	}
    public void setDriverBillaNo(String mDriverBillaNo)
    {
		this.DriverBillaNo = mDriverBillaNo;
	}
	public String getDriverBillaNo()
	{
		return DriverBillaNo;
	}
    public void setDriverLicenseNo(String mDriverLicenseNo)
    {
		this.DriverLicenceNo = mDriverLicenseNo;
	}
	public String getDriverLicenseNo()
	{
		return DriverLicenceNo;
	}
	//Conductor
    public void setConductorContactNo(String mConductorContactNo)
    {
		this.ConductorContactNo = mConductorContactNo;
	}
	public String getConductorContactNo()
	{
		return ConductorContactNo;
	}
    public void setConductorBillaNo(String mConductorBillaNo)
    {
		this.ConductorBillaNo = mConductorBillaNo;
	}
	public String getConductorBillaNo()
	{
		return ConductorBillaNo;
	}
    public void setConductorLicenseNo(String mConductorLicenseNo)
    {
		this.ConductorLicenceNo = mConductorLicenseNo;
	}
	public String getConductorLicenseNo()
	{
		return ConductorLicenceNo;
	}


	public static clsAllocationReport getAllocationReportInformation(int mAllocationID)
	{
		return(dlsAllocation.getAllocationReportInformation(mAllocationID));
	}

	public static clsAllocationReport[] getAllAllocationReportInformation()
	{
		return(dlsAllocation.getAllAllocationReportInformation());
	}

	public static clsAllocationReport[] getAllAllocationReportInformation(int Day, int Month, int Year)
	{
		return(dlsAllocation.getAllocationReportInformation(Day,Month,Year));
	}


	public static void showAllocation(clsAllocationReport temp)
	{
		System.out.println("Allocation ID   : "+temp.getAllocationID());
		System.out.println("Allocation Date   : "+temp.getAllocationDate());
		System.out.println("Root ID   : "+temp.getRootID());
		System.out.println("Driver ID   : "+temp.getDriverID());
		System.out.println("Conductor ID   : "+temp.getConductorID());
		System.out.println("Vehicle ID   : "+temp.getVehicleID());
		System.out.println("Allocate Day   : "+temp.getAllocationDayNo());
		System.out.println("Allocate Month  : "+temp.getAllocationMonthNo());
		System.out.println("Allocate Year  : "+temp.getAllocationYearNo());
		System.out.println("Vehicle Name   : "+temp.getVehicleName());
		System.out.println("Root Name   : "+temp.getRootName());
		System.out.println("Driver Name   : "+temp.getDriverName());
		System.out.println("Driver Contact No   : "+temp.getDriverContactNo());
		System.out.println("Conductor Name   : "+temp.getConductorName());
		System.out.println("Conductor Contact No   : "+temp.getConductorContactNo());
		System.out.println("Conductor Billa No   : "+temp.getConductorBillaNo());
		System.out.println("Conductor LicenceNo   : "+temp.getConductorLicenseNo());
		System.out.println("Driver Billa No   : "+temp.getDriverBillaNo());
		System.out.println("Driver LicenceNo   : "+temp.getDriverLicenseNo());
		System.out.println("Designamtion ID   : "+temp.getDesignationID());
		System.out.println("Designamtion Name : "+temp.getDesignationName());
		System.out.println("Vehicle Type ID   : "+temp.getVehicleTypeID());
		System.out.println("Vehicle Type Name   : "+temp.getVehicleTypeName());

    }

	public static void main(String args[])
	{
		clsAllocationReport Data[]=clsAllocationReport.getAllAllocationReportInformation(7,3,2025);

		for(clsAllocationReport temp : Data)
			clsAllocationReport.showAllocation(temp);

	}
}

