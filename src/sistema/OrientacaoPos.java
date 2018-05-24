package sistema;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class OrientacaoPos implements Comparable<OrientacaoPos>
{
	private final int codigoDocente;
	private final String matriculaDiscente;
	private final Date dataIngresso;
	private final String programa;
	private final int cargaHoraria;
	private final String nomeDiscente;
	
	private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
	
	public OrientacaoPos(int codigoD, String mat, String data, String programa, int horas, String nomeDiscente)
	{
		this.codigoDocente = codigoD;
		this.matriculaDiscente = mat;
		this.programa = programa;
		this.cargaHoraria = horas;
		this.nomeDiscente = nomeDiscente;
		String[] datas = data.split("/");
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(datas[2]), Integer.parseInt(datas[1])-1, 
						 Integer.parseInt(datas[0]));
		this.dataIngresso = c.getTime();
	}
	
	public String[] getCSVData()
	{
		String[] ret = {
				this.programa,
				formatter.format(this.dataIngresso),
				this.matriculaDiscente,
				this.nomeDiscente
		};
		return ret;
	}
	
	@Override
	public String toString()
	{
		return "Código do docente: " + this.codigoDocente + "\nMatrícula do discente: " + this.matriculaDiscente
				+ "\nData de ingresso: " + formatter.format(this.dataIngresso) + 
				"\nPrograma: " + this.programa +  "\nCarga Horária: " + this.cargaHoraria;
	}

	@Override
	public int compareTo(OrientacaoPos arg0) 
	{
		Collator coll = Collator.getInstance(new Locale("pt", "BR"));
		coll.setStrength(Collator.IDENTICAL);
		int cmp = coll.compare(this.programa, arg0.programa);
		if(cmp == 0)
		{
			if(this.dataIngresso.before(arg0.dataIngresso))
			{
				return -1;
			}
			else
			{
				return coll.compare(this.nomeDiscente, arg0.nomeDiscente);
			}
		}
		return cmp;
	}
	
}
