package sistema;

public class Curso
{
	int codigo;
	String nome;
	boolean graduacao;
	
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
	
}
