package exceptions;

public class InvalidCodeException extends Exception 
{
	public enum Tipo
	{
		DOCENTE,
		DISCENTE,
		CURSO,
		DISCIPLINA
	}
	
	private final String message;
	
	private static final long serialVersionUID = 1L;

	private Tipo tipo;
	
	public InvalidCodeException(Tipo t, String code)
	{
		String msg = "";
		this.tipo = t;
		switch(this.tipo)
		{
			case DOCENTE:
				msg = "Código repetido para docente: " + code;
				break;
			case DISCENTE:
				msg = "Código repetido para discente: " + code;
				break;
			case CURSO:
				msg = "Código repetido para curso: " + code;
				break;
			case DISCIPLINA:
				msg = "Código repetido para disciplina: " + code;
				break;
		}
		this.message = msg;
	}
	
	@Override
	public String toString()
	{
		return this.message;
	}
	
}
