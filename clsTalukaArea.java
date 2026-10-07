import javax.swing.*;

public class clsTalukaArea
{
	private int TalukaAreaID ;
	private String TalukaAreaName ;
    private int TalukaID;
    private String TalukaName;

	public void setTalukaAreaID(int TalukaAreaID)
    {
        this.TalukaAreaID = TalukaAreaID;
    }
    public int getTalukaAreaID()
    {
        return TalukaAreaID;
    }
	public void setTalukaAreaName(String TalukaAreaName)
    {
        this.TalukaAreaName = TalukaAreaName;
    }

    public String getTalukaAreaName()
    {
        return TalukaAreaName;
    }



	public void setTalukaID(int TalukaID)
    {
        this.TalukaID = TalukaID;
    }
    public int getTalukaID()
    {
        return TalukaID;
    }
	public void setTalukaName(String TalukaName)
    {
        this.TalukaName = TalukaName;
    }
    public String getTalukaName()
    {
        return TalukaName;
    }


	public static void addNewTalukaArea(clsTalukaArea temp)
	{
		dlsTalukaArea.addNewTalukaArea(temp);
	}

	public static String [] getAllTalukaAreaNames()
	{
		return(dlsTalukaArea.getAllTalukaAreaNames());
	}
	public static String [] getAllTalukaAreaNames(int mTalukaAreaID)
	{
		return(dlsTalukaArea.getAllTalukaAreaNames(mTalukaAreaID));
	}

	public static clsTalukaArea getTalukaAreaInformation(int mTalukaAreaID)
	{
		return(dlsTalukaArea.getTalukaAreaInformation(mTalukaAreaID));
	}
	public static clsTalukaArea [] getAllTalukaAreaInformation()
	{
		return(dlsTalukaArea.getAllTalukaAreaInformation());
	}


	public static void addTalukaAreaRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("-- Select Taluka Area --");
		String TalukaAreaNames [] = clsTalukaArea.getAllTalukaAreaNames();
		for(String name : TalukaAreaNames)
		{
			temp.addItem(name);
		}
	}
	public static void addTalukaAreaRecords(JComboBox temp, int mTalukaID)
	{
		temp.removeAllItems();
		temp.addItem("-- Select Taluka Area--");
		String TalukaAreaNames [] = clsTalukaArea.getAllTalukaAreaNames(mTalukaID);
		for(String name : TalukaAreaNames)
		{
			temp.addItem(name);
		}
	}


	public static int getIDFromName(String mTalukaAreaName)
	{
		return dlsTalukaArea.getIDFromName(mTalukaAreaName);
	}
	public static void showTalukaArea(clsTalukaArea temp)
	{
		System.out.println("Taluka Area ID   : "+temp.getTalukaAreaID());
		System.out.println("Taluka Area Name : "+temp.getTalukaAreaName());
		System.out.println("Taluka ID  : "+temp.getTalukaID());

	}

	public static void updateTalukaArea(clsTalukaArea temp)
	{
		dlsTalukaArea.updateTalukaArea(temp);
	}
	public static void deleteTalukaArea(clsTalukaArea temp)
	{
		dlsTalukaArea.deleteTalukaArea(temp);
	}

	public static void main(String args[])
	{
		clsTalukaArea Data[]=clsTalukaArea.getAllTalukaAreaInformation();

		for(clsTalukaArea temp : Data)
		{
			clsTalukaArea.showTalukaArea(temp);
		}
	}
}
