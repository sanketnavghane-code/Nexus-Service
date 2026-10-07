class Demo
{
	public static void main(String args[])
	{
		String input = "456";
		String mCountryName = input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();

		System.out.println(mCountryName);
	}
}