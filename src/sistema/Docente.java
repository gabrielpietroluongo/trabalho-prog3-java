package sistema;


public class Docente
{
	private final int codigo;
	private String nome;
	private String departamento;
	
	public Docente(int codigo, String nome, String departamento)
	{
		this.codigo = codigo;
		this.nome = nome;
		this.departamento = departamento;
	}
	
	public int getCodigo() { return this.codigo; }
	
	@Override
	public String toString()
	{
		return "Nome: " + this.nome + "\nCódigo: " + this.codigo + "\nDepartamento: " + this.departamento;
	}
	
}
