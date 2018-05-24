package main;

import util.*;

import java.io.IOException;

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
			d.gera_rha_e_salva();
			d.gera_alocacao_e_salva();
			d.gera_ppg_e_salva();
			System.out.println("Execução bem sucedida");
		}
		catch(IOException e)
		{
			System.out.println("Erro de I/O");
		}
		catch(NumberFormatException e)
		{
			System.out.println("Erro de formatação");
		}
		catch(Exception e)
		{
			System.out.println("UNHANDLED EXCEPTION CAUGHT!");
			e.printStackTrace();
			System.out.println("Execução com falha");
		}

	}

}
