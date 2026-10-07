import javax.swing.*;

public class clsVehicle
{
    private int VehicleID ;
    private String VehicleName;
	private int VehicleTypeID;
	private String ChessisNo;
	private int InwardYear;


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

	public static int addNewVehicle(clsVehicle temp)
	{
		return(dlsVehicle.addNewVehicle(temp));
	}

/*	public static boolean isVehicleDulplicate(String mVehicleName)
	{
		//return(dlsVehicle.isVehicleDulplicate(mVehicleName));
	}
*/

	public static void updateVehicle(clsVehicle temp)
	{
		dlsVehicle.updateVehicle(temp);
	}

	public static void deleteVehicle(clsVehicle temp)
	{
		dlsVehicle.deleteVehicle(temp);
	}

	public static int getAllVehicleCount()
	{
		return(dlsVehicle.getAllVehicleCount());
	}

	public static String [] getAllVehicleNames()
	{
		return(dlsVehicle.getAllVehicleNames());
	}


	public static String [] addFreeVehicleRecords(int TodaysDay,int TodaysMonth,int TodaysYear)
	{
		return(dlsVehicle.addFreeVehicleRecords(TodaysDay, TodaysMonth, TodaysYear));
	}

	public static clsVehicle getVehicleInformation(int mVehicleID)
	{
		return(dlsVehicle.getVehicleInformation(mVehicleID));
	}

	public static clsVehicle [] getAllVehicleInformation()
	{
		return(dlsVehicle.getAllVehicleInformation());
	}

	public static void addVehicleRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("--Select Vehicle--");
		String VehicleNames [] = clsVehicle.getAllVehicleNames();
		for(String name : VehicleNames)
		{

			temp.addItem(name);
		}
	}

	public static void addFreeVehicleRecords(JComboBox temp, int TodaysDay,int TodaysMonth,int TodaysYear)
	{
		temp.removeAllItems();
		temp.addItem("--Select Vehicle--");
		String VehicleNames [] = clsVehicle.addFreeVehicleRecords(TodaysDay, TodaysMonth, TodaysYear);
		for(String name : VehicleNames)
		{
			temp.addItem(name);
		}
	}


	public static int getIDFromName(String mVehicleName)
	{
		return dlsVehicle.getIDFromName(mVehicleName);
	}
	public static void showVehicle(clsVehicle temp)
	{
		System.out.println("Vehicle ID   : "+temp.getVehicleID());
		System.out.println("Vehicle Name : "+temp.getVehicleName());
		System.out.println("Vehicle Type ID : "+temp.getVehicleTypeID());
		System.out.println("Chessis No : "+temp.getChessisNo());
		System.out.println("Inward Year : "+temp.getInwardYear());

	}

	public static void main(String args[])
	{
		String temp[] = clsVehicle.addFreeVehicleRecords(22,2,2025);
		for(String name : temp )
		{
			System.out.println(name);
		}
	}


}
