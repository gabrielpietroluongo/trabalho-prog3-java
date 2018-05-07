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
	private Dados systemData;
	
	/*
	* ArgParse -> Recebe de entrada os argumentos do programa e processa eles adequadamente,
	* salvando as informações em uma instância da classe ArgParse.
	*/
	public ArgParse(String[] args)
	{
		this.systemData = new Dados();
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
		this.systemData.Carrega_Discentes(this.fname_Discentes);
		this.systemData.Carrega_Docentes(this.fname_Docentes);
		this.systemData.Carrega_Producoes(this.fname_Producoes);
		this.systemData.Carrega_Cursos(this.fname_Cursos);
		this.systemData.Carrega_Disciplinas(this.fname_Disciplinas);
		this.systemData.CarregaOrientacoesGrad(this.fname_OriGrad);
		this.systemData.CarregaOrientacoesPos(this.fname_OriPosGrad);
		this.systemData.DEBUG();
	}
	
	
}
