package util;

import sistema.*;

public abstract class ArgParse
{
	// Parsed arguments
	static String fname_Discentes;
	static String fname_Docentes;
	static String fname_Producoes;
	static String fname_Cursos;
	static String fname_Disciplinas;
	static String fname_Atividades;
	static String fname_OriGrad;
	static String fname_OriPosGrad;
	
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
		String o = "";
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
				case "-o":
					o = args[curPos + 1];
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
					System.out.println("TODO!");
					break;
				case "--write-only":
					System.out.println("TODO!");
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
		fname_Atividades = o;
		fname_OriGrad = og;
		fname_OriPosGrad = op;
	}
	
	public static void LoadData(Dados d)
	{
		d.Carrega_Discentes(fname_Discentes);
		d.Carrega_Docentes(fname_Docentes);
		d.Carrega_Producoes(fname_Producoes);
		d.Carrega_Cursos(fname_Cursos);
		d.Carrega_Disciplinas(fname_Disciplinas);
		d.CarregaOrientacoesGrad(fname_OriGrad);
		d.CarregaOrientacoesPos(fname_OriPosGrad);
		d.DEBUG();
	}
	
	
}
