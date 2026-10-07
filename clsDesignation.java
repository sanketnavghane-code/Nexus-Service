import javax.swing.*;

public class clsDesignation
{
    private int DesignationID ;
    private String DesignationName ;


    public void setDesignationID(int DesignationID)
    {
        this.DesignationID = DesignationID;
    }
    public int getDesignationID()
    {
        return DesignationID;
    }

    public void setDesignationName(String DesignationName)
    {
        this.DesignationName = DesignationName;
    }
    public String getDesignationName()
    {
        return DesignationName;
    }
     public void set(String DesignationName)
	{
		this.DesignationName = DesignationName;
	}

	public static void addNewDesignation(clsDesignation temp)
	{
		dlsDesignation.addNewDesignation(temp);
	}


	public static void updateDesignation(clsDesignation temp)
	{
		dlsDesignation.updateDesignation(temp);
	}

	public static void deleteDesignation(clsDesignation temp)
	{
		dlsDesignation.deleteDesignation(temp);
	}

	public static int getAllDesignationCount()
	{
		return(dlsDesignation.getAllDesignationCount());
	}

	public static String [] getAllDesignationNames()
	{
		return(dlsDesignation.getAllDesignationNames());
	}

	public static clsDesignation getDesignationInformation(int mDesignationID)
	{
		return(dlsDesignation.getDesignationInformation(mDesignationID));
	}

	public static clsDesignation [] getAllDesignationInformation()
	{
		return(dlsDesignation.getAllDesignationInformation());
	}

	public static void addDesignationRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("--Select Designation--");
		String DesignationNames [] = clsDesignation.getAllDesignationNames();
		for(String name : DesignationNames)
		{
			temp.addItem(name);
		}
	}



	public static int getIDFromName(String mDesignationName)
	{
		return dlsDesignation.getIDFromName(mDesignationName);
	}

	public static String getNameFromID(int mDesignationID)
	{
		return dlsDesignation.getNameFromID(mDesignationID);
	}


	public static void showDesignation(clsDesignation temp)
	{
		System.out.println("Designation ID   : "+temp.getDesignationID());
		System.out.println("Designation Name : "+temp.getDesignationName());

	}

	public static void main(String args[])
	{
		clsDesignation temp = clsDesignation.getDesignationInformation(13);
		clsDesignation.showDesignation(temp);

	}


}
