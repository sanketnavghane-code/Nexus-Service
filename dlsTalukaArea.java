import java.util.*;

public class dlsTalukaArea
{
	public static void addNewTalukaArea(clsTalukaArea temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "insert into dbProjectData.tblTalukaArea" + SPACE +
					   "(TalukaAreaName,TalukaID) " +
					   "values (" + SPACE +
					   SQ + temp.getTalukaAreaName() + SQ + COMMA +
					   String.valueOf(temp.getTalukaID()) +
					   ")";

		QueryExecutor.processQuery(Query);

	}
	public static void updateTalukaArea(clsTalukaArea temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "update dbProjectData.tblTalukaArea set" + SPACE +
					   "TalukaAreaName=" + SQ + temp.getTalukaAreaName() + SQ + SPACE + COMMA+
					   "TalukaID=" +String.valueOf(temp.getTalukaID()) +SPACE+
					   "where TalukaAreaID=" + String.valueOf(temp.getTalukaAreaID());

		QueryExecutor.processQuery(Query);

	}

	public static void deleteTalukaArea(clsTalukaArea temp)
	{
		String SQ = "'";
		String COMMA = ",";
		String SPACE = " ";

		String Query = "delete from dbProjectData.tblTalukaArea where TalukaAreaID="+temp.getTalukaAreaID();

		QueryExecutor.processQuery(Query);
	}

	public static int getIDFromName(String mTalukaAreaName)
	{
		String Query = "select TalukaAreaID from dbProjectData.tblTalukaArea where TalukaAreaName='"+mTalukaAreaName+"'";

		return QueryExecutor.getIDFromName(Query);
	}

	public static String [] getAllTalukaAreaNames()
	{
		String Query = "select TalukaAreaName from dbProjectData.tblTalukaArea";
		return(QueryExecutor.getSingleColumn(Query));
	}
	public static String [] getAllTalukaAreaNames(int mTalukaID)
	{
		String Query = "select TalukaAreaName from dbProjectData.tblTalukaArea where TalukaID="+String.valueOf(mTalukaID);
		return(QueryExecutor.getSingleColumn(Query));
	}


	public static clsTalukaArea getTalukaAreaInformation(int mTalukaAreaID)
	{
		String Query = "select * from tblTalukaArea where TalukaAreaID="+String.valueOf(mTalukaAreaID);

		String values[] = QueryExecutor.getSingleRow(Query,3);

		clsTalukaArea temp = new clsTalukaArea();

		temp.setTalukaAreaID(Integer.parseInt(values[0]));
		temp.setTalukaAreaName(values[1]);
		temp.setTalukaID(Integer.parseInt(values[2]));
		return(temp);


	}


	public static clsTalukaArea [] getAllTalukaAreaInformation()
	{
		String Query = "select * from dbProjectData.tblTalukaArea";

		String data[][] = QueryExecutor.getAllObjectInformation(Query,3);
		clsTalukaArea temp[] = new clsTalukaArea[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsTalukaArea();
			temp[i].setTalukaAreaID(Integer.parseInt(data[i][0]));
			temp[i].setTalukaAreaName(data[i][1]);
			temp[i].setTalukaID(Integer.parseInt(data[i][2]));
		}
		return(temp);
 	}
 	public static clsTalukaAreaReport1 [] getTalukaAreaReport1Info()
 	{

		String Query ="SELECT t.TalukaAreaID, t.TalukaAreaName, t.TalukaID, t.TalukaName"+
					  " from dbProjectData.tblTaluka t JOIN dbProjectData.tblTalukaArea t "+
					  " on s.TalukaID = c.TalukaID ";


 		String data[][] = QueryExecutor.getAllObjectInformation(Query,4);
 		clsTalukaAreaReport1 temp[] = new clsTalukaAreaReport1[data.length];

		for(int i=0;i<data.length;i++)
		{
			temp[i]=new clsTalukaAreaReport1();
 			temp[i].setTalukaID(Integer.parseInt(data[i][0]));
 			temp[i].setTalukaName(data[i][1]);
 			temp[i].setTalukaAreaID(Integer.parseInt(data[i][2]));
 			temp[i].setTalukaAreaName(data[i][3]);

		}

 		return(temp);
 	}
}