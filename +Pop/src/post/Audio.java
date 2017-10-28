package post;

public class Audio extends Midia {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Audio(String conteudo) {
		super(conteudo);

	}

	public String toString(){
		return "$arquivo_audio:"+super.getConteudo();
	}
}
