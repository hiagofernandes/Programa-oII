package post;

import java.io.Serializable;

public abstract class Midia implements Serializable {

	private static final long serialVersionUID = 1L;

	private String conteudo;

	public Midia(String conteudo) {
		this.conteudo = conteudo;

	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public String toString(){
		return "";
	}

}
