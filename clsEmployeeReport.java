import javax.swing.*;

public class clsEmployeeReport
{
    private int EmployeeID ;
    private String EmployeeName ;
    private String Address;
    private String PinCode;
    private int AreaID;
    private String AreaName;
    private int Age;
    private int Gender;
    private String ContactNo;
    private String EmailID;
    private int DesignationID;
    private String DesignationName;
    private String BillaNo;
    private String LicenseNo;
    private int villagian;

    public void setEmployeeID(int EmployeeID)
    {
        this.EmployeeID = EmployeeID;
    }
    public int getEmployeeID()
    {
        return EmployeeID;
    }

    public void setEmployeeName(String EmployeeName)
    {
        this.EmployeeName = EmployeeName;
    }
    public String getEmployeeName()
    {
        return EmployeeName;
    }
    public void setAddress(String Address)
    {
		this.Address = Address;
	}
	public String getAddress()
	{
		return Address;
	}
 	public void setPinCode(String PinCode)
	{
		this.PinCode = PinCode;
	}
	public String getPinCode()
	{
		return PinCode;
	}
	public void setAreaID(int AreaID)
	{
		this.AreaID = AreaID;
	}
	public int getAreaID()
	{
		return AreaID;
	}
	public void setAge(int Age)
	{
		this.Age = Age;
	}
	public int getAge()
	{
		return Age;
	}
	public void setGender(int Gender)
	{
		this.Gender = Gender;
	}
	public int getGender()
	{
		return Gender;
	}
	public String getGenderText()
	{
		String text = "Male";

		if(Gender==0)
		{
			text= "Female";
		}
		return text;
	}

	public void setContactNo(String ContactNo)
    {
        this.ContactNo = ContactNo;
    }
    public String getContactNo()
    {
        return ContactNo;
    }
    public void setEmailID(String EmailID)
    {
        this.EmailID = EmailID;
    }
    public String getEmailID()
    {
        return EmailID;
    }
    public void setDesignationID(int DesignationID)
	{
		this.DesignationID = DesignationID;
	}
	public int getDesignationID()
	{
		return DesignationID;
	}
   	public void setBillaNo(String BillaNo)
	{
		this.BillaNo = BillaNo;
	}
	public String getBillaNo()
	{
		return BillaNo;
    }
    public void setLicenseNo(String LicenseNo)
    {
		this.LicenseNo = LicenseNo;
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
	public String getVillagianText()
	{
		String text = "Yes";

		if(villagian==1)
		{
			text= "No";
		}
		return text;
	}
	public void setDesignationName(String DesignationName)
	{
		this.DesignationName = DesignationName;
	}
	public String getDesignationName()
	{
		return DesignationName;
	}
	public void setAreaName(String AreaName)
	{
		this.AreaName = AreaName;
	}
	public String getAreaName()
	{
		return AreaName;
	}

	public static clsEmployeeReport getEmployeeReportInformation(int mEmployeeID)
	{
		return(dlsEmployee.getEmployeeReportInformation(mEmployeeID));
	}

	public static clsEmployeeReport[] getAllEmployeeReportInformation()
	{
		return(dlsEmployee.getAllEmployeeReportInformation());
	}

	public static void showEmployeeReport(clsEmployeeReport temp)
	{
		System.out.println("Employee ID   : "+temp.getEmployeeID());
		System.out.println("Name : "+temp.getEmployeeName());
		System.out.println("Address   : "+temp.getAddress());
		System.out.println("PinCode   : "+temp.getPinCode());
		System.out.println("Area Name : "+temp.getAreaName());
		System.out.println("Age   : "+temp.getAge());
		System.out.println("Gender   : "+temp.getGenderText());
		System.out.println("ContactNumber   : "+temp.getContactNo());
		System.out.println("eMailID   : "+temp.getEmailID());
		System.out.println("Designation Name  : "+temp.getDesignationName());
		System.out.println("BillaNumber   : "+temp.getBillaNo());
		System.out.println("LicenseNumber   : "+temp.getLicenseNo());
		System.out.println("Villagian (Yes/No):"+temp.getVillagianText());

    }

	public static void main(String args[])
	{
		clsEmployeeReport temp= clsEmployeeReport.getEmployeeReportInformation(6);
		clsEmployeeReport.showEmployeeReport(temp);
	}
}

