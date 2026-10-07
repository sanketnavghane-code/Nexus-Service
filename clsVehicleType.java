import javax.swing.*;

public class clsVehicleType
{
	private int VehicleTypeID;
    private String VehicleTypeName;



    public void setVehicleTypeID(int VehicleTypeID)
    {
        this.VehicleTypeID = VehicleTypeID;
    }
    public int getVehicleTypeID()
    {
        return VehicleTypeID;
    }



    public void setVehicleTypeName(String VehicleTypeName)
    {
        this.VehicleTypeName = VehicleTypeName;
    }

    public String getVehicleTypeName()
    {
        return VehicleTypeName;
    }

	public static void addNewVehicleType(clsVehicleType temp)
	{
		dlsVehicleType.addNewVehicleType(temp);
	}

/*	public static boolean isVehicleDulplicate(String mVehicleName)
	{
		//return(dlsVehicle.isVehicleDulplicate(mVehicleName));
	}
*/

	public static void updateVehicleType(clsVehicleType temp)
	{
		dlsVehicleType.updateVehicleType(temp);
	}

	public static void deleteVehicleType(clsVehicleType temp)
	{
		dlsVehicleType.deleteVehicleType(temp);
	}

	public static int getAllVehicleTypeCount()
	{
		return(dlsVehicleType.getAllVehicleTypeCount());
	}

	public static String [] getAllVehicleTypeNames()
	{
		return(dlsVehicleType.getAllVehicleTypeNames());
	}

	public static clsVehicleType getVehicleTypeInformation(int mVehicleTypeID)
	{
		return(dlsVehicleType.getVehicleTypeInformation(mVehicleTypeID));
	}

	public static clsVehicleType [] getAllVehicleTypeInformation()
	{
		return(dlsVehicleType.getAllVehicleTypeInformation());
	}

	public static void addVehicleTypeRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("--Select Vehicle Type--");
		String VehicleTypeNames [] = clsVehicleType.getAllVehicleTypeNames();
		for(String name : VehicleTypeNames)
		{

			temp.addItem(name);
		}
	}


	public static int getIDFromName(String mVehicleTypeName)
	{
		return dlsVehicleType.getIDFromName(mVehicleTypeName);
	}
	public static void showVehicleType(clsVehicleType temp)
	{
		System.out.println("Vehicle Type ID   : "+temp.getVehicleTypeID());
		System.out.println("Vehicle Type Name : "+temp.getVehicleTypeName());
	}

	public static void main(String args[])
	{
		clsVehicleType temp = new clsVehicleType();
		temp.setVehicleTypeID(1);
		//clsVehicleType.deleteVehicleType(temp);
	}


}
