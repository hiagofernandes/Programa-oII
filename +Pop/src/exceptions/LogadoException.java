package exceptions;

public class LogadoException extends Exception {
	private static final long serialVersionUID = 1L;
	public static final String MENSAGEM_PADRAO = " Nenhum usuarix esta logadx no +pop.";

	public LogadoException(String mensagem) {
		super(mensagem + MENSAGEM_PADRAO);
	}

	public LogadoException() {
		super(MENSAGEM_PADRAO);
	}
}
