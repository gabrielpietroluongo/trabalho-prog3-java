package sistema;

public class OrientacaoGrad 
{
	int codigoDocente;
	String matriculaDiscente;
	int codigoCurso;
	int cargaHorariaSemanal;
	
	public OrientacaoGrad(int codigoD, String mat, int codC, int horas)
	{
		this.codigoDocente = codigoD;
		this.matriculaDiscente = mat;
		this.codigoCurso = codC;
		this.cargaHorariaSemanal = horas;
	}
	
}