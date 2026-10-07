import java.util.*;

public class dlsVillage
{
	public static void addNewVillage(clsVillage temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "INSERT INTO dbProjectData.tblVillage " + SPACE +
					   "(VillageName, TalukaID) " + SPACE +
					   "VALUES (" + SPACE +
					   SQ + temp.getVillageName() + SQ + COMMA +
					   String.valueOf(temp.getTalukaID()) +
					   ")";

		QueryExecutor.processQuery(Query);
	}
	public static void updateVillage(clsVillage temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblVillage set " + SPACE +
		                "VillageName=" + SQ + temp.getVillageName() + SQ + SPACE + COMMA +
		                "TalukaID=" + String.valueOf(temp.getTalukaID()) + SPACE +
              			"where VillageID=" + String.valueOf(temp.getVillageID());
		QueryExecutor.processQuery(Query);

	}

	public static void deleteVillage(clsVillage temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblVillage where VillageID="+temp.getVillageID();

		QueryExecutor.processQuery(Query);
	}

	public static int getIDFromName(String mVillageName)
	{
	    String Query = "select VillageID from tblVillage where VillageName='" + mVillageName + "'";
	    return QueryExecutor.getIDFromName(Query);
	}
	public static String [] getAllVillageNames()
	{
		String Query = "select VillageName from dbProjectData.tblVillage";
		return(QueryExecutor.getSingleColumn(Query));
	}
	public static String [] getAllVillageNames(int mTalukaID)
	{
		String Query = "select VillageName from dbProjectData.tblVillage where TalukaID="+String.valueOf(mTalukaID);
		return(QueryExecutor.getSingleColumn(Query));
	}


	public static clsVillage getVillageInformation(int mVillageID)
	{
		String Query = "select * from tblVillage where VillageID="+String.valueOf(mVillageID);

		String values[] = QueryExecutor.getSingleRow(Query, 3);

		clsVillage temp = new clsVillage();

		temp.setVillageID(Integer.parseInt(values[0]));
		temp.setVillageName(values[1]);
		temp.setTalukaID(Integer.parseInt(values[2]));

		return(temp);


	}
}