 import java.util.*;

 public class dlsDesignation
 {
 	public static void addNewDesignation(clsDesignation temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "insert into dbProjectData.tblDesignation" + SPACE +
 					   "(DesignationName) " +
 					   "Values (" + SQ + temp.getDesignationName() + SQ + ")";

 		QueryExecutor.processQuery(Query);

 	}
 	public static void updateDesignation(clsDesignation temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "update dbProjectData.tblDesignation set" + SPACE +
 					   "DesignationName=" + SQ + temp.getDesignationName() + SQ + SPACE +
 					   "where DesignationID=" + String.valueOf(temp.getDesignationID());

 		QueryExecutor.processQuery(Query);

 	}

 	public static void deleteDesignation(clsDesignation temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "delete from dbProjectData.tblDesignation where DesignationID="+temp.getDesignationID();

 		QueryExecutor.processQuery(Query);
 	}

 	public static int getIDFromName(String mDesignationName)
 	{
 		String Query = "select DesignationID from tblDesignation where DesignationName='"+mDesignationName+"'";

 		return QueryExecutor.getIDFromName(Query);
 	}

 	public static String getNameFromID(int mDesignationID)
 	{
 		String Query = "select DesignationName from tblDesignation where DesignationID="+String.valueOf(mDesignationID);

 		return QueryExecutor.getNameFromID(Query);
 	}

 	public static String [] getAllDesignationNames()
 	{
 		String Query = "select DesignationName from dbProjectData.tblDesignation";
 		return(QueryExecutor.getSingleColumn(Query));
 	}

 	public static int getAllDesignationCount()
 	{
 		String Query = "select count(DesignationID) from dbProjectData.tblDesignation";
 		return(QueryExecutor.getRowsCount(Query));
 	}


 	public static clsDesignation getDesignationInformation(int mDesignationID)
 	{
 		String Query = "select * from tblDesignation where DesignationID="+String.valueOf(mDesignationID);

 		String data[] = QueryExecutor.getObjectInformation(Query,2);

 		clsDesignation temp = new clsDesignation();

 		temp.setDesignationID(Integer.parseInt(data[0]));
 		temp.setDesignationName(data[1]);
 		//temp.setNo_Of_States(Integer.parseInt(data[2]));
 		return(temp);
 	}

 	public static clsDesignation [] getAllDesignationInformation()
 	{
 		String Query = "select * from tblDesignation";

 		String data[][] = QueryExecutor.getAllObjectInformation(Query,2);
 		clsDesignation temp[] = new clsDesignation[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsDesignation();
 			temp[i].setDesignationID(Integer.parseInt(data[i][0]));
 			temp[i].setDesignationName(data[i][1]);
		}
 		return(temp);
 	}



}