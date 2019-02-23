package com.pattern.factory;

public class Main {
	static
	{
		try
		{
			Class.forName("OneProduct");
			Class.forName("AnotherProduct");
		}
		catch (ClassNotFoundException any)
		{
			any.printStackTrace();
		}
	}
	public static void main(String args[]) throws PhoneCallNotRegisteredException
	{
//		...
	}
}
