public class dlsLocationManagement2
{
	public static clsLocationManagement2 getLocationInfo(int mStateID)
	{
		String Query = "select c.CountryID, c.CountryName, s.StateID, s.StateName from dbProjectData.tblCountry c join dbProjectData.tblState s on c.CountryID = s.CountryID where s.StateID ="+String.valueOf(mStateID);

		String data[] = QueryExecutor.getObjectInformation(Query,4);

		clsLocationManagement2  temp = new clsLocationManagement2 ();

		temp.setCountryID(Integer.parseInt(data[0]));
		temp.setCountryName(data[1]);
		temp.setStateID(Integer.parseInt(data[2]));
		temp.setStateName(data[3]);
		return(temp);
	}
}