import java.util.*;

 public class dlsEmployee
 {
 	public static int addNewEmployee(clsEmployee temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";
 		int affected_rows = 0;

 		/*String Query = "insert into dbProjectData.tblEmployee" + SPACE +
 					   "(EmployeeName,Address,PinCode,AreaID,Age,Gender,ContactNO,EmailID,DesignationID,BillaNo,LicenceNo,Villagian) " +"Values ("
 					   	+ SQ + temp.getEmployeeName() + SQ + COMMA +SPACE
 					    + SQ + temp.getAddress() + SQ + COMMA+ SPACE
 					    + SQ + temp.getPinCode() + SQ +COMMA+ SPACE +
 					    String.valueOf(temp.getAreaID())+COMMA+SPACE
 					    +String.valueOf(temp.getAge())+SPACE+COMMA
 					    +String.valueOf(temp.getGender())+SPACE+COMMA
 					    + SQ + temp.getContactNo() + SQ +SPACE+COMMA
 					   + SQ + temp.geteMailID() + SQ +SPACE+COMMA
 					   +String.valueOf(temp.getDesignationID()) +SPACE+COMMA
 					   + SQ + temp.getBillaNo() + SQ +SPACE+COMMA
 					   + SQ + temp.getLicenseNo() + SQ +COMMA+SPACE+
 					   String.valueOf(temp.getVillagian())+
 					   ")" ;

 		*/
 		String Query = " INSERT INTO dbprojectdata.tblEmployee ( EmployeeName, Address, PinCode, AreaID, Age, Gender, ContactNo, EmailID, DesignationID, BillaNo, LicenceNo, Villagian) "+
					   " SELECT "+ SQ + temp.getEmployeeName() + SQ + COMMA +SPACE
 					    + SQ + temp.getAddress() + SQ + COMMA+ SPACE
 					    + SQ + temp.getPinCode() + SQ +COMMA+ SPACE +
 					    String.valueOf(temp.getAreaID())+COMMA+SPACE
 					    +String.valueOf(temp.getAge())+SPACE+COMMA
 					    +String.valueOf(temp.getGender())+SPACE+COMMA
 					    + SQ + temp.getContactNo() + SQ +SPACE+COMMA
 					    + SQ + temp.geteMailID() + SQ +SPACE+COMMA
 					    +String.valueOf(temp.getDesignationID()) +SPACE+COMMA
 					    + SQ + temp.getBillaNo() + SQ +SPACE+COMMA
 					    + SQ + temp.getLicenseNo() + SQ +COMMA+SPACE+
 					    String.valueOf(temp.getVillagian())+
					   " FROM DUAL "+
					   " WHERE NOT EXISTS ( "+
					       " SELECT 1 "+
					       " FROM dbprojectdata.tblEmployee E "+
					       " WHERE E.ContactNo="+ SQ + temp.getContactNo() + SQ +" OR E.EmailID="+ SQ + temp.geteMailID() + SQ +
					       " OR E.BillaNo= "+ SQ + temp.getBillaNo() + SQ +" OR E.LicenceNo="+ SQ + temp.getLicenseNo() + SQ +
					   " )";


 		affected_rows = QueryExecutor.processQuery(Query);
 		return affected_rows;

 	}
 	public static void updateEmployee(clsEmployee temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "update dbProjectData.tblEmployee set" + SPACE +
 					   "EmployeeName="+ SQ + temp.getEmployeeName() + SQ + SPACE +COMMA+
 					   "Address="+ SQ + temp.getAddress() + SQ  +SPACE +COMMA+
 					   "PinCode="+ SQ + temp.getPinCode() + SQ  +SPACE +COMMA+
					   "AreaID="+String.valueOf(temp.getAreaID())+SPACE+COMMA+
					   "Age="+String.valueOf(temp.getAge())+SPACE+COMMA+
					   "Gender="+String.valueOf(temp.getGender())+SPACE+COMMA+
					   "ContactNo="+ SQ + temp.getContactNo() + SQ +SPACE +COMMA+
					   "EMailID="+ SQ + temp.geteMailID() + SQ +SPACE +COMMA+
					   "DesignationID="+String.valueOf(temp.getDesignationID())+SPACE+COMMA+
					   "BillaNo="+ SQ + temp.getBillaNo()+ SQ + SPACE+COMMA+
 					   "LicenceNo="+ SQ + temp.getLicenseNo() + SQ +COMMA +
 					   "Villagian="+String.valueOf(temp.getVillagian())+SPACE+
 					   "where EmployeeID=" + String.valueOf(temp.getEmployeeID());

 		QueryExecutor.processQuery(Query);

 	}

 	public static void deleteEmployee(clsEmployee temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "delete from dbProjectData.tblEmployee where EmployeeID="+temp.getEmployeeID();

 		QueryExecutor.processQuery(Query);
 	}

 	public static int getIDFromName(String mEmployeeName)
 	{
 		String Query = "select EmployeeID from dbProjectData.tblEmployee where EmployeeName='"+mEmployeeName+"'";

 		return QueryExecutor.getIDFromName(Query);
 	}

 	public static String getNameFromID(int mEmployeeID)
 	{
 		String Query = "select EmployeeName from tblEmployee where EmployeeID="+String.valueOf(mEmployeeID);

 		return QueryExecutor.getNameFromID(Query);
 	}

 	public static String [] getAllEmployeeNames()
 	{
 		String Query = "select EmployeeName from dbProjectData.tblEmployee";
 		return(QueryExecutor.getSingleColumn(Query));
 	}

 	public static String [] getFreeDriverNames()
 	{
 		String Query = "select E.EmployeeName from dbProjectData.tblEmployee E "+
 						" LEFT JOIN dbProjectData.tblAllocation A ON E.EmployeeID = A.DriverID "+
 						" where A.DriverID IS NULL AND E.DesignationID = 18";
 		return(QueryExecutor.getSingleColumn(Query));
 	}

 	public static String [] getFreeDriverNames(int TodaysDay,int TodaysMonth,int TodaysYear)
 	{
 		/*String Query = "select E.EmployeeName from dbProjectData.tblEmployee E "+
 						" LEFT JOIN dbProjectData.tblAllocation A ON E.EmployeeID = A.DriverID "+
 						" where A.DriverID IS NULL AND E.DesignationID = 18";*/

		  String Query =" select E.EmployeeName "+
						" from dbProjectData.tblEmployee E "+
						" LEFT JOIN "+
						" (SELECT * "+
						" from dbProjectData.tblAllocation "+
						" where AllocationDayNo = "+String.valueOf(TodaysDay)+
						" AND AllocationMonthNo = "+String.valueOf(TodaysMonth)+
						" AND AllocationYearNo = "+String.valueOf(TodaysYear)+") A "+
						" ON E.EmployeeID = A.DriverID "+
						" where A.DriverID IS NULL AND E.DesignationID = 18";


 		return(QueryExecutor.getSingleColumn(Query));
 	}

  	public static String [] getFreeConductorNames()
  	{
  		String Query = "select E.EmployeeName from dbProjectData.tblEmployee E "+
  						" LEFT JOIN dbProjectData.tblAllocation A ON E.EmployeeID = A.ConductorID "+
  						" where A.ConductorID IS NULL AND E.DesignationID = 19";
  		return(QueryExecutor.getSingleColumn(Query));
 	}

  	public static String [] getFreeConductorNames(int TodaysDay,int TodaysMonth,int TodaysYear)
  	{
  		 /*"select E.EmployeeName from dbProjectData.tblEmployee E "+
  						" LEFT JOIN dbProjectData.tblAllocation A ON E.EmployeeID = A.ConductorID "+
  						" where A.ConductorID IS NULL AND E.DesignationID = 19";*/


  		  String Query =" select E.EmployeeName "+
						" from dbProjectData.tblEmployee E "+
						" LEFT JOIN "+
						" (SELECT * "+
						" from dbProjectData.tblAllocation "+
						" where AllocationDayNo = "+String.valueOf(TodaysDay)+
						" AND AllocationMonthNo = "+String.valueOf(TodaysMonth)+
						" AND AllocationYearNo = "+String.valueOf(TodaysYear)+") A "+
						" ON E.EmployeeID = A.ConductorID "+
						" where A.ConductorID IS NULL AND E.DesignationID = 19";

  		return(QueryExecutor.getSingleColumn(Query));
 	}

 	public static int getAllEmployeeCount()
 	{
 		String Query = "select count(EmployeeID) from dbProjectData.tblEmployee";
 		return(QueryExecutor.getRowsCount(Query));
 	}


 	public static clsEmployee getEmployeeInformation(int mEmployeeID)
 	{
 		String Query = "select * from tblEmployee where EmployeeID="+String.valueOf(mEmployeeID);

 		String data[] = QueryExecutor.getObjectInformation(Query,13);

 		clsEmployee temp = new clsEmployee();

 		temp.setEmployeeID(Integer.parseInt(data[0]));
 		temp.setEmployeeName(data[1]);
 		temp.setAddress(data[2]);
 		temp.setPinCode(data[3]);
 		temp.setAreaID(Integer.parseInt(data[4]));
 		temp.setAge(Integer.parseInt(data[5]));
 		temp.setGender(Integer.parseInt(data[6]));
 		temp.setContactNo(data[7]);
 		temp.seteMailID(data[8]);
 		temp.setDesignationID(Integer.parseInt(data[9]));
 		temp.setBillaNo(data[10]);
 		temp.setLicenseNo(data[11]);
  		temp.setVillagian(Integer.parseInt(data[12]));


 		return(temp);
 	}

 	public static clsEmployee [] getAllEmployeeInformation()
 	{
 		String Query = "select * from tblEmployee";

 		String data[][] = QueryExecutor.getAllObjectInformation(Query,13);
 		clsEmployee temp[] = new clsEmployee[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsEmployee();
 			temp[i].setEmployeeID(Integer.parseInt(data[i][0]));
 			temp[i].setEmployeeName(data[i][1]);
 			temp[i].setAddress(data[i][2]);
			temp[i].setPinCode(data[i][3]);
			temp[i].setAreaID(Integer.parseInt(data[i][4]));
			temp[i].setAge(Integer.parseInt(data[i][5]));
			temp[i].setGender(Integer.parseInt(data[i][6]));
			temp[i].setContactNo(data[i][7]);
			temp[i].seteMailID(data[i][8]);
			temp[i].setDesignationID(Integer.parseInt(data[i][9]));
			temp[i].setBillaNo(data[i][10]);
 			temp[i].setLicenseNo(data[i][11]);
			temp[i].setVillagian(Integer.parseInt(data[i][12]));

		}
 		return(temp);
 	}

	public static clsEmployeeReport [] getAllEmployeeReportInformation()
	{
		String Query = "SELECT "+
						" E.EmployeeID, "+
						" E.EmployeeName, "+
						" E.Address, "+
						" E.PinCode, "+
						" E.AreaID, "+
						" TA.TalukaAreaName, "+
						" E.Age, "+
						" E.Gender, "+
						" E.ContactNo, "+
						" E.EmailID, "+
						" E.DesignationID, "+
						" D.DesignationName, "+
						" E.BillaNo, "+
						" E.LicenceNo, "+
						" E.Villagian "+
						" FROM dbProjectData.tblEmployee E "+
						" JOIN dbProjectData.tblTalukaArea TA ON E.AreaID = TA.TalukaAreaID "+
						" JOIN dbProjectData.tblDesignation D ON E.DesignationID = D.DesignationID";

		String data[][] = QueryExecutor.getAllObjectInformation(Query,15);
		clsEmployeeReport temp[] = new clsEmployeeReport[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsEmployeeReport();
			temp[i].setEmployeeID(Integer.parseInt(data[i][0]));
			temp[i].setEmployeeName(data[i][1]);
			temp[i].setAddress(data[i][2]);
			temp[i].setPinCode(data[i][3]);
			temp[i].setAreaID(Integer.parseInt(data[i][4]));
			temp[i].setAreaName(data[i][5]);
			temp[i].setAge(Integer.parseInt(data[i][6]));
			temp[i].setGender(Integer.parseInt(data[i][7]));
			temp[i].setContactNo(data[i][8]);
			temp[i].setEmailID(data[i][9]);
			temp[i].setDesignationID(Integer.parseInt(data[i][10]));
			temp[i].setDesignationName(data[i][11]);
			temp[i].setBillaNo(data[i][12]);
			temp[i].setLicenseNo(data[i][13]);
			temp[i].setVillagian(Integer.parseInt(data[i][14]));
		}
		return(temp);
 	}

 	public static clsEmployeeReport getEmployeeReportInformation(int EmployeeID)
 	{
 		String Query = "SELECT "+
 						" E.EmployeeID, "+
 						" E.EmployeeName, "+
 						" E.Address, "+
 						" E.PinCode, "+
 						" E.AreaID, "+
 						" TA.TalukaAreaName, "+
 						" E.Age, "+
 						" E.Gender, "+
 						" E.ContactNo, "+
 						" E.EmailID, "+
 						" E.DesignationID, "+
 						" D.DesignationName, "+
 						" E.BillaNo, "+
 						" E.LicenceNo, "+
 						" E.Villagian "+
 						" FROM dbProjectData.tblEmployee E "+
 						" JOIN dbProjectData.tblTalukaArea TA ON E.AreaID = TA.TalukaAreaID"+
 						" JOIN dbProjectData.tblDesignation D ON E.DesignationID = D.DesignationID "+
 						" WHERE EmployeeID = "+String.valueOf(EmployeeID);

 		String data[] = QueryExecutor.getObjectInformation(Query,15);
 		clsEmployeeReport temp = new clsEmployeeReport();

		temp.setEmployeeID(Integer.parseInt(data[0]));
		temp.setEmployeeName(data[1]);
		temp.setAddress(data[2]);
		temp.setPinCode(data[3]);
		temp.setAreaID(Integer.parseInt(data[4]));
		temp.setAreaName(data[5]);
		temp.setAge(Integer.parseInt(data[6]));
		temp.setGender(Integer.parseInt(data[7]));
		temp.setContactNo(data[8]);
		temp.setEmailID(data[9]);
		temp.setDesignationID(Integer.parseInt(data[10]));
		temp.setDesignationName(data[11]);
		temp.setBillaNo(data[12]);
		temp.setLicenseNo(data[13]);
		temp.setVillagian(Integer.parseInt(data[14]));
 		return(temp);
  	}

}