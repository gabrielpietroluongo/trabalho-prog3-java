package sistema;

public class Producao
{
	private final int codigo;
	private final String titulo;
	private boolean qualificada;
	
	public Producao(int codigo, String titulo, String qualificada)
	{
		this.codigo = codigo;
		this.titulo = titulo;
		if(qualificada == "X")
			this.qualificada = true;
		else
			this.qualificada = false;
	}
	
	public Producao(int codigo, String titulo, boolean qualificada)
	{
		this.codigo = codigo;
		this.titulo = titulo;
		this.qualificada = qualificada;
	}
	
	@Override
	public String toString()
	{
		return "TÌtulo: " + this.titulo + "\nCÛdigo: " + this.codigo + "\n… qualificada: " + this.qualificada;
	}
}
