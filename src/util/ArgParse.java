package util;

import java.util.Vector;

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
	}
	
	// TODO talvez refatorar essa função? - Possivelmente mover o carregamento de arquivos para CSVLoader.java :)
	public void LoadData()
	{
		//Discentes
		Vector<String[]> discentes_data = CSVLoader.load_data("C:\\\\Users\\\\gabri\\\\eclipse-workspace\\\\discentes.txt");
		for (String[] line : discentes_data)
		{
			this.systemData.Adiciona_Discente(new Discente(line[0], line[1], Integer.parseInt(line[2])));
		}
		//Docentes
		Vector<String[]> docentes_data = CSVLoader.load_data("C:\\\\Users\\\\gabri\\\\eclipse-workspace\\\\docentes.txt");
		for(String[] line : docentes_data)
		{
			this.systemData.Adiciona_Docente(new Docente(Integer.parseInt(line[0]), line[1], line[2]));
		}
	}
	
	
}
