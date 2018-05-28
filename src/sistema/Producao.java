package sistema;

import java.io.Serializable;

public class Producao implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int codigo;
	private final String titulo;
	private final boolean qualificada;
	
	public Producao(int codigo, String titulo, String qualificada)
	{
		this.codigo = codigo;
		this.titulo = titulo;
		if(qualificada.equals("X"))
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
		return "Título: " + this.titulo + "\nCódigo: " + this.codigo + "\nÉ qualificada: " + this.qualificada;
	}
}
