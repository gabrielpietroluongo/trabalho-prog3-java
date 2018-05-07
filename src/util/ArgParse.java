package util;

import sistema.*;

public class ArgParse
{
	// Parsed arguments
	final String fname_Discentes;
	final String fname_Docentes;
	final String fname_Producoes;
	final String fname_Cursos;
	final String fname_Disciplinas;
	final String fname_Atividades;
	final String fname_OriGrad;
	final String fname_OriPosGrad;
	
	// Data from system
	private Data systemData;
	
	/*
	* ArgParse -> Recebe de entrada os argumentos do programa e processa eles adequadamente,
	* salvando as informações em uma instância da classe ArgParse.
	*/
	public ArgParse(String[] args)
	{
		this.systemData = new Data();
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
					break;
			}
		}
		
		this.fname_Docentes = d;
		this.fname_Discentes = a;
		this.fname_Producoes = p;
		this.fname_Cursos = c;
		this.fname_Disciplinas = r;
		this.fname_Atividades = o;
		this.fname_OriGrad = og;
		this.fname_OriPosGrad = op;
	}
	
	public void LoadData()
	{
		this.systemData.Carrega_Discentes("/dados/gpietro/trabalho_prog3/discentes.csv");
		this.systemData.Carrega_Docentes("/dados/gpietro/trabalho_prog3/docentes.csv");
		this.systemData.Carrega_Producoes("/dados/gpietro/trabalho_prog3/producoes.csv");
		this.systemData.Carrega_Cursos("/dados/gpietro/trabalho_prog3/cursos.csv");
		this.systemData.Carrega_Disciplinas("/dados/gpietro/trabalho_prog3/aulas.csv");
		this.systemData.DEBUG();
	}
	
	
}
