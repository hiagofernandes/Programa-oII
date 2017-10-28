package post;

public class Imagem extends Midia {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Imagem(String conteudo) {
		super(conteudo);

	}
	
	public String toString(){
		return "$arquivo_imagem:"+super.getConteudo();
	}

}
