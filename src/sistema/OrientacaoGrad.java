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
	
	@Override
	public String toString()
	{
		return "Código do docente: " + this.codigoDocente + "\nMatrícula do discente: " + this.matriculaDiscente
				+ "\nCódigo do Curso: " + this.codigoCurso + "\nCarga Horária Semanal: " + this.cargaHorariaSemanal;
	}
	
}