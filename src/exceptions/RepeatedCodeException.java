package exceptions;

public class RepeatedCodeException extends Exception 
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
	
	public RepeatedCodeException(Tipo t, String code)
	{
		String msg = "";
		this.tipo = t;
		long code_conv = Long.parseLong(code);
		switch(this.tipo)
		{
			case DOCENTE:
				msg = "Código repetido para docente: " + code_conv + ".";
				break;
			case DISCENTE:
				msg = "Código repetido para discente: " + code_conv + ".";
				break;
			case CURSO:
				msg = "Código repetido para curso: " + code_conv + ".";
				break;
			case DISCIPLINA:
				msg = "Código repetido para disciplina: " + code_conv + ".";
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
