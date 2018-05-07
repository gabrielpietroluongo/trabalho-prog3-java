package sistema;

public class OrientacaoGraduacao 
{
	int codigoDocente;
	String matriculaDiscente;
	int codigoCurso;
	int cargaHorariaSemanal;
	
	public OrientacaoGraduacao(int codigoD, String mat, int codC, int horas)
	{
		this.codigoDocente = codigoD;
		this.matriculaDiscente = mat;
		this.codigoCurso = codC;
		this.cargaHorariaSemanal = horas;
	}
	
}