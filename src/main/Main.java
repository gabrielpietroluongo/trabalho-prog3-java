package main;

import util.*;

import sistema.*;

public class Main
{

	public static void main(String[] args)
	{
		try
		{
			Dados d = new Dados();
			ArgParse.parse(args);
			ArgParse.LoadData(d);
		}
		/*
		catch(InvalidTeacherCodeException e)
		{
			System.out.println(e);
		}*/
		catch(Exception e)
		{
			System.out.println("UNHANDLED EXCEPTION CAUGHT!");
			e.printStackTrace();
		}
	}

}
