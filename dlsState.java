import java.util.*;

 public class dlsState
 {
 	public static void addNewState(clsState temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "insert into dbProjectData.tblState" + SPACE +
 					   "(StateName,CountryID) " +
 					   "Values (" + SQ + temp.getStateName() + SQ +COMMA+ temp.getCountryID() +")";

 		QueryExecutor.processQuery(Query);

 	}
 	public static void updateState(clsState temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "update dbProjectData.tblState set" + SPACE +
 					   "StateName=" + SQ + temp.getStateName() + SQ + SPACE + COMMA +
 					   "CountryID=" + String.valueOf(temp.getCountryID())+ SPACE+
 					   "where StateID="+String.valueOf(temp.getStateID());

 		QueryExecutor.processQuery(Query);

 	}

 	public static void deleteState(clsState temp)
 	{
 		String SQ = "'";
 		String COMMA = ",";
 		String SPACE = " ";

 		String Query = "delete from dbProjectData.tblState where StateID="+temp.getStateID();

 		QueryExecutor.processQuery(Query);
 	}
	public static boolean isStateDulplicate(String mStateName)
	{
		boolean result = false;
		String mStateName1 = mStateName.substring(0,1).toUpperCase() + mStateName.substring(1).toLowerCase();
		String Query = "select count(StateID) from dbProjectData.tblState where StateName='"+mStateName1+"'";
		if(QueryExecutor.getRowsCount(Query)>0)
			result=true;
		return(result);
	}
 	public static int getIDFromName(String mStateName)
 	{
 		String Query = "select StateID from tblState where StateName='"+mStateName+"'";

 		return QueryExecutor.getIDFromName(Query);
 	}

 	public static String getNameFromID(int mStateID)
 	{
 		String Query = "select StateName from tblState where StateID="+String.valueOf(mStateID);

 		return QueryExecutor.getNameFromID(Query);
 	}

 	public static String [] getAllStateNames()
 	{
 		String Query = "select StateName from dbProjectData.tblState";
 		return(QueryExecutor.getSingleColumn(Query));
 	}

 	public static String [] getAllStateNames(int mCountryID)
 	{
 		String Query = "select StateName from dbProjectData.tblState where CountryID="+String.valueOf(mCountryID);
 		return(QueryExecutor.getSingleColumn(Query));
 	}


 	public static clsState getStateInformation(int mStateID)
 	{
 		String Query = "select * from tblState where StateID="+String.valueOf(mStateID);

 		String data[] = QueryExecutor.getObjectInformation(Query,2);

 		clsState temp = new clsState();

 		temp.setStateID(Integer.parseInt(data[0]));
 		temp.setStateName(data[1]);
 		return(temp);


 	}
 	public static clsState [] getAllStateInformation()
 	{
 		String Query = "select * from tblState";

 		String data[][] = QueryExecutor.getAllObjectInformation(Query,3);
 		clsState temp[] = new clsState[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsState();
 			temp[i].setStateID(Integer.parseInt(data[i][0]));
 			temp[i].setStateName(data[i][1]);
 			temp[i].setCountryID(Integer.parseInt(data[i][2]));

		}
 		return(temp);
 	}

 	public static clsStateReport1 [] getStateReport1Info()
 	{

		String Query ="SELECT s.StateID, s.StateName, c.CountryID, c.CountryName"+
					  " from dbProjectData.tblState s JOIN dbProjectData.tblCountry c "+
					  " on s.CountryID = c.CountryID ";


 		String data[][] = QueryExecutor.getAllObjectInformation(Query,4);
 		clsStateReport1 temp[] = new clsStateReport1[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsStateReport1();
 			temp[i].setStateID(Integer.parseInt(data[i][0]));
 			temp[i].setStateName(data[i][1]);
 			temp[i].setCountryID(Integer.parseInt(data[i][2]));
 			temp[i].setCountryName(data[i][3]);

		}

 		return(temp);
 	}
}