import java.util.*;

public class dlsVillageArea
{
	public static void addNewVillageArea(clsVillageArea temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "insert into dbProjectData.tblVillageArea" + SPACE +
					   "(VillageAreaName,VillageID) " +
					   "values (" + SPACE +
					   SQ + temp.getVillageAreaName() + SQ + COMMA +
					   String.valueOf(temp.getVillageID()) +
					   ")";

		QueryExecutor.processQuery(Query);

	}
	public static void updateVillageArea(clsVillageArea temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblVillageArea set" + SPACE +
					   "VillageAreaName=" + SQ + temp.getVillageAreaName() + SQ + SPACE + COMMA+
					   "VillageID=" +String.valueOf(temp.getVillageID()) +SPACE+
					   "where VillageAreaID=" + String.valueOf(temp.getVillageAreaID());

		QueryExecutor.processQuery(Query);

	}

	public static void deleteVillageArea(clsVillageArea temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblVillageArea where VillageAreaID="+temp.getVillageAreaID();

		QueryExecutor.processQuery(Query);
	}

	public static int getIDFromName(String mVillageAreaName)
	{
		String Query = "select VillageAreaID from dbProjectData.tblVillageArea where VillageAreaName='"+mVillageAreaName+"'";

		return QueryExecutor.getIDFromName(Query);
	}

	public static String [] getAllVillageAreaNames()
	{
		String Query = "select VillageAreaName from dbProjectData.tblVillageArea";
		return(QueryExecutor.getSingleColumn(Query));
	}
	public static String [] getAllVillageAreaNames(int mTalukaID)
	{
		String Query = "select VillageAreaName from dbProjectData.tblVillageArea where VillageID="+String.valueOf(mTalukaID);
		return(QueryExecutor.getSingleColumn(Query));
	}


	public static clsVillageArea getVillageAreaInformation(int mVillageAreaID)
	{
		String Query = "select * from tblVillageArea where VillageAreaID="+String.valueOf(mVillageAreaID);

		String values[] = QueryExecutor.getSingleRow(Query,3);

		clsVillageArea temp = new clsVillageArea();

		temp.setVillageAreaID(Integer.parseInt(values[0]));
		temp.setVillageAreaName(values[1]);
		temp.setVillageID(Integer.parseInt(values[2]));
		return(temp);


	}


	public static clsVillageArea [] getAllVillageAreaInformation()
	{
		String Query = "select * from dbProjectData.tblVillageArea";

		String data[][] = QueryExecutor.getAllObjectInformation(Query,3);
		clsVillageArea temp[] = new clsVillageArea[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsVillageArea();
			temp[i].setVillageAreaID(Integer.parseInt(data[i][0]));
			temp[i].setVillageAreaName(data[i][1]);
			temp[i].setVillageID(Integer.parseInt(data[i][2]));
		}
		return(temp);
 	}
 	public static clsVillageAreaReport1 [] getVillageAreaReport1Info()
 	{

		String Query ="SELECT t.VillageAreaID, t.VillageAreaName, t.VillageID, t.VillageName"+
					  " from dbProjectData.tblVillage t JOIN dbProjectData.tblVillageArea t "+
					  " on s.VillageID = c.VillageID ";


 		String data[][] = QueryExecutor.getAllObjectInformation(Query,3);
 		clsVillageAreaReport1 temp[] = new clsVillageAreaReport1[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsVillageAreaReport1();
 			temp[i].setVillageID(Integer.parseInt(data[i][0]));
 			temp[i].setVillageAreaID(Integer.parseInt(data[i][1]));
 			temp[i].setVillageAreaName(data[i][2]);

		}

 		return(temp);
 	}
}