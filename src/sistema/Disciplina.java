package sistema;

import java.text.Collator;
import java.util.Locale;

public class Disciplina implements Comparable<Disciplina>
{
	private final String codigoAlfa;
	private final String nome;
	private final int codigoDocente;
	private final int cargaHorariaSemanal;
	private final int cargaHorariaSemestral;
	private final int codigoCurso;
	private final String nomeDocente;
	
	public Disciplina(String codigoAlfa, String nome, int codigoDocente, int cargaSemanal, int cargaSemestral, int codigo, String nomeDocente)
	{
		this.codigoAlfa = codigoAlfa;
		this.nome = nome;
		this.cargaHorariaSemanal = cargaSemanal;
		this.cargaHorariaSemestral = cargaSemestral;
		this.codigoCurso = codigo;
		this.codigoDocente = codigoDocente;
		this.nomeDocente = nomeDocente;
	}
	
	// Alocações
	public String[] getCSVData()
	{
		String[] ret = {
				this.nomeDocente,
				this.codigoAlfa,
				this.nome,
				String.valueOf(this.cargaHorariaSemestral)
		};
		return ret;
	}
	
	@Override
	public String toString()
	{
		return "Nome da disciplina: " + this.nome + "\nCódigo Alfanumérico: " + this.codigoAlfa + 
				"\nCódigo da disciplina: " + this.codigoCurso + "\nCódigo do docente: " + this.codigoDocente + 
				"\nCarga Horária Semanal: " + this.cargaHorariaSemanal + "\nCarga horária Semestral: " + this.cargaHorariaSemestral;
	}

	@Override
	public int compareTo(Disciplina arg0) 
	{
		Collator coll = Collator.getInstance(new Locale("pt", "BR"));
		coll.setStrength(Collator.IDENTICAL);
		int cmp = coll.compare(this.nomeDocente, arg0.nomeDocente);
		if (cmp == 0)
		{
			return coll.compare(this.codigoAlfa, this.codigoAlfa);
		}
		return cmp;
	}
	
}
