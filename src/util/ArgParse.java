package util;

import java.io.IOException;

import exceptions.ClassInconsistencyException;
import exceptions.InvalidCodeException;
import exceptions.InvalidDateException;
import exceptions.RepeatedCodeException;
import sistema.*;

public abstract class ArgParse
{
	// Parsed arguments
	static String fname_Discentes;
	static String fname_Docentes;
	static String fname_Producoes;
	static String fname_Cursos;
	static String fname_Disciplinas;
	static String fname_OriGrad;
	static String fname_OriPosGrad;
	
	public static boolean bWriteOnly = false;
	
	public static boolean bReadOnly = false;
	
	/*
	* ArgParse -> Recebe de entrada os argumentos do programa e processa eles adequadamente,
	* salvando as informações em uma instância da classe ArgParse.
	*/
	public static void parse(String[] args)
	{
		int curPos = 0;
		String d = "";
		String a = "";
		String p = "";
		String c = "";
		String r = "";
		String og = "";
		String op = "";
		while (curPos < args.length)
		{
			switch(args[curPos])
			{
				case "-d":
					d = args[curPos + 1];
					curPos += 2;
					break;
				case "-a":
					a = args[curPos + 1];
					curPos += 2;
					break;
				case "-p":
					p = args[curPos + 1];
					curPos += 2;
					break;
				case "-c":
					c = args[curPos + 1];
					curPos += 2;
					break;
				case "-r":
					r = args[curPos + 1];
					curPos += 2;
					break;
				case "-og":
					og = args[curPos + 1];
					curPos += 2;
					break;
				case "-op":
					op = args[curPos + 1];
					curPos += 2;
					break;
				case "--read-only":
					bReadOnly = true;
					curPos++;
					break;
				case "--write-only":
					bWriteOnly = true;
					curPos++;
					break;
				default:
					System.out.println("ERRO: NOT FOUND!!!");
					break;
			}
		}
		
		fname_Docentes = d;
		fname_Discentes = a;
		fname_Producoes = p;
		fname_Cursos = c;
		fname_Disciplinas = r;
		fname_OriGrad = og;
		fname_OriPosGrad = op;
	}
	
	public static void LoadData(Dados d) throws RepeatedCodeException, IOException, InvalidCodeException, NumberFormatException, InvalidDateException, ClassInconsistencyException
	{
		d.carregaDiscentes(fname_Discentes);
		d.carregaDocentes(fname_Docentes);
		d.carregaProducoes(fname_Producoes);
		d.carregaCursos(fname_Cursos);
		d.carregaDisciplinas(fname_Disciplinas);
		d.CarregaOrientacoesGrad(fname_OriGrad);
		d.CarregaOrientacoesPos(fname_OriPosGrad);
	}
	
	
}
