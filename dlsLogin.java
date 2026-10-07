import java.util.*;

public class dlsLogin
{
	public static boolean isValidUser(String Username, String Password)
	{
		boolean result = false;
		String Query = "select count(Username) from dbProjectData.tblUserLogin where Username='"+Username+"'"+" and Password = '"+Password+"'";
		if(QueryExecutor.getRowsCount(Query) == 1)
			result=true;

		return(result);
	}
}
