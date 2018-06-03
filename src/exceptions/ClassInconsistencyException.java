package exceptions;

public class ClassInconsistencyException extends Exception 
{
	private static final long serialVersionUID = 1L;
	private final String msg;
	
	public ClassInconsistencyException(String codigo, String nome)
	{
		this.msg = "Inconsistência ao definir o nível do curso: " + codigo + " - " + nome + ".";
	}
	
	@Override
	public String toString()
	{
		return this.msg;
	}
}
