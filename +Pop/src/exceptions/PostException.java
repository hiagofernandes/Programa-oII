package exceptions;

public class PostException extends Exception {

	private static final long serialVersionUID = 1L;
	public static final String MENSAGEM_PADRAO = "";

	public PostException(String mensagem) {
		super(MENSAGEM_PADRAO + mensagem);
	}

	public PostException() {
		super(MENSAGEM_PADRAO);
	}

}
