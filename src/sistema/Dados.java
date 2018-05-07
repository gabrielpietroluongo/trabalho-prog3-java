package sistema;

import java.util.Vector;

import util.CSV;


public class Dados
{
	public Vector<Docente> Docentes = new Vector<Docente>();
	public Vector<Discente> Discentes = new Vector<Discente>();
	public Vector<Producao> Producoes = new Vector<Producao>();
	public Vector<Curso> Cursos = new Vector<Curso>();
	public Vector<Disciplina> Disciplinas = new Vector<Disciplina>();
	
	
	public Vector<OrientacaoGrad> OrientacoesGrad = new Vector<OrientacaoGrad>();
	public Vector<OrientacaoPos> OrientacoesPos = new Vector<OrientacaoPos>();
	
	public Dados()
	{
		
	}
	
	/*
	 * DOCENTES
	 */
	
	public void Carrega_Docentes(String path)
	{
		Vector<String[]> docentes_data = CSV.load_data(path);
		for (String[] line : docentes_data)
		{
			this.Adiciona_Docente(line);
		}
	}
	
	public void Adiciona_Docente(Docente d)
	{
		// TODO talvez checar se o docente ja existe no vetor?
		Docentes.addElement(d);
	}
	
	public void Adiciona_Docente(String[] params)
	{
		this.Adiciona_Docente(new Docente(Integer.parseInt(params[0]), params[1], params[2]));
	}
	
	/*
	 * DISCENTES
	 */
	
	public void Carrega_Discentes(String path)
	{
		Vector<String[]> discentes_data = CSV.load_data(path);
		for (String[] line : discentes_data)
		{
			this.Adiciona_Discente(line);
		}
	}
	
	public void Adiciona_Discente(Discente d)
	{
		for (Discente discente : this.Discentes)
		{
			if(discente.equals(d))
			{
				System.out.println("Erro: O discente já existe");
				return;
				//TODO throw();
			}
		}
		Discentes.addElement(d);
	}
	
	public void Adiciona_Discente(String[] params)
	{
		this.Discentes.addElement(new Discente(params[0], params[1], Integer.parseInt(params[2])));
	}
	
	/*
	 * PRODUÇÕES
	 */
	
	public void Carrega_Producoes(String path)
	{
		Vector<String[]> producoes_data = CSV.load_data(path);
		for(String[] line : producoes_data)
		{
			this.Adiciona_Producao(line);
		}
	}
	
	public void Adiciona_Producao(Producao p)
	{
		Producoes.addElement(p);
	}
	
	public void Adiciona_Producao(String[] params)
	{
		if(params.length == 3)
		{
			Producoes.addElement(new Producao(Integer.parseInt(params[0]), params[1], params[2]));
		}
		else
		{
			Producoes.addElement(new Producao(Integer.parseInt(params[0]), params[1], false));
		}
	}
	
	/*
	 * CURSOS
	 */
	
	public void Adiciona_Curso(Curso c)
	{
		this.Cursos.addElement(c);
	}
	
	public void Adiciona_Curso(String[] params)
	{
		if(params.length == 3)
		{
			this.Adiciona_Curso(new Curso(Integer.parseInt(params[0]), params[1], true));
		}
		else
		{
			this.Adiciona_Curso(new Curso(Integer.parseInt(params[0]), params[1], false));
		}
	}
	
	public void Carrega_Cursos(String path)
	{
		Vector<String[]> cursos_data = CSV.load_data(path);
		for (String[] line : cursos_data)
		{
			this.Adiciona_Curso(line);
		}
	}
	
	/*
	 * DISCIPLINAS
	 */
	
	public void Adicina_Disciplina(Disciplina d)
	{
		//TODO: adicionar as horas-aula ao professor relacionado à disciplina
		this.Disciplinas.add(d);
	}
	
	public void Adiciona_Disciplina(String[] params)
	{
		this.Adicina_Disciplina(new Disciplina(params[0], params[1],
								Integer.parseInt(params[2]), 
								Integer.parseInt(params[3]), 
								Integer.parseInt(params[4]), 
								Integer.parseInt(params[5])));
	}
	
	public void Carrega_Disciplinas(String path)
	{
		Vector<String[]> disciplinas_data = CSV.load_data(path);
		for (String[] line : disciplinas_data)
		{
			for (String x : line)
			{
				System.out.println(x);
			}
			this.Adiciona_Disciplina(line);
		}
	}
	
	/*
	 * ORIENTAÇÕES GRADUAÇÃO
	 */
	
	public void CarregaOrientacoesGrad(String path)
	{
		Vector<String[]> orientacoesData = CSV.load_data(path);
		for (String[] line : orientacoesData)
		{
			AdicionaOrientacaoGrad(line);
		}
	}
	
	public void AdicionaOrientacaoGrad(String[] params)
	{
		AdicionaOrientacaoGrad(new OrientacaoGrad(Integer.parseInt(params[0]), params[1],
							   Integer.parseInt(params[2]), Integer.parseInt(params[3])));
	}
	
	public void AdicionaOrientacaoGrad(OrientacaoGrad o)
	{
		this.OrientacoesGrad.add(o);
	}
	
	/*
	 * UTILITÁRIOS
	 */
	
	public void PrintaDiscentes()
	{
		System.out.println("Discentes:");
		for (Discente d : Discentes)
		{
			System.out.println(d);
		}
	}
	
	public void PrintaDocentes()
	{
		System.out.println("Docentes:");
		for (Docente d : Docentes)
		{
			System.out.println(d);
		}
	}
	
	public void PrintaProducoes()
	{
		System.out.println("Produções:");
		for (Producao p : Producoes)
		{
			System.out.println(p);
		}
	}
	
	public void PrintaCursos()
	{
		System.out.println("Cursos:");
		for (Curso c : Cursos)
		{
			System.out.println(c);
		}
	}
	
	public void PrintaDisciplinas()
	{
		System.out.println("Disciplinas:");
		for (Disciplina d : Disciplinas)
		{
			System.out.println(d);
		}
	}
	
	public void PrintaOrientacoesGrad()
	{
		System.out.println("Orientações de Graduação:");
		for (OrientacaoGrad o : OrientacoesGrad)
		{
			System.out.println(o);
		}
	}
	
	public void DEBUG()
	{
		PrintaDiscentes();
		PrintaDocentes();
		PrintaProducoes();
		PrintaCursos();
		PrintaDisciplinas();
		PrintaOrientacoesGrad();
	}
	
	//TODO
	public static void AdicionaHorasAulaADocente(Disciplina d, int codigoDocente)
	{
		
	}
	
}
