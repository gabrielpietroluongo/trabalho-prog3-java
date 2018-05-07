package sistema;


public class Docente
{
	private final int codigo;
	private final String nome;
	private final String departamento;
	
	// TODO implementar as variaveis abaixo
	
	int horasAulaSemanais = 0;
	int horasAulaSemestrais = 0;
	int horasOrientacaoSemanais = 0;
	int horasOrientacaoSemestrais = 0;
	int producoesQualificadas = 0;
	int producoesNaoQualificadas = 0;
	
	
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
	
	//TODO dar override no .equals() dessa classe
	
}
