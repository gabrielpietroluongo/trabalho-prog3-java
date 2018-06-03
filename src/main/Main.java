package main;

import util.*;

import java.io.IOException;

import sistema.Dados;
import exceptions.InvalidCodeException;
import exceptions.InvalidDateException;
import exceptions.RepeatedCodeException;

public class Main
{

	public static void main(String[] args)
	{
		try
		{
			Dados d = new Dados();
			ArgParse.parse(args);
			if(ArgParse.bReadOnly)
			{
				ArgParse.LoadData(d);
				Serialization.saveData("dados.dat", d);
				System.out.println("Serialização bem sucedida");
				return;
			}
			else if(ArgParse.bWriteOnly)
			{
				d = (Dados) Serialization.loadData("dados.dat");
				d.gera_pad_e_salva();
				d.gera_rha_e_salva();
				d.gera_alocacao_e_salva();
				d.gera_ppg_e_salva();
				System.out.println("Execução bem sucedida");
				return;
			}
			ArgParse.LoadData(d);
			d.gera_pad_e_salva();
			d.gera_rha_e_salva();
			d.gera_alocacao_e_salva();
			d.gera_ppg_e_salva();
			System.out.println("Execução bem sucedida");
		}
		catch(RepeatedCodeException e)
		{
			System.out.println(e);
		}
		catch(InvalidCodeException e)
		{
			System.out.println(e);
		}
		catch(InvalidDateException e)
		{
			System.out.println(e);
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
