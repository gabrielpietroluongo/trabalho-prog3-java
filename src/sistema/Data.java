package sistema;

import java.util.Vector;


public class Data
{
	public Vector<Docente> Docentes = new Vector<Docente>();
	public Vector<Discente> Discentes = new Vector<Discente>();
	
	public Data()
	{
		
	}
	
	public void Adiciona_Docente(Docente d)
	{
		// TODO talvez checar se o docente ja existe no vetor?
		Docentes.addElement(d);
	}
	
	public void Adiciona_Discente(Discente d)
	{
		// TODO talvez checar se o docente ja existe no vetor?
		for (Discente discente : this.Discentes)
		{
			if(discente.equals(d))
			{
				System.out.println("Erro: O discente já existe");
				return;
				//throw();
			}
		}
		Discentes.addElement(d);
	}
	
	public void PrintaDiscentes()
	{
		for (Discente d : Discentes)
		{
			System.out.println(d);
		}
	}
	
	public static void AdicionaHorasAulaADocente(Disciplina d, int codigoDocente)
	{
		
	}
	
}
