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
	
	//PAD
	public String[] getCSVData()
	{
		String[] ret = new String[7];
		ret[0] = this.nome;
		ret[1] = this.departamento;
		ret[2] = String.valueOf(this.horasAulaSemanais);
		ret[3] = String.valueOf(this.horasAulaSemestrais);
		ret[4] = String.valueOf(this.horasOrientacaoSemanais);
		ret[5] = String.valueOf(this.producoesQualificadas);
		ret[6] = String.valueOf(this.producoesNaoQualificadas); 
		return ret;
	}
	
	public boolean hasId(int id)
	{
		return this.codigo == id;
	}
	
	public String getDepartamento() { return this.departamento; }
	
	//TODO dar override no .equals() dessa classe
	
}
