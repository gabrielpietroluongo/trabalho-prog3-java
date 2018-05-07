package sistema;

import java.util.Calendar;
import java.util.Calendar.*;

public class OrientacaoPos 
{
	int codigoDocente;
	String matriculaDiscente;
	Calendar dataIngresso;
	String programa;
	int cargaHoraria;
	
	public OrientacaoPos(int codigoD, String mat, String data, String programa, int horas)
	{
		this.codigoDocente = codigoD;
		this.matriculaDiscente = mat;
		this.programa = programa;
		this.cargaHoraria = horas;
		String[] datas = data.split("/");
		for (String n : datas)
		{
			System.out.println(n);

		}
		this.dataIngresso = Calendar.getInstance();
		dataIngresso.set(Integer.parseInt(datas[2]), Integer.parseInt(datas[1]), 
						 Integer.parseInt(datas[0]));
	}
	
	@Override
	public String toString()
	{
		return "Código do docente: " + this.codigoDocente + "\nMatrícula do discente: " + this.matriculaDiscente
				+ "\nData de ingresso: " + this.dataIngresso.get(Calendar.DAY_OF_MONTH) + "/" + 
				this.dataIngresso.get(Calendar.MONTH) + "/" + this.dataIngresso.get(Calendar.YEAR) + 
				"\nPrograma: " + this.programa +  "\nCarga Horária: " + this.cargaHoraria;
	}
	
}
