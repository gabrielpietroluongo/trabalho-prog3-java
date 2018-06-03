package sistema;

import java.io.IOException;
import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import util.CSV;

import exceptions.*;

public class Dados implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<Docente> Docentes = new ArrayList<Docente>();
	public List<Discente> Discentes = new ArrayList<Discente>();
	public List<Producao> Producoes = new ArrayList<Producao>();
	public List<Curso> Cursos = new ArrayList<Curso>();
	public List<Disciplina> Disciplinas = new ArrayList<Disciplina>();
	public List<OrientacaoGrad> OrientacoesGrad = new ArrayList<OrientacaoGrad>();
	public List<OrientacaoPos> OrientacoesPos = new ArrayList<OrientacaoPos>();
	
	public void gera_pad_e_salva() throws IOException
	{
		Collections.sort(this.Docentes);
		CSV.setOutputFile("1-pad.csv");
		CSV.save(new String[] {"Docente", "Departamento", "Horas Semanais Aula", "Horas Semestrais Aula", 
							   "Horas Semanais Orientação", "Horas Semestrais Orientação", "Produções Qualificadas", "Produções Não Qualificadas"});
		for (Docente d : Docentes)
		{
			CSV.save(d.getCSVData());
		}
		CSV.closeOutputFile();
	}
	
	public void gera_rha_e_salva() throws IOException
	{
		// Classe auxiliar para organizar (ordenar) as saídas
		class OutputData implements Comparable<OutputData>
		{
			/*
			 * Data:
			 * 0 - Nome do departamento
			 * 1 - Nome do docente
			 * 2 - Código do curso
			 * 3 - Nome do curso
			 * 4 - Total de horas-aula semestrais
			 */
			String[] data;
			
			public OutputData(String[] d)
			{
				this.data = d;
			}
			
			public String[] getCSVData()
			{
				return new String[] {
						data[0],
						data[1],
						data[2],
						data[3],
						data[4]
				};
			}
			
			@Override
			public int compareTo(OutputData arg0)
			{
				/*
				 * Ordem de sorting (crescente):
				 * 1 - Departamento
				 * 2 - Nome docente
				 * 3 - Nome curso
				 */
				Collator coll = Collator.getInstance(new Locale("pt", "BR"));
				coll.setStrength(Collator.IDENTICAL);
				int cmp = coll.compare(this.data[0], arg0.data[0]);
				if(cmp == 0)
				{
					cmp = coll.compare(this.data[1], arg0.data[1]);
					if(cmp == 0)
					{
						return coll.compare(this.data[3], arg0.data[3]);
					}
					return cmp;
				}
				return cmp;
			}
			
		}
		
		CSV.setOutputFile("2-rha.csv");
		CSV.save(new String[] {"Departamento", "Docente", "Cód. Curso", "Curso", "Horas Semestrais Aula"});
		List<OutputData> outData = new ArrayList<OutputData>();
		for(Curso c : Cursos)
		{
			int[][] mapData = c.getMapData();
			for (int[] id : mapData)
			{
				String[] out_append = new String[5];
				Docente d = getDocenteById(id[0]);
				out_append[0] = d.getDepartamento();
				out_append[1] = d.getNome();
				out_append[2] = String.valueOf(c.getCodigo());
				out_append[3] = c.getNome();
				out_append[4] = String.valueOf(id[1]);
				outData.add(new OutputData(out_append));
			}
		}
		Collections.sort(outData);
		for (OutputData o: outData)
		{
			CSV.save(o.getCSVData());
		}
		CSV.closeOutputFile();
	}

	public void gera_alocacao_e_salva() throws IOException
	{
		Collections.sort(this.Disciplinas);
		CSV.setOutputFile("3-alocacao.csv");
		CSV.save(new String[] {"Docente", "Código", "Nome", "Carga Horária Semestral"});
		for (Disciplina d : Disciplinas)
		{
			CSV.save(d.getCSVData());
		}
		CSV.closeOutputFile();
	}
	
	public void gera_ppg_e_salva() throws IOException
	{
		Collections.sort(this.OrientacoesPos);
		CSV.setOutputFile("4-ppg.csv");
		CSV.save(new String[] {"Nome do Programa", "Data de Ingresso", "Matrícula", "Nome"});
		for (OrientacaoPos o : OrientacoesPos)
		{
			CSV.save(o.getCSVData());
		}
		CSV.closeOutputFile();
	}
	
	public Dados()
	{
		
	}
	
	/*
	 * DOCENTES
	 */
	
	public void Carrega_Docentes(String path) throws IOException, NumberFormatException, RepeatedCodeException
	{
		Vector<String[]> docentes_data = CSV.load_data(path);
		for (String[] line : docentes_data)
		{
			this.Adiciona_Docente(line);
		}
	}
	
	public void Adiciona_Docente(Docente d) throws RepeatedCodeException
	{
		if(this.Docentes.contains(d))
		{
			throw new RepeatedCodeException(RepeatedCodeException.Tipo.DOCENTE, String.valueOf(d.getCodigo()));
		}
		Docentes.add(d);
	}
	
	public void Adiciona_Docente(String[] params) throws NumberFormatException, RepeatedCodeException
	{
		this.Adiciona_Docente(new Docente(Integer.parseInt(params[0]), params[1], params[2]));
	}
	
	/*
	 * DISCENTES
	 */
	
	public void Carrega_Discentes(String path) throws IOException, NumberFormatException, RepeatedCodeException
	{
		Vector<String[]> discentes_data = CSV.load_data(path);
		for (String[] line : discentes_data)
		{
			this.Adiciona_Discente(line);
		}
	}
	
	public void Adiciona_Discente(Discente d) throws RepeatedCodeException
	{
		if(this.Discentes.contains(d))
		{
			throw new RepeatedCodeException(RepeatedCodeException.Tipo.DISCENTE, d.getMat());
		}
		Discentes.add(d);
	}
	
	public void Adiciona_Discente(String[] params) throws NumberFormatException, RepeatedCodeException
	{
		Adiciona_Discente(new Discente(params[0], params[1], Integer.parseInt(params[2])));
	}
	
	/*
	 * PRODUÇÕES
	 */
	
	public void Carrega_Producoes(String path) throws IOException, InvalidCodeException
	{
		Vector<String[]> producoes_data = CSV.load_data(path);
		for(String[] line : producoes_data)
		{
			this.Adiciona_Producao(line);
		}
	}
	
	public void Adiciona_Producao(Producao p)
	{
		Producoes.add(p);
	}
	
	public void Adiciona_Producao(String[] params) throws InvalidCodeException
	{
		/*
		 * Params:
		 * 0 - int Codigo
		 * 1 - String Titulo
		 * 2 - "String" qualificada
		 */
		Docente d = this.getDocenteById(Integer.parseInt(params[0]));
		if(d == null)
		{
			throw new InvalidCodeException(InvalidCodeException.Tipo.DOCENTE_PUBLICACAO, params[1], String.valueOf(params[0]));
		}
		// TODO refatorar isso
		if(params.length == 3 && !params[2].equals(" "))
		{
			Producoes.add(new Producao(Integer.parseInt(params[0]), params[1], params[2]));
			d.adicionaProducaoQualificada();
		}
		else
		{
			Producoes.add(new Producao(Integer.parseInt(params[0]), params[1], false));
			d.adicionaProducaoNaoQualificada();
		}
	}
	
	/*
	 * CURSOS
	 */
	
	public void Adiciona_Curso(Curso c) throws RepeatedCodeException
	{
		if(this.Cursos.contains(c))
		{
			throw new RepeatedCodeException(RepeatedCodeException.Tipo.CURSO, String.valueOf(c.getCodigo()));
		}
		this.Cursos.add(c);
	}
	
	public void Adiciona_Curso(String[] params) throws NumberFormatException, RepeatedCodeException
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
	
	public void Carrega_Cursos(String path) throws IOException, NumberFormatException, RepeatedCodeException
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
	
	public void Adiciona_Disciplina(Disciplina d) throws RepeatedCodeException
	{
		if(this.Disciplinas.contains(d))
		{
			throw new RepeatedCodeException(RepeatedCodeException.Tipo.DISCIPLINA, d.getCodigo());
		}
		this.Disciplinas.add(d);
	}
	
	public void Adiciona_Disciplina(String[] params) throws RepeatedCodeException, InvalidCodeException
	{
		/*
		 * Params:
		 * 0 - String codigoAlfa
		 * 1 - String nome
		 * 2 - int codigoDocente
		 * 3 - int cargaSemanal
		 * 4 - int cargaSemestral
		 * 5 - int codigo (do curso)
		 */
		Docente d =  getDocenteById(Integer.parseInt(params[2]));
		if (d == null)
		{
			throw new InvalidCodeException(InvalidCodeException.Tipo.DOCENTE_DISCIPLINA, 
										   String.valueOf(params[2]), params[1]);
		}
		Curso c = getCursoById(Integer.parseInt(params[5]));
		if(c == null)
		{
			throw new InvalidCodeException(InvalidCodeException.Tipo.CURSO_DISCIPLINA,
										   params[1], String.valueOf(params[5]));
		}
		this.Adiciona_Disciplina(new Disciplina(params[0], params[1],
								Integer.parseInt(params[2]), 
								Integer.parseInt(params[3]), 
								Integer.parseInt(params[4]), 
								Integer.parseInt(params[5]),
								d.getNome()));
		c.adicionaHorasADocente(Integer.parseInt(params[2]), Integer.parseInt(params[4]));
		d.adicionaHorasAulaSemanais(Integer.parseInt(params[3]));
		d.adicionaHorasAulaSemestrais(Integer.parseInt(params[4]));
		
	}
	
	public void Carrega_Disciplinas(String path) throws RepeatedCodeException, IOException, InvalidCodeException
	{
		Vector<String[]> disciplinas_data = CSV.load_data(path);
		for (String[] line : disciplinas_data)
		{
			this.Adiciona_Disciplina(line);
		}
	}
	
	/*
	 * ORIENTAÇÕES GRADUAÇÃO
	 */
	
	public void CarregaOrientacoesGrad(String path) throws IOException, InvalidCodeException
	{
		Vector<String[]> orientacoesData = CSV.load_data(path);
		for (String[] line : orientacoesData)
		{
			AdicionaOrientacaoGrad(line);
		}
	}
	
	public void AdicionaOrientacaoGrad(String[] params) throws InvalidCodeException
	{
		/*
		 * Params:
		 * 0 - int codigoDocente
		 * 1 - String matricula
		 * 2 - int codigoCurso
		 * 3 - int horas
		 */
		Docente d = getDocenteById(Integer.parseInt(params[0]));
		Curso c = getCursoById(Integer.parseInt(params[2]));
		String nome = getDiscenteByMat(params[1]).getNome();
		if(d == null)
		{
			throw new InvalidCodeException(InvalidCodeException.Tipo.DOCENTE_ORIENTACAO, nome, params[0]);
		}
		if(c == null)
		{
			throw new InvalidCodeException(InvalidCodeException.Tipo.CURSO_ORIENTACAO, nome, params[2]);
		}
		AdicionaOrientacaoGrad(new OrientacaoGrad(Integer.parseInt(params[0]), params[1],
							   Integer.parseInt(params[2]), Integer.parseInt(params[3])));
		d.adicionaHorasOrientacao(Integer.parseInt(params[3]));
		
	}
	
	public void AdicionaOrientacaoGrad(OrientacaoGrad o)
	{
		this.OrientacoesGrad.add(o);
	}
	
	/*
	 * ORIENTAÇÕES PÓS GRADUAÇÃO
	 */
	
	public void CarregaOrientacoesPos(String path) throws IOException, NumberFormatException, InvalidDateException
	{
		Vector<String[]> orientacoesData = CSV.load_data(path);
		for (String[] line : orientacoesData)
		{
			AdicionaOrientacaoPos(line);
		}
	}
	
	public void AdicionaOrientacaoPos(String[] params) throws NumberFormatException, InvalidDateException
	{
		/*
		 * Params:
		 * 0 - int codigoDocente
		 * 1 - String matricula
		 * 2 - String data
		 * 3 - String programa
		 * 4 - int horas
		 */
		Discente dis = getDiscenteByMat(params[1]);
		Docente doc = getDocenteById(Integer.parseInt(params[0]));
		AdicionaOrientacaoPos(new OrientacaoPos(Integer.parseInt(params[0]), params[1], params[2],
							  params[3], Integer.parseInt(params[4]), dis.getNome()));
		doc.adicionaHorasOrientacao(Integer.parseInt(params[4]));
	}
	
	public void AdicionaOrientacaoPos(OrientacaoPos o)
	{
		this.OrientacoesPos.add(o);
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
	
	public void PrintaOrientacoesPos()
	{
		System.out.println("Orientações de Pós-Graduação:");
		for (OrientacaoPos o : OrientacoesPos)
		{
			System.out.println(o);
		}
	}
	
	public Discente getDiscenteByMat(String mat)
	{
		for(Discente d : Discentes)
		{
			if(d.getMat().equals(mat))
			{
				return d;
			}
		}
		System.out.println("Erro: Discente de matrícula" + mat + "não encontrado");
		return null;
	}
	
	public Docente getDocenteById(int id)
	{
		for(Docente d : Docentes)
		{
			if(d.hasId(id))
			{
				return d;
			}
		}
		System.out.println("Erro: Docente de id " + id + " não encontrado");
		return null;
	}
	
	public String getDocenteDepartamentoById(int id)
	{
		Docente d = getDocenteById(id);
		return d.getDepartamento();
	}
	
	public Curso getCursoById(int codigo)
	{
		for (Curso c : Cursos)
		{
			if(c.getCodigo() == codigo)
			{
				return c;
			}
		}
		return null;
	}
	
	public void DEBUG()
	{
		System.out.println("\n\n");
		PrintaDiscentes();
		System.out.println("\n\n");
		PrintaDocentes();
		System.out.println("\n\n");
		PrintaProducoes();
		System.out.println("\n\n");
		PrintaCursos();
		System.out.println("\n\n");
		PrintaDisciplinas();
		System.out.println("\n\n");
		PrintaOrientacoesGrad();
		System.out.println("\n\n");
		PrintaOrientacoesPos();
	}
}
