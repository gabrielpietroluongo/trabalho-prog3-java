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
			d.gera_pad_e_salva();
			d.gera_alocacao_e_salva();
			System.out.println("Execução bem sucedida");
		}
		catch(Exception e)
		{
			System.out.println("UNHANDLED EXCEPTION CAUGHT!");
			e.printStackTrace();
			System.out.println("Execução com falha");
		}
	}

}
