import java.util.*;

 public class dlsRootStop
 {
 	public static void addNewRootStop(clsRootStop temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "insert into dbProjectData.tblRootStop" + SPACE +
 					   "(RootID,StationID,StopTime) " +"Values ("
 					   	+temp.getRootID()+COMMA+ SPACE
 					    +temp.getStationID()+COMMA+ SPACE
 					   + SQ + temp.getStopTime() + SQ
 					   +")" ;


 		QueryExecutor.processQuery(Query);

 	}
 	public static void updateRootStop(clsRootStop temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "update dbProjectData.tblRootStop set" + SPACE +
 					   "RootID="+temp.getRootID()+ COMMA+ SPACE+
 					   "RootStopID="+temp.getRootStopID()+SPACE+COMMA+
 					   "DestinationStationID="+temp.getStationID()+SPACE+COMMA+
 					   "StopTime="+ SQ + temp.getStopTime() +SQ +SPACE+
 					   "where RootStopID=" + String.valueOf(temp.getRootStopID());

 		QueryExecutor.processQuery(Query);

 	}

 	public static void deleteRootStop(clsRootStop temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "delete from dbProjectData.tblRootStop where RootStopID="+temp.getRootStopID();

 		QueryExecutor.processQuery(Query);
 	}

 	public static int getIDFromName(String mRootStopName)
 	{
 		String Query = "select RootStopID from dbProjectData.tblRootStop where RootStopName='"+mRootStopName+"'";

 		return QueryExecutor.getIDFromName(Query);
 	}

 	public static String getNameFromID(int mRootStopID)
 	{
 		String Query = "select RootStopName from tblRootStop where RootStopID="+String.valueOf(mRootStopID);

 		return QueryExecutor.getNameFromID(Query);

 	}

 	/*public static String [] getAllRootStopNames()
 	{
 		String Query = "select RootID from dbProjectData.tblRootStop";
 		return(QueryExecutor.getSingleColumn(Query));
 	}*/

 	public static int getAllRootStopCount()
 	{
 		String Query = "select count(RootStopID) from dbProjectData.tblRootStop";
 		return(QueryExecutor.getRowsCount(Query));
 	}


 	public static clsRootStop getRootStopInformation(int mRootStopID)
 	{
 		String Query = "select * from tblRootStop where RootStopID="+String.valueOf(mRootStopID);

 		String data[] = QueryExecutor.getObjectInformation(Query,4);

 		clsRootStop temp = new clsRootStop();

		temp.setRootStopID(Integer.parseInt(data[0]));
		temp.setRootID(Integer.parseInt(data[1]));
		temp.setStationID(Integer.parseInt(data[2]));
		temp.setStopTime(data[3]);

 		return(temp);
 	}

 	public static clsRootStop [] getAllRootStopInformation()
 	{
 		String Query = "select * from tblRootStop";

 		String data[][] = QueryExecutor.getAllObjectInformation(Query,4);
 		clsRootStop temp[] = new clsRootStop[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsRootStop();
 			temp[i].setRootStopID(Integer.parseInt(data[i][0]));
 			temp[i].setRootID(Integer.parseInt(data[i][1]));
			temp[i].setStationID(Integer.parseInt(data[i][2]));
			temp[i].setStopTime(data[i][3]);
		}
 		return(temp);
 	}

 	public static clsRootStopReport [] getAllRootStopReportInformation()
 	{
 		String Query = "select rs.RootStopID, rs.RootID, rt.RootName, rs.StationID, t.TalukaName, rs.StopTime "+
 		"from dbProjectData.tblRootStop rs join dbProjectData.tblRoot rt on rt.RootID = rs.RootID "+
 		"join dbProjectData.tblTaluka t on t.TalukaID = rs.StationID";

 		String data[][] = QueryExecutor.getAllObjectInformation(Query,6);
 		clsRootStopReport temp[] = new clsRootStopReport[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsRootStopReport();
 			temp[i].setRootStopID(Integer.parseInt(data[i][0]));
 			temp[i].setRootID(Integer.parseInt(data[i][1]));
 			temp[i].setRootName(data[i][2]);
			temp[i].setStationID(Integer.parseInt(data[i][3]));
			temp[i].setTalukaName(data[i][4]);
			temp[i].setStopTime(data[i][5]);
		}
 		return(temp);
 	}

 	public static clsRootStopReport [] getAllRootStopReportInformation(int mRootID)
 	{
 		String Query = "select rs.RootStopID, rs.RootID, rt.RootName, rs.StationID, t.TalukaName, rs.StopTime "+
 		"from dbProjectData.tblRootStop rs join dbProjectData.tblRoot rt on rt.RootID = rs.RootID "+
 		"join dbProjectData.tblTaluka t on t.TalukaID = rs.StationID"+
 		" where rs.RootID="+String.valueOf(mRootID);

 		String data[][] = QueryExecutor.getAllObjectInformation(Query,6);
 		clsRootStopReport temp[] = new clsRootStopReport[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsRootStopReport();
 			temp[i].setRootStopID(Integer.parseInt(data[i][0]));
 			temp[i].setRootID(Integer.parseInt(data[i][1]));
 			temp[i].setRootName(data[i][2]);
			temp[i].setStationID(Integer.parseInt(data[i][3]));
			temp[i].setTalukaName(data[i][4]);
			temp[i].setStopTime(data[i][5]);
		}
 		return(temp);
 	}



}