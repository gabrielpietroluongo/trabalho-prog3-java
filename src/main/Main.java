package main;

import util.*;

import java.io.IOException;

import sistema.Dados;
import exceptions.*;

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
				d.geraPADESalva();
				d.geraRHAESalva();
				d.geraAlocacaoESalva();
				d.geraPPGESalva();
				System.out.println("Execução bem sucedida");
				return;
			}
			// Execução "normal"
			ArgParse.LoadData(d);
			d.geraPADESalva();
			d.geraRHAESalva();
			d.geraAlocacaoESalva();
			d.geraPPGESalva();
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
		catch(ClassInconsistencyException e)
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
			e.printStackTrace();
			System.out.println("Execução com falha");
		}

	}

}
