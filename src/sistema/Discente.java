package sistema;

public class Discente
{
	private final String matricula;
	private String nome;
	private int codigoCurso;
	
	public Discente(String matricula, String nome, int codigo)
	{
		this.matricula = matricula;
		this.nome = nome;
		this.codigoCurso = codigo;
	}
	
	@Override
	public String toString()
	{
		return "Nome: " + this.nome + "\nMatr�cula: " + this.matricula + "\nC�digo do curso: " + this.codigoCurso;
	}
	
}
