package exceptions;

import java.util.Date;
import java.text.SimpleDateFormat;

public class InvalidDateException extends Exception 
{

	private final String message;
	
	private static final long serialVersionUID = 1L;

	private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
	
	public InvalidDateException(String nome, Date date)
	{
		this.message = "Data de ingresso do aluno \"" + nome + "\" está no futuro: " + formatter.format(date) + ".";
	}
	
	@Override
	public String toString()
	{
		return this.message;
	}

}
