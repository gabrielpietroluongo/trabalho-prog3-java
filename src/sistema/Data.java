package sistema;

import java.util.Vector;


public class Data
{
	public Vector<Docente> Docentes = new Vector<Docente>();
	public Vector<Discente> Discentes = new Vector<Discente>();
	public Vector<Producao> Producoes = new Vector<Producao>();
	
	public Data()
	{
		
	}
	
	public void Adiciona_Docente(Docente d)
	{
		// TODO talvez checar se o docente ja existe no vetor?
		Docentes.addElement(d);
	}
	
	public void Adiciona_Docente(String[] params)
	{
		Docentes.addElement(new Docente(Integer.parseInt(params[0]), params[1], params[2]));
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
	
	
	public void PrintaDiscentes()
	{
		for (Discente d : Discentes)
		{
			System.out.println(d);
		}
	}
	
	
	
	//TODO
	public static void AdicionaHorasAulaADocente(Disciplina d, int codigoDocente)
	{
		
	}
	
}