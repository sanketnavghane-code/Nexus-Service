import java.util.*;

 public class dlsRoot
 {
 	public static int addNewRoot(clsRoot temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";
		int Affected_Row = 0;

 		/*String Query = "insert into dbProjectData.tblRoot" + SPACE +
 					   "(RootName,SourceStationID, Villagian, DestinationStationID, StartTime, TimeShift) " +"Values ("
 					   	+ SQ + temp.getRootName() + SQ + COMMA +SPACE
 					    +temp.getSourceStationID()+ COMMA+ SPACE
 					    + SQ + temp.getVillagian() + SQ +COMMA+ SPACE +
 					    +temp.getDestinationStationID()+SPACE+COMMA
 					   + SQ + temp.getStartTime() + SQ +SPACE+COMMA
 					   + temp.getTimeShift()+")" ;



 		QueryExecutor.processQuery(Query);*/

 		 		String Query =" INSERT INTO dbprojectdata.tblRoot (RootName,SourceStationID, Villagian, DestinationStationID, StartTime, TimeShift) " +
							  " SELECT "+ SQ + temp.getRootName() + SQ + COMMA +SPACE
											 + temp.getSourceStationID()+ COMMA+ SPACE
											 + SQ + temp.getVillagian() + SQ +COMMA+ SPACE +
											 + temp.getDestinationStationID()+SPACE+COMMA
											 + SQ + temp.getStartTime() + SQ +SPACE+COMMA
											 + temp.getTimeShift()+
							  " FROM DUAL "+
							  " WHERE NOT EXISTS ( "+
							      " SELECT 1 "+
							      " FROM dbprojectdata.tblRoot R "+
							      " WHERE  R.RootName = "+ SQ + temp.getRootName() + SQ +")";

		Affected_Row = QueryExecutor.processQuery(Query);
 		return Affected_Row;

 	}
 	public static void updateRoot(clsRoot temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "update dbProjectData.tblRoot set" + SPACE +
 					   "RootName="+ SQ + temp.getRootName() + SQ + COMMA +SPACE+
 					   "SourceStationID="+temp.getSourceStationID()+ COMMA+ SPACE+
 					   "Villagian="+ SQ + temp.getVillagian() + SQ +COMMA+ SPACE +
 					   "DestinationStationID="+temp.getDestinationStationID()+SPACE+COMMA+
 					   "StartTime="+ SQ + temp.getStartTime() + SQ +SPACE+COMMA+
 					   "TimeShift="+ temp.getTimeShift() +SPACE+
 					   "where RootID=" + String.valueOf(temp.getRootID());

 		QueryExecutor.processQuery(Query);

 	}

 	public static void deleteRoot(clsRoot temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "delete from dbProjectData.tblRoot where RootID="+temp.getRootID();

 		QueryExecutor.processQuery(Query);
 	}

 	public static int getIDFromName(String mRootName)
 	{
 		String Query = "select RootID from dbProjectData.tblRoot where RootName='"+mRootName+"'";

 		return QueryExecutor.getIDFromName(Query);
 	}

 	public static String getNameFromID(int mRootID)
 	{
 		String Query = "select RootName from tblRoot where RootID="+String.valueOf(mRootID);

 		return QueryExecutor.getNameFromID(Query);
 	}

 	public static String [] getAllRootNames()
 	{
 		String Query = "select RootName from dbProjectData.tblRoot";
 		return(QueryExecutor.getSingleColumn(Query));
 	}

 	public static String [] getAllFreeRootNames()
 	{
 		String Query = "select R.RootName from dbProjectData.tblRoot R "+
 						" LEFT JOIN dbProjectData.tblAllocation A ON R.RootID = A.RootID "+
 						" where A.RootID IS NULL";
 		return(QueryExecutor.getSingleColumn(Query));
 	}

 	public static String [] getAllFreeRootNames(int TodaysDay,int TodaysMonth,int TodaysYear)
 	{
 		/*String Query = "select R.RootName from dbProjectData.tblRoot R "+
 						" LEFT JOIN dbProjectData.tblAllocation A ON R.RootID = A.RootID "+
 						" where A.RootID IS NULL";*/

		  String Query =" select R.RootName "+
						" from dbProjectData.tblRoot R "+
						" LEFT JOIN "+
						" (SELECT * "+
						" from dbProjectData.tblAllocation "+
						" where AllocationDayNo = "+String.valueOf(TodaysDay)+
						" AND AllocationMonthNo = "+String.valueOf(TodaysMonth)+
						" AND AllocationYearNo = "+String.valueOf(TodaysYear)+") A "+
						" ON R.RootID = A.RootID "+
						" where A.RootID IS NULL";

 		return(QueryExecutor.getSingleColumn(Query));
 	}

 	public static int getAllRootCount()
 	{
 		String Query = "select count(RootID) from dbProjectData.tblRoot";
 		return(QueryExecutor.getRowsCount(Query));
 	}


 	public static clsRoot getRootInformation(int mRootID)
 	{
 		String Query = "select * from tblRoot where RootID="+String.valueOf(mRootID);

 		String data[] = QueryExecutor.getObjectInformation(Query,7);

 		clsRoot temp = new clsRoot();

		temp.setRootID(Integer.parseInt(data[0]));
		temp.setRootName(data[1]);
		temp.setSourceStationID(Integer.parseInt(data[2]));
		temp.setVillagian(Integer.parseInt(data[3]));
		temp.setDestinationStationID(Integer.parseInt(data[4]));
		temp.setStartTime(data[5]);
		temp.setTimeShift(Integer.parseInt(data[6]));

 		return(temp);
 	}

 	public static clsRoot [] getAllRootInformation()
 	{
 		String Query = "select * from tblRoot";

 		String data[][] = QueryExecutor.getAllObjectInformation(Query,7);
 		clsRoot temp[] = new clsRoot[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsRoot();
 			temp[i].setRootID(Integer.parseInt(data[i][0]));
 			temp[i].setRootName(data[i][1]);
 			temp[i].setSourceStationID(Integer.parseInt(data[i][2]));
			temp[i].setVillagian(Integer.parseInt(data[i][3]));
			temp[i].setDestinationStationID(Integer.parseInt(data[i][4]));
			temp[i].setStartTime(data[i][5]);
			temp[i].setTimeShift(Integer.parseInt(data[i][6]));
		}
 		return(temp);
 	}

 	public static clsRootReport [] getAllRootReportInformation()
 	{
 		String Query = "SELECT "+
 						" R.RootID, "+
 						" R.RootName, "+
 						" R.SourceStationID, "+
 						" R.Villagian, "+
 						" R.DestinationStationID, "+
 						" R.StartTime, "+
 						" R.TimeShift, "+
 						" T.TalukaName, "+
 						" T1.TalukaName "+
 						" FROM dbProjectData.tblRoot R "+
 						" JOIN dbProjectData.tblTaluka T ON R.SourceStationID=T.TalukaID "+
 						" JOIN dbProjectData.tblTaluka T1 ON R.DestinationStationID=T1.TalukaID";

 		String data[][] = QueryExecutor.getAllObjectInformation(Query,9);
 		clsRootReport temp[] = new clsRootReport[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsRootReport();
 			temp[i].setRootID(Integer.parseInt(data[i][0]));
 			temp[i].setRootName(data[i][1]);
 			temp[i].setSourceStationID(Integer.parseInt(data[i][2]));
			temp[i].setVillagian(Integer.parseInt(data[i][3]));
			temp[i].setDestinationStationID(Integer.parseInt(data[i][4]));
			temp[i].setStartTime(data[i][5]);
			temp[i].setTimeShift(Integer.parseInt(data[i][6]));
			temp[i].setSourceStationName(data[i][7]);
			temp[i].setDestinationStationName(data[i][8]);
		}
 		return(temp);
 	}


 	public static clsRootReport [] getAllRootReportInformation(int mSearchStationID)
 	{

/*select R.RootName, R.SourceStationID, R.StartTime, R.DestinationStationID, R.TimeShift, T1.TalukaName, T2.TalukaName,
	   RS.RootID, RS.StationID
       from dbprojectdata.tblRootStop RS
       JOIN dbprojectdata.tblRoot R ON RS.RootID = R.RootID
       JOIN dbprojectdata.tblTaluka T1 ON R.SourceStationID = T1.TalukaID
       JOIN dbprojectdata.tblTaluka T2 ON R.DestinationStationID = T2.TalukaID
where StationID = 607;	*/
 		String Query = "SELECT "+
 						" R.RootID, "+
 						" R.RootName, "+
 						" R.SourceStationID, "+
 						" R.Villagian, "+
 						" R.DestinationStationID, "+
 						" R.StartTime, "+
 						" R.TimeShift, "+
 						" T.TalukaName, "+
 						" T1.TalukaName, "+
 						" RS.RootID, RS.StationID "+
 						" FROM dbprojectdata.tblRootStop RS "+
 						" JOIN dbProjectData.tblRoot R ON RS.RootID = R.RootID "+
 						" JOIN dbProjectData.tblTaluka T ON R.SourceStationID=T.TalukaID "+
 						" JOIN dbProjectData.tblTaluka T1 ON R.DestinationStationID=T1.TalukaID "+
 						" where StationID ="+String.valueOf(mSearchStationID);


 		String data[][] = QueryExecutor.getAllObjectInformation(Query,11);
 		clsRootReport temp[] = new clsRootReport[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsRootReport();

 			temp[i].setRootID(Integer.parseInt(data[i][0]));
 			temp[i].setRootName(data[i][1]);
 			temp[i].setSourceStationID(Integer.parseInt(data[i][2]));
			temp[i].setVillagian(Integer.parseInt(data[i][3]));
			temp[i].setDestinationStationID(Integer.parseInt(data[i][4]));
			temp[i].setStartTime(data[i][5]);
			temp[i].setTimeShift(Integer.parseInt(data[i][6]));
			temp[i].setSourceStationName(data[i][7]);
			temp[i].setDestinationStationName(data[i][8]);
		}
 		return(temp);
 	}



 	public static clsRootReport getRootReportInformation(int mRootID)
	{
		String Query = "SELECT "+
 						" R.RootID, "+
 						" R.RootName, "+
 						" R.SourceStationID, "+
 						" R.Villagian, "+
 						" R.DestinationStationID, "+
 						" R.StartTime, "+
 						" R.TimeShift, "+
 						" T.TalukaName, "+
 						" T1.TalukaName "+
 						" FROM dbProjectData.tblRoot R "+
 						" JOIN dbProjectData.tblTaluka T ON R.SourceStationID=T.TalukaID "+
 						" JOIN dbProjectData.tblTaluka T1 ON R.DestinationStationID=T1.TalukaID "+
						" WHERE R.RootID = "+String.valueOf(mRootID);

		String data[] = QueryExecutor.getObjectInformation(Query,9);
		clsRootReport temp = new clsRootReport();

		temp.setRootID(Integer.parseInt(data[0]));
		temp.setRootName(data[1]);
		temp.setSourceStationID(Integer.parseInt(data[2]));
		temp.setVillagian(Integer.parseInt(data[3]));
		temp.setDestinationStationID(Integer.parseInt(data[4]));
		temp.setStartTime(data[5]);
		temp.setTimeShift(Integer.parseInt(data[6]));
		temp.setSourceStationName(data[7]);
		temp.setDestinationStationName(data[8]);

		return(temp);
 	}



}