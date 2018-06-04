package sistema;

import java.io.Serializable;

public class Discente implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String matricula;
	private final String nome;
	private final int codigoCurso;
	
	public Discente(String matricula, String nome, int codigo)
	{
		this.matricula = matricula;
		this.nome = nome;
		this.codigoCurso = codigo;
	}
	
	@Override
	public String toString()
	{
		return "Nome: " + this.nome + "\nMatrícula: " + this.matricula + "\nCódigo do curso: " + this.codigoCurso;
	}
	
	@Override
	public boolean equals(Object o)
	{
		Discente d = (Discente) o;
		return d.matricula.equals(this.matricula);
	}
	
	public String getMat() { return this.matricula; }
	
	public String getNome() { return this.nome; }
		
}
