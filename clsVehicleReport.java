import javax.swing.*;

public class clsVehicleReport
{
    private int VehicleID ;
    private String VehicleName;
	private int VehicleTypeID;
	private String ChessisNo;
	private int InwardYear;
	private String VehicleTypeName;


    public void setVehicleID(int VehicleID)
    {
        this.VehicleID = VehicleID;
    }
    public int getVehicleID()
    {
        return VehicleID;
    }

	public void setVehicleTypeID(int VehicleTypeID)
	{
		this.VehicleTypeID = VehicleTypeID;
	}
	public int getVehicleTypeID()
	{
		return VehicleTypeID;
    }

    public void setVehicleName(String VehicleName)
    {
        this.VehicleName = VehicleName;
    }

    public String getVehicleName()
    {
        return VehicleName;
    }

    public void setChessisNo(String ChessisNo)
    {
        this.ChessisNo = ChessisNo;
    }

    public String getChessisNo()
    {
        return ChessisNo;
    }

    public void setInwardYear(int InwardYear)
    {
        this.InwardYear = InwardYear;
    }

    public int getInwardYear()
    {
        return InwardYear;
    }

	public void setVehicleTypeName(String VehicleTypeName)
	{
		this.VehicleTypeName = VehicleTypeName;
	}
	public String getVehicleTypeName()
	{
		return VehicleTypeName;
    }

	public static clsVehicleReport getVehicleReportInformation(int mVehicleID)
	{
		return(dlsVehicle.getVehicleReportInformation(mVehicleID));
	}

	public static clsVehicleReport [] getAllVehicleReportInformation()
	{
		return(dlsVehicle.getAllVehicleReportInformation());
	}

	public static void showVehicle(clsVehicleReport temp)
	{
		System.out.println("Vehicle ID   : "+temp.getVehicleID());
		System.out.println("Vehicle Name : "+temp.getVehicleName());
		System.out.println("Vehicle Type ID : "+temp.getVehicleTypeID());
		System.out.println("Chessis No : "+temp.getChessisNo());
		System.out.println("Inward Year : "+temp.getInwardYear());
		System.out.println("Vehicle Type Name : "+temp.getVehicleTypeName());

	}

	public static void main(String args[])
	{
		clsVehicleReport temp = clsVehicleReport.getVehicleReportInformation(4);
		clsVehicleReport.showVehicle(temp);

	}


}
