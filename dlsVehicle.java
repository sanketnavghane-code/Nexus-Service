
import java.util.*;

 public class dlsVehicle
 {
 	public static int addNewVehicle(clsVehicle temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";
 		int Affected_Row = 0;

 		/*String Query = "insert into dbProjectData.tblVehicle" + SPACE +
 					   "(VehicleName,VehicleTypeID,ChessisNo,InwardYear) " +"Values ("
 					   	+ SQ + temp.getVehicleName() + SQ + COMMA +SPACE +
 					    String.valueOf(temp.getVehicleTypeID())+COMMA+SPACE +
 					    SQ + temp.getChessisNo() + SQ +SPACE+COMMA+
 					    String.valueOf(temp.getInwardYear())+
 					   ")" ;
 		*/


 		String Query =" INSERT INTO dbprojectdata.tblVehicle ( VehicleName,VehicleTypeID,ChessisNo,InwardYear) "+
					  " SELECT "+ SQ + temp.getVehicleName() + SQ + COMMA +SPACE +
								  String.valueOf(temp.getVehicleTypeID())+COMMA+SPACE +
								  SQ + temp.getChessisNo() + SQ +SPACE+COMMA+
 					    		  String.valueOf(temp.getInwardYear())+
					  " FROM DUAL "+
					  " WHERE NOT EXISTS ( "+
					      " SELECT 1 "+
					      " FROM dbprojectdata.tblVehicle V "+
					      " WHERE  V.VehicleName = "+ SQ + temp.getVehicleName() + SQ +" OR "+
					      		 " V.ChessisNo = "+SQ + temp.getChessisNo() + SQ +")";


 		Affected_Row = QueryExecutor.processQuery(Query);
 		return Affected_Row;

 	}
 	public static void updateVehicle(clsVehicle temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "update dbProjectData.tblVehicle set" + SPACE +
 					   "VehicleName="+ SQ + temp.getVehicleName() + SQ + SPACE +COMMA+
 					   "VehicleTypeID="+ String.valueOf(temp.getVehicleTypeID())+SPACE +COMMA+
 					   "ChessisNo="+ SQ + temp.getChessisNo() + SQ  +SPACE +COMMA+
					   "InwardYear="+String.valueOf(temp.getInwardYear())+SPACE+
 					   "where VehicleID=" + String.valueOf(temp.getVehicleID());

 		QueryExecutor.processQuery(Query);

 	}

 	public static void deleteVehicle(clsVehicle temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "delete from dbProjectData.tblVehicle where VehicleID="+temp.getVehicleID();

 		QueryExecutor.processQuery(Query);
 	}

 	public static int getIDFromName(String mVehicleName)
 	{
 		String Query = "select VehicleID from dbProjectData.tblVehicle where VehicleName='"+mVehicleName+"'";

 		return QueryExecutor.getIDFromName(Query);
 	}

 	public static String getNameFromID(int mVehicleID)
 	{
 		String Query = "select VehicleName from tblVehicle where VehicleID="+String.valueOf(mVehicleID);

 		return QueryExecutor.getNameFromID(Query);
 	}

 	public static String [] getAllVehicleNames()
 	{
 		String Query = "select VehicleName from dbProjectData.tblVehicle";
 		return(QueryExecutor.getSingleColumn(Query));
 	}

  	public static String [] addFreeVehicleRecords()
  	{
  		String Query = "select V.VehicleName from dbProjectData.tblVehicle V "+
 						" LEFT JOIN dbProjectData.tblAllocation A ON V.VehicleID = A.VehicleID "+
 						" where A.VehicleID IS NULL";
  		return(QueryExecutor.getSingleColumn(Query));
 	}

  	public static String [] addFreeVehicleRecords(int TodaysDay,int TodaysMonth,int TodaysYear)
  	{
  		/*String Query = "select V.VehicleName from dbProjectData.tblVehicle V "+
 						" LEFT JOIN dbProjectData.tblAllocation A ON V.VehicleID = A.VehicleID "+
 						" where A.VehicleID IS NULL";*/

		  String Query =" select V.VehicleName "+
						" from dbProjectData.tblVehicle V "+
						" LEFT JOIN "+
						" (SELECT * "+
						" from dbProjectData.tblAllocation "+
						" where AllocationDayNo = "+String.valueOf(TodaysDay)+
						" AND AllocationMonthNo = "+String.valueOf(TodaysMonth)+
						" AND AllocationYearNo = "+String.valueOf(TodaysYear)+") A "+
						" ON V.VehicleID = A.VehicleID "+
						" where A.VehicleID IS NULL";


  		return(QueryExecutor.getSingleColumn(Query));
 	}

 	public static int getAllVehicleCount()
 	{
 		String Query = "select count(VehicleID) from dbProjectData.tblVehicle";
 		return(QueryExecutor.getRowsCount(Query));
 	}


 	public static clsVehicle getVehicleInformation(int mVehicleID)
 	{
 		String Query = "select * from tblVehicle where VehicleID="+String.valueOf(mVehicleID);

 		String data[] = QueryExecutor.getObjectInformation(Query,5);

 		clsVehicle temp = new clsVehicle();

 		temp.setVehicleID(Integer.parseInt(data[0]));
 		temp.setVehicleName(data[1]);
 		temp.setVehicleTypeID(Integer.parseInt(data[2]));
 		temp.setChessisNo(data[3]);
 		temp.setInwardYear(Integer.parseInt(data[4]));

 		return(temp);
 	}

 	public static clsVehicle [] getAllVehicleInformation()
 	{

 		String Query = "select * from tblVehicle";

 		String data[][] = QueryExecutor.getAllObjectInformation(Query,5);
 		clsVehicle temp[] = new clsVehicle[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsVehicle();
 			temp[i].setVehicleID(Integer.parseInt(data[i][0]));
 			temp[i].setVehicleName(data[i][1]);
 			temp[i].setVehicleTypeID(Integer.parseInt(data[i][2]));
			temp[i].setChessisNo(data[i][3]);
			temp[i].setInwardYear(Integer.parseInt(data[i][4]));

		}
 		return(temp);
 	}

 	public static clsVehicleReport [] getAllVehicleReportInformation()
 	{
 		String Query =  "select "+
 						" v.VehicleID, "+
 						" v.VehicleName, "+
 						" v.VehicleTypeID, "+
 						" v.ChessisNo, "+
 						" v.InwardYear, "+
 						" vt.VehicleTypeName "+
 						" from dbProjectData.tblVehicle v "+
 						" JOIN dbProjectData.tblVehicleType vt ON v.VehicleTypeID = vt.VehicleTypeID";

 		String data[][] = QueryExecutor.getAllObjectInformation(Query,6);
 		clsVehicleReport temp[] = new clsVehicleReport[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsVehicleReport();
 			temp[i].setVehicleID(Integer.parseInt(data[i][0]));
 			temp[i].setVehicleName(data[i][1]);
 			temp[i].setVehicleTypeID(Integer.parseInt(data[i][2]));
			temp[i].setChessisNo(data[i][3]);
			temp[i].setInwardYear(Integer.parseInt(data[i][4]));
			temp[i].setVehicleTypeName(data[i][5]);
		}
 		return(temp);
 	}


 	public static clsVehicleReport getVehicleReportInformation(int VehicleID)
 	{
 		String Query =  "select "+
 						" v.VehicleID, "+
 						" v.VehicleName, "+
 						" v.VehicleTypeID, "+
 						" v.ChessisNo, "+
 						" v.InwardYear, "+
 						" vt.VehicleTypeName "+
 						" from dbProjectData.tblVehicle v "+
 						" JOIN dbProjectData.tblVehicleType vt ON v.VehicleTypeID = vt.VehicleTypeID"+
 						" WHERE v.VehicleID = "+String.valueOf(VehicleID);


 		String data[] = QueryExecutor.getObjectInformation(Query,6);
 		clsVehicleReport temp = new clsVehicleReport();

		temp.setVehicleID(Integer.parseInt(data[0]));
		temp.setVehicleName(data[1]);
		temp.setVehicleTypeID(Integer.parseInt(data[2]));
		temp.setChessisNo(data[3]);
		temp.setInwardYear(Integer.parseInt(data[4]));
		temp.setVehicleTypeName(data[5]);

 		return(temp);
 	}
}