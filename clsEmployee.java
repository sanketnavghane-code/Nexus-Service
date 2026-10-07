import javax.swing.*;

public class clsEmployee
{
    private int EmployeeID ;
    private String EmployeeName ;
    private String Address;
    private String PinCode;
    private int mAreaID;
    private int age;
    private int gender;
    private String ContactNo;
    private String eMailID;
    private int mDesignationID;
    private String mDesignationName;
    private String mAreaName;
    private String BillaNo;
    private String LicenseNo;
    private int villagian;

    public void setEmployeeID(int mEmployeeID)
    {
        this.EmployeeID = mEmployeeID;
    }
    public int getEmployeeID()
    {
        return EmployeeID;
    }

    public void setEmployeeName(String mEmployeeName)
    {
        this.EmployeeName = mEmployeeName;
    }
    public String getEmployeeName()
    {
        return EmployeeName;
    }
    public void setAddress(String mAddress)
    {
		this.Address = mAddress;
	}
	public String getAddress()
	{
		return Address;
	}
 	public void setPinCode(String mPinCode)
	{
		this.PinCode = mPinCode;
	}
	public String getPinCode()
	{
		return PinCode;
	}
	public void setAreaID(int mAreaID)
	{
		this.mAreaID = mAreaID;
	}
	public int getAreaID()
	{
		return mAreaID;
	}
	public void setAge(int mage)
	{
		this.age = mage;
	}
	public int getAge()
	{
		return age;
	}
	public void setGender(int mgender)
	{
		this.gender = mgender;
	}
	public int getGender()
	{
		return gender;
	}
	public String getGenderText()
	{
		String text = "Male";

		if(gender==0)
		{
			text= "Female";
		}
		return text;
	}

	public void setContactNo(String mContactNo)
    {
        this.ContactNo = mContactNo;
    }
    public String getContactNo()
    {
        return ContactNo;
    }
    public void seteMailID(String meMailID)
    {
        this.eMailID = meMailID;
    }
    public String geteMailID()
    {
        return eMailID;
    }
    public void setDesignationID(int mDesignationID)
	{
		this.mDesignationID = mDesignationID;
	}
	public int getDesignationID()
	{
		return mDesignationID;
	}
   	public void setBillaNo(String mBillaNo)
	{
		this.BillaNo = mBillaNo;
	}
	public String getBillaNo()
	{
		return BillaNo;
    }
    public void setLicenseNo(String mLicenseNo)
    {
		this.LicenseNo = mLicenseNo;
	}
	public String getLicenseNo()
	{
		return LicenseNo;
	}

	public void setVillagian(int mvillagian)
	{
		this.villagian = mvillagian;
	}
	public int getVillagian()
	{
		return villagian;
	}

	public void setmDesignationName(String mDesignationName)
	{
		this.mDesignationName = mDesignationName;
	}
	public String getmDesignationName()
	{
		return mDesignationName;
	}
	public void setmAreaName(String mAreaName)
	{
		this.mAreaName = mAreaName;
	}
	public String getmAreaName()
	{
		return mAreaName;
	}
/*	public static boolean isEmployeeDulplicate(temp.getEmployeeName())
	{

	}
*/
	public static int  addNewEmployee(clsEmployee temp)
	{
		return (dlsEmployee.addNewEmployee(temp));
	}


	public static void updateEmployee(clsEmployee temp)
	{
		dlsEmployee.updateEmployee(temp);
	}

	public static void deleteEmployee(clsEmployee temp)
	{
		dlsEmployee.deleteEmployee(temp);
	}

	public static int getAllEmployeeCount()
	{
		return(dlsEmployee.getAllEmployeeCount());
	}

	public static String[] getAllEmployeeNames()
	{
		return(dlsEmployee.getAllEmployeeNames());
	}

	public static String[] getFreeDriverNames(int TodaysDay,int TodaysMonth,int TodaysYear)
	{
		return(dlsEmployee.getFreeDriverNames(TodaysDay, TodaysMonth, TodaysYear));
	}

	public static String[] getFreeConductorNames(int TodaysDay,int TodaysMonth,int TodaysYear)
	{
		return(dlsEmployee.getFreeConductorNames(TodaysDay, TodaysMonth, TodaysYear));
	}

	public static clsEmployee getEmployeeInformation(int mEmployee)
	{
		return(dlsEmployee.getEmployeeInformation(mEmployee));
	}

	public static clsEmployee[] getAllEmployeeInformation()
	{
		return(dlsEmployee.getAllEmployeeInformation());
	}


	public static void addEmployeeRecords(JComboBox temp)
	{
		temp.removeAllItems();
		temp.addItem("--Select Employee--");
		String EmployeeNames [] = clsEmployee.getAllEmployeeNames();
		for(String name : EmployeeNames)
		{
			temp.addItem(name);
		}
	}

	public static void addFreeDriverRecords(JComboBox temp,int TodaysDay,int TodaysMonth,int TodaysYear)
	{
		temp.removeAllItems();
		temp.addItem("--Select Employee--");
		String EmployeeNames [] = clsEmployee.getFreeDriverNames(TodaysDay, TodaysMonth, TodaysYear);
		for(String name : EmployeeNames)
		{
			temp.addItem(name);
		}
	}

	public static void addFreeConductorRecords(JComboBox temp,int TodaysDay,int TodaysMonth,int TodaysYear)
	{
		temp.removeAllItems();
		temp.addItem("--Select Employee--");
		String EmployeeNames [] = clsEmployee.getFreeConductorNames( TodaysDay, TodaysMonth, TodaysYear);
		for(String name : EmployeeNames)
		{
			temp.addItem(name);
		}
	}

	public static int getIDFromName(String mEmployeeName)
	{
		return dlsEmployee.getIDFromName(mEmployeeName);
	}

	public static void showEmployee(clsEmployee temp)
	{
		System.out.println("Employee ID   : "+temp.getEmployeeID());
		System.out.println("Name : "+temp.getEmployeeName());
		System.out.println("Address   : "+temp.getAddress());
		System.out.println("PinCode   : "+temp.getPinCode());
		System.out.println("Area  : "+temp.getAreaID());
		System.out.println("Age   : "+temp.getAge());
		System.out.println("Gender   : "+temp.getGender());
		System.out.println("ContactNumber   : "+temp.getContactNo());
		System.out.println("eMailID   : "+temp.geteMailID());
		System.out.println("Designation   : "+temp.getDesignationID());
		System.out.println("BillaNumber   : "+temp.getBillaNo());
		System.out.println("LicenseNumber   : "+temp.getLicenseNo());
		System.out.println("Villagian:"+temp.getVillagian());

    }

	public static void main(String args[])
	{
		String temp[] = clsEmployee.getFreeDriverNames(22,2,2025);
		for(String name : temp )
		{
			System.out.println(name);
		}
	}
}

