package sistema;

import java.util.Calendar;

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
		dataIngresso.set(Integer.parseInt(datas[2]), Integer.parseInt(datas[1]), 
						 Integer.parseInt(datas[0]));
	}
	
}
