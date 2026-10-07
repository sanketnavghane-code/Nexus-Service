import java.util.*;

public class dlsDistrict
{
	public static void addNewDistrict(clsDistrict temp)
	{
		String SQ = "'", COMMA = ",", SPACE = " ";
		String QUERY = "INSERT INTO DBProjectData.tblDistrict"+SPACE+
				"(DistrictName,StateID)"+ SPACE+
				"VALUES"+SPACE+"('"+temp.getDistrictName()+"'"+COMMA+temp.getStateID()+")";
		QueryExecutor.processQuery(QUERY);
	}

	public static void updateDistrict(clsDistrict temp)
	{
		String SQ = "'", COMMA = ",", SPACE = " ";
		String QUERY = "update DBProjectData.tblDistrict set"+SPACE+"DistrictName="+SQ+temp.getDistrictName()+SQ+COMMA+"StateID="+temp.getStateID()+ SPACE+"where DistrictID="+String.valueOf(temp.getDistrictID());
		QueryExecutor.processQuery(QUERY);
	}

	public static void deleteDistrict(clsDistrict temp)
	{
		String Query = "delete from dbProjectData.tblDistrict where DistrictID="+String.valueOf(temp.getDistrictID());
		QueryExecutor.processQuery(Query);
	}

	public static String[] getAllStateNames()
	{
		String query = "SELECT StateName FROM DBProjectData.tblState";
		return(QueryExecutor.getSingleColumn(query));
	}

	public static String[] getAllStateNames(int mCountryID)
	{
		String query = "SELECT StateName FROM DBProjectData.tblState WHERE CountryID = "+String.valueOf(mCountryID);
		return(QueryExecutor.getSingleColumn(query));
	}


	public static String[] getAllDistrictNames()
	{
		String query = "SELECT DistrictName FROM DBProjectData.tblDistrict";
		return(QueryExecutor.getSingleColumn(query));
	}

	public static String[] getAllDistrictNames(int mState)
	{
		String query = "SELECT DistrictName FROM DBProjectData.tblDistrict WHERE StateID = "+String.valueOf(mState);
		return(QueryExecutor.getSingleColumn(query));
	}


	public static int getIDFromName(String mDistrictName)
	{
		String query = "SELECT DistrictID FROM DBProjectData.tblDistrict WHERE DistrictName = '"+mDistrictName+"'";
		return(QueryExecutor.getIDFromName(query));
	}

	public static clsDistrict getDistrictInformation(int mDistrictID)
	{
		String Query = "select * from DBProjectData.tblDistrict where DistrictID="+String.valueOf(mDistrictID);
		String temp1[] = QueryExecutor.getSingleRow(Query,3);
		clsDistrict temp = new clsDistrict();
		temp.setDistrictID(Integer.parseInt(temp1[0].toString()));
		temp.setDistrictName((String)(temp1[1]));
		temp.setStateID(Integer.parseInt(temp1[2].toString()));
		return(temp);
	}
 	public static clsDistrictReport1 [] getDistrictReport1Info()
 	{

		String Query ="SELECT d.DistrictID, d.DistrictName, s.StateID, s.StateName"+
					  " from dbProjectData.tblDistrict d JOIN dbProjectData.tblState s "+
					  " on d.StateID = s.StateID ";


 		String data[][] = QueryExecutor.getAllObjectInformation(Query,4);
 		clsDistrictReport1 temp[] = new clsDistrictReport1[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsDistrictReport1();
 			temp[i].setDistrictID(Integer.parseInt(data[i][0]));
 			temp[i].setDistrictName(data[i][1]);
 			temp[i].setStateID(Integer.parseInt(data[i][2]));
 			temp[i].setStateName(data[i][3]);

		}

 		return(temp);
 	}

}
