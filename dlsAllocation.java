import java.util.*;

 public class dlsAllocation
 {
 	public static void addNewAllocation(clsAllocation temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "insert into dbProjectData.tblAllocation" + SPACE +
 					   "(RootID, DriverID, ConductorID, VehicleID, AllocationDayNo, AllocationMonthNo, AllocationYearNo) " +"Values ("
 					   	+temp.getRootID()+COMMA+ SPACE
 					    +temp.getDriverID()+COMMA+ SPACE
 					    +temp.getConductorID()+COMMA+ SPACE
 					    +temp.getVehicleID()+COMMA+ SPACE
 					    +temp.getAllocationDayNo()+COMMA+ SPACE
 					    +temp.getAllocationMonthNo()+COMMA+ SPACE
 					    +temp.getAllocationYearNo()+")" ;


 		/*String Query = " INSERT INTO dbProjectData.tblAllocation "+
 					   "(RootID, DriverID, ConductorID, VehicleID, AllocationDayNo, AllocationMonthNo, AllocationYearNo) "+
					   " SELECT "
						+temp.getRootID()+COMMA+ SPACE
 					    +temp.getDriverID()+COMMA+ SPACE
 					    +temp.getConductorID()+COMMA+ SPACE
 					    +temp.getVehicleID()+COMMA+ SPACE
 					    +temp.getAllocationDayNo()+COMMA+ SPACE
 					    +temp.getAllocationMonthNo()+COMMA+ SPACE
 					    +temp.getAllocationYearNo()+
 					    " FROM DUAL "+
					    " WHERE NOT EXISTS ( "+
					       " SELECT 1 "+
					       " FROM dbProjectData.tblAllocation A "+
					       " WHERE A.RootID="+ SQ + temp.getRootID() + SQ +" AND E.EmailID="+ SQ + temp.geteMailID() + SQ +
					       " OR E.BillaNo= "+ SQ + temp.getBillaNo() + SQ +" OR E.LicenceNo="+ SQ + temp.getLicenseNo() + SQ +
					   " )";*/

 		QueryExecutor.processQuery(Query);

 	}
 	public static void updateAllocation(clsAllocation temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "update dbProjectData.tblAllocation set" + SPACE +
 					   " RootID="+temp.getRootID()+ COMMA+ SPACE+
 					   " DriverID="+temp.getDriverID()+SPACE+COMMA+
 					   " ConductorID="+temp.getConductorID()+SPACE+COMMA+
 					   " AllocationDayNo="+temp.getAllocationDayNo()+SPACE+COMMA+
 					   " AllocationMonthNo="+temp.getAllocationMonthNo()+SPACE+COMMA+
 					   " AllocationYearNo="+temp.getAllocationYearNo()+
 					   " where AllocationID=" + String.valueOf(temp.getAllocationID());

 		QueryExecutor.processQuery(Query);

 	}

 	public static void deleteAllocation(clsAllocation temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "delete from dbProjectData.tblAllocation where AllocationID="+temp.getAllocationID();

 		QueryExecutor.processQuery(Query);
 	}

 	public static int getIDFromName(String mAllocationName)
 	{
 		String Query = "select AllocationID from dbProjectData.tblAllocation where AllocationName='"+mAllocationName+"'";

 		return QueryExecutor.getIDFromName(Query);
 	}

 	public static String getNameFromID(int mAllocationID)
 	{
 		String Query = "select AllocationName from tblAllocation where AllocationID="+String.valueOf(mAllocationID);

 		return QueryExecutor.getNameFromID(Query);
 	}

 	public static String [] getAllAllocationNames()
 	{
 		String Query = "select AllocationName from dbProjectData.tblAllocation";
 		return(QueryExecutor.getSingleColumn(Query));
 	}

 	public static int getAllAllocationCount()
 	{
 		String Query = "select count(AllocationID) from dbProjectData.tblAllocation";
 		return(QueryExecutor.getRowsCount(Query));
 	}

	public static boolean isRootBusy(clsAllocation temp)
	{
		boolean flag = false;
 		String Query = "select count(AllocationID) from dbProjectData.tblAllocation "+
 					" where RootID = "+String.valueOf(temp.getRootID())+" OR "+
 					" (DriverID = "+String.valueOf(temp.getDriverID())+" OR "+
 					" ConductorID = "+String.valueOf(temp.getConductorID())+") OR "+
 					" (AllocationDayNo = "+String.valueOf(temp.getAllocationDayNo())+" AND "+
 					" AllocationMonthNo = "+String.valueOf(temp.getAllocationMonthNo())+" And "+
 					" AllocationYearNo = "+String.valueOf(temp.getAllocationYearNo())+")";


		int status = QueryExecutor.getRowsCount(Query);

		if(status > 0)
		{
			flag = true;
		}

		return(flag);
	}

 	public static clsAllocation getAllocationInformation(int mAllocationID)
 	{
 		String Query = "select * from tblAllocation where AllocationID="+String.valueOf(mAllocationID);

 		String data[] = QueryExecutor.getObjectInformation(Query,8);

 		clsAllocation temp = new clsAllocation();

		temp.setAllocationID(Integer.parseInt(data[0]));
		temp.setRootID(Integer.parseInt(data[1]));
		temp.setDriverID(Integer.parseInt(data[2]));
		temp.setConductorID(Integer.parseInt(data[3]));
		temp.setVehicleID(Integer.parseInt(data[4]));
		temp.setAllocationDayNo(Integer.parseInt(data[5]));
		temp.setAllocationMonthNo(Integer.parseInt(data[6]));
		temp.setAllocationYearNo(Integer.parseInt(data[7]));
		return(temp);
 	}

 	public static clsAllocation [] getAllAllocationInformation()
 	{
 		String Query = "select * from dbProjectData.tblAllocation";

 		String data[][] = QueryExecutor.getAllObjectInformation(Query,8);
 		clsAllocation temp[] = new clsAllocation[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsAllocation();
 			temp[i].setAllocationID(Integer.parseInt(data[i][0]));
 			temp[i].setRootID(Integer.parseInt(data[i][1]));
			temp[i].setDriverID(Integer.parseInt(data[i][2]));
			temp[i].setConductorID(Integer.parseInt(data[i][3]));
			temp[i].setVehicleID(Integer.parseInt(data[i][4]));
			temp[i].setAllocationDayNo(Integer.parseInt(data[i][5]));
			temp[i].setAllocationMonthNo(Integer.parseInt(data[i][6]));
			temp[i].setAllocationYearNo(Integer.parseInt(data[i][7]));
		}
 		return(temp);
 	}


 	public static clsAllocationReport [] getAllAllocationReportInformation()
 	{
 		String Query = "select "+
 					   " A.AllocationID, "+
 					   " A.AllocationDayNo, "+
 					   " A.AllocationMonthNo, "+
 					   " A.AllocationYearNo, "+
 					   " A.RootID, "+
 					   " A.DriverID, "+
  					   " A.ConductorID, "+
 					   " V.VehicleID, "+
 					   " V.VehicleName, "+
 					   " R.RootName, "+
 					   " ED.EmployeeName, "+
 					   " ED.ContactNo, "+
 					   " EC.EmployeeName, "+
 					   " EC.ContactNo, "+
 					   " ED.BillaNo, "+
 					   " ED.LicenceNo, "+
 					   " EC.BillaNo, "+
 					   " EC.LicenceNo, "+
 					   " ED.DesignationID, "+
  					   " D.DesignationName, "+
 					   " V.VehicleTypeID, "+
 					   " VT.VehicleTypeName "+
 					   " FROM "+
 					   " dbProjectData.tblAllocation A "+
 					   " JOIN dbProjectData.tblRoot R on A.RootID = R.RootID "+
 					   " JOIN dbProjectData.tblEmployee ED on A.DriverID=ED.EmployeeID "+
 					   " JOIN dbProjectData.tblEmployee EC on A.ConductorID=EC.EmployeeID "+
 					   " JOIN dbProjectData.tblVehicle v on A.VehicleID = v.VehicleID "+
 					   " JOIN dbProjectData.tblVehicleType VT on v.VehicleTypeID=VT.VehicleTypeID "+
 					   " JOIN dbProjectData.tblDesignation d on ED.DesignationID=d.DesignationID ";

 		String data[][] = QueryExecutor.getAllObjectInformation(Query,22);
 		clsAllocationReport temp[] = new clsAllocationReport[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsAllocationReport();
 			temp[i].setAllocationID(Integer.parseInt(data[i][0]));
 			temp[i].setAllocationDayNo(Integer.parseInt(data[i][1]));
 			temp[i].setAllocationMonthNo(Integer.parseInt(data[i][2]));
 			temp[i].setAllocationYearNo(Integer.parseInt(data[i][3]));
			temp[i].setRootID(Integer.parseInt(data[i][4]));
			temp[i].setDriverID(Integer.parseInt(data[i][5]));
			temp[i].setConductorID(Integer.parseInt(data[i][6]));
			temp[i].setVehicleID(Integer.parseInt(data[i][7]));
			temp[i].setVehicleName(data[i][8]);
			temp[i].setRootName(data[i][9]);
			temp[i].setDriverName(data[i][10]);
			temp[i].setDriverContactNo(data[i][11]);
			temp[i].setConductorName(data[i][12]);
			temp[i].setConductorContactNo(data[i][13]);
			temp[i].setConductorBillaNo(data[i][14]);
			temp[i].setConductorLicenseNo(data[i][15]);
			temp[i].setDriverBillaNo(data[i][16]);
			temp[i].setDriverLicenseNo(data[i][17]);
			temp[i].setDesignationID(Integer.parseInt(data[i][18]));
			temp[i].setDesignationName(data[i][19]);
			temp[i].setVehicleTypeID(Integer.parseInt(data[i][20]));
			temp[i].setVehicleTypeName(data[i][21]);
		}
 		return(temp);
 	}


 	public static clsAllocationReport getAllocationReportInformation(int AllocationID)
 	{
 		String Query = "select "+
 					   " A.AllocationID, "+
 					   " A.AllocationDayNo, "+
 					   " A.AllocationMonthNo, "+
 					   " A.AllocationYearNo, "+
 					   " A.RootID, "+
 					   " A.DriverID, "+
  					   " A.ConductorID, "+
 					   " V.VehicleID, "+
 					   " V.VehicleName, "+
 					   " R.RootName, "+
 					   " ED.EmployeeName, "+
 					   " ED.ContactNo, "+
 					   " EC.EmployeeName, "+
 					   " EC.ContactNo, "+
 					   " ED.BillaNo, "+
 					   " ED.LicenceNo, "+
 					   " EC.BillaNo, "+
 					   " EC.LicenceNo, "+
 					   " ED.DesignationID, "+
  					   " D.DesignationName, "+
 					   " V.VehicleTypeID, "+
 					   " VT.VehicleTypeName "+
 					   " FROM "+
 					   " dbProjectData.tblAllocation A "+
 					   " JOIN dbProjectData.tblRoot R on A.RootID = R.RootID "+
 					   " JOIN dbProjectData.tblEmployee ED on A.DriverID=ED.EmployeeID "+
 					   " JOIN dbProjectData.tblEmployee EC on A.ConductorID=EC.EmployeeID "+
 					   " JOIN dbProjectData.tblVehicle v on A.VehicleID = v.VehicleID "+
 					   " JOIN dbProjectData.tblVehicleType VT on v.VehicleTypeID=VT.VehicleTypeID "+
 					   " JOIN dbProjectData.tblDesignation d on ED.DesignationID=d.DesignationID "+
 					   " WHERE A.AllocationID = "+String.valueOf(AllocationID);

 		String data[] = QueryExecutor.getObjectInformation(Query,22);
 		clsAllocationReport temp = new clsAllocationReport();

		for(int i=0;i<data.length;i++)
		{
 			temp.setAllocationID(Integer.parseInt(data[0]));
 			temp.setAllocationDayNo(Integer.parseInt(data[1]));
 			temp.setAllocationMonthNo(Integer.parseInt(data[2]));
 			temp.setAllocationYearNo(Integer.parseInt(data[3]));
			temp.setRootID(Integer.parseInt(data[4]));
			temp.setDriverID(Integer.parseInt(data[5]));
			temp.setConductorID(Integer.parseInt(data[6]));
			temp.setVehicleID(Integer.parseInt(data[7]));
			temp.setVehicleName(data[8]);
			temp.setRootName(data[9]);
			temp.setDriverName(data[10]);
			temp.setDriverContactNo(data[11]);
			temp.setConductorName(data[12]);
			temp.setConductorContactNo(data[13]);
			temp.setConductorBillaNo(data[14]);
			temp.setConductorLicenseNo(data[15]);
			temp.setDriverBillaNo(data[16]);
			temp.setDriverLicenseNo(data[17]);
			temp.setDesignationID(Integer.parseInt(data[18]));
			temp.setDesignationName(data[19]);
			temp.setVehicleTypeID(Integer.parseInt(data[20]));
			temp.setVehicleTypeName(data[21]);
		}
 		return(temp);
 	}


 	public static clsAllocationReport[] getAllocationReportInformation(int Day, int Month, int Year)
 	{
 		String Query = "select "+
 					   " A.AllocationID, "+
 					   " A.AllocationDayNo, "+
 					   " A.AllocationMonthNo, "+
 					   " A.AllocationYearNo, "+
 					   " A.RootID, "+
 					   " A.DriverID, "+
  					   " A.ConductorID, "+
 					   " V.VehicleID, "+
 					   " V.VehicleName, "+
 					   " R.RootName, "+
 					   " ED.EmployeeName, "+
 					   " ED.ContactNo, "+
 					   " EC.EmployeeName, "+
 					   " EC.ContactNo, "+
 					   " ED.BillaNo, "+
 					   " ED.LicenceNo, "+
 					   " EC.BillaNo, "+
 					   " EC.LicenceNo, "+
 					   " ED.DesignationID, "+
  					   " D.DesignationName, "+
 					   " V.VehicleTypeID, "+
 					   " VT.VehicleTypeName "+
 					   " FROM "+
 					   " dbProjectData.tblAllocation A "+
 					   " JOIN dbProjectData.tblRoot R on A.RootID = R.RootID "+
 					   " JOIN dbProjectData.tblEmployee ED on A.DriverID=ED.EmployeeID "+
 					   " JOIN dbProjectData.tblEmployee EC on A.ConductorID=EC.EmployeeID "+
 					   " JOIN dbProjectData.tblVehicle v on A.VehicleID = v.VehicleID "+
 					   " JOIN dbProjectData.tblVehicleType VT on v.VehicleTypeID=VT.VehicleTypeID "+
 					   " JOIN dbProjectData.tblDesignation d on ED.DesignationID=d.DesignationID "+
 					   " WHERE A.AllocationDayNo = "+String.valueOf(Day)+" AND "+
 					   		 " A.AllocationMonthNo = "+String.valueOf(Month)+" AND "+
 					   		 " A.AllocationYearNo = "+String.valueOf(Year);

 		String data[][] = QueryExecutor.getAllObjectInformation(Query,22);
 		clsAllocationReport temp[] = new clsAllocationReport[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsAllocationReport();
 			temp[i].setAllocationID(Integer.parseInt(data[i][0]));
 			temp[i].setAllocationDayNo(Integer.parseInt(data[i][1]));
 			temp[i].setAllocationMonthNo(Integer.parseInt(data[i][2]));
 			temp[i].setAllocationYearNo(Integer.parseInt(data[i][3]));
			temp[i].setRootID(Integer.parseInt(data[i][4]));
			temp[i].setDriverID(Integer.parseInt(data[i][5]));
			temp[i].setConductorID(Integer.parseInt(data[i][6]));
			temp[i].setVehicleID(Integer.parseInt(data[i][7]));
			temp[i].setVehicleName(data[i][8]);
			temp[i].setRootName(data[i][9]);
			temp[i].setDriverName(data[i][10]);
			temp[i].setDriverContactNo(data[i][11]);
			temp[i].setConductorName(data[i][12]);
			temp[i].setConductorContactNo(data[i][13]);
			temp[i].setConductorBillaNo(data[i][14]);
			temp[i].setConductorLicenseNo(data[i][15]);
			temp[i].setDriverBillaNo(data[i][16]);
			temp[i].setDriverLicenseNo(data[i][17]);
			temp[i].setDesignationID(Integer.parseInt(data[i][18]));
			temp[i].setDesignationName(data[i][19]);
			temp[i].setVehicleTypeID(Integer.parseInt(data[i][20]));
			temp[i].setVehicleTypeName(data[i][21]);
		}
 		return(temp);
 	}

}