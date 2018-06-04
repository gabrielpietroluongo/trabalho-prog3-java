package exceptions;

public class InvalidCodeException extends Exception
{
	public enum Tipo
	{
		DOCENTE_DISCIPLINA,
		DOCENTE_ORIENTACAO,
		DOCENTE_PUBLICACAO,
		CURSO_ORIENTACAO,
		CURSO_DISCIPLINA
	}
	
	private final String message;
	
	private static final long serialVersionUID = 1L;

	private Tipo tipo;
	
	public InvalidCodeException(Tipo t, String code, String name)
	{
		this.tipo = t;
		String msg = "";
		switch(this.tipo)
		{
			case DOCENTE_DISCIPLINA:
				msg = "Código de docente inválido na disciplina \"" + name + "\": " + code + ".";
				break;
			case DOCENTE_ORIENTACAO:
				msg = "Código de docente inválido na orientação do aluno \"" + name + "\": " + code + ".";
				break;
			case DOCENTE_PUBLICACAO:
				msg = "Código de docente inválido na publicação \"" + name + "\": " + code + ".";
				break;
			case CURSO_ORIENTACAO:
				msg = "Código de curso inválido na orientação do aluno \"" + name + "\": " + code + ".";
				break;
			case CURSO_DISCIPLINA:
				msg = "Código de curso inválido na disciplina \"" + name + "\": " + code + ".";
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
