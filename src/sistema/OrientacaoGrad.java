package sistema;

public class OrientacaoGrad 
{
	private final int codigoDocente;
	private final String matriculaDiscente;
	private final int codigoCurso;
	private final int cargaHorariaSemanal;
	
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