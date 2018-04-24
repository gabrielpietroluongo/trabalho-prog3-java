package sistema;

public class Disciplina
{
	private final String codigoAlfa;
	private String nome;
	private int codigoDocente;
	private int cargaHorariaSemanal;
	private int cargaHorariaSemestral;
	private final int codigoCurso;
	
	public Disciplina(String codigoAlfa, String nome, int codigoDocente, int cargaSemanal, int cargaSemestral, int codigo)
	{
		this.codigoAlfa = codigoAlfa;
		this.nome = nome;
		this.cargaHorariaSemanal = cargaSemanal;
		this.cargaHorariaSemestral = cargaSemestral;
		this.codigoCurso = codigo;
		this.codigoDocente = codigoDocente;
	}
	
	@Override
	public String toString()
	{
		return "Nome da disciplina: " + this.nome + "\nCódigo Alfanumérico: " + this.codigoAlfa + 
				"\nCódigo da disciplina: " + this.codigoCurso + "\nCódigo do docente: " + this.codigoDocente + 
				"\nCarga Horária Semanal: " + this.cargaHorariaSemanal + "\nCarga horária Semestral: " + this.cargaHorariaSemestral;
	}
	
	public int getCodigoDocente() { return this.codigoDocente; }
	
}
