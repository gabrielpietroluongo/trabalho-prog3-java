package sistema;

public class Curso
{
	private final int codigo;
	private String nome;
	private boolean graduacao;
	
	public Curso(int codigo, String nome, String graduacao, String posGraduacao)
	{
		this.codigo = codigo;
		this.nome = nome;
		//TODO checar casos de contorno (as duas strings vazias, as duas strings diferentes de "X")
		if(graduacao == "X")
		{
			this.graduacao = true;
		}
		else
		{
			this.graduacao = false;
		}
	}
	
	@Override
	public String toString()
	{
		return "Nome do curso: " + this.nome + "\nCódigo do curso: " + this.codigo + "\nÉ graduação: " + this.graduacao;
	}
	
}
