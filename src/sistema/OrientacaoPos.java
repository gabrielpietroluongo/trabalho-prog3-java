package sistema;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class OrientacaoPos 
{
	private final int codigoDocente;
	private final String matriculaDiscente;
	private final Date dataIngresso;
	private final String programa;
	private final int cargaHoraria;
	
	public OrientacaoPos(int codigoD, String mat, String data, String programa, int horas)
	{
		this.codigoDocente = codigoD;
		this.matriculaDiscente = mat;
		this.programa = programa;
		this.cargaHoraria = horas;
		String[] datas = data.split("/");
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(datas[2]), Integer.parseInt(datas[1]), 
						 Integer.parseInt(datas[0]));
		this.dataIngresso = c.getTime();
	}
	
	@Override
	public String toString()
	{
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		return "Código do docente: " + this.codigoDocente + "\nMatrícula do discente: " + this.matriculaDiscente
				+ "\nData de ingresso: " + df.format(this.dataIngresso) + 
				"\nPrograma: " + this.programa +  "\nCarga Horária: " + this.cargaHoraria;
	}
	
}
