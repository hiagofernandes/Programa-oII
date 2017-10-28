package post;

import java.io.Serializable;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import util.UtilitiesPost;

public class Post implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final int NUMERO_MAXIMO_DE_CARACTERES = 200;

	private UtilitiesPost utilPost;
	
	private String mensagemInicial;
	
	private List<Hashtag> hashtags;
	private List<Midia> midia;
	private List<String> conteudoDoPost;
	
	
	private int like;
	private int deslike;
	private int popularidade;
	
	private LocalDateTime dataCriacao;
	private String texto;

	public Post(String msg, LocalDateTime data) throws Exception {
		
		this.mensagemInicial = msg;
		
		this.popularidade = 0;
		this.like = 0;
		this.deslike = 0;

		this.utilPost = new UtilitiesPost();
		this.conteudoDoPost = new ArrayList<String>();
		
		this.midia = new ArrayList<Midia>();
		this.hashtags = new ArrayList<Hashtag>();
		this.texto = new String();
		this.texto = utilPost.capturaTexto(msg);
		
		this.utilPost.capturaAudio(this.midia,msg);
		this.utilPost.capturaHashTags(this.hashtags,msg);
		this.utilPost.capturaImagem(this.midia,msg);

		this.dataCriacao = data;
		
		this.utilPost.adicionaConteudo(conteudoDoPost, midia, texto);

	}

	public void adicionaHashtag(String nome){
		this.utilPost.adicionaHashtag(this.hashtags, nome);
	}
	
	public static int getNumeroMaximoDeCaracteres() {
		return NUMERO_MAXIMO_DE_CARACTERES;
	}

	public int getPopularidade() {
		return this.popularidade;
	}

	public List<Midia> getMidia() {
		return midia;
	}

	public List<String> getConteudoDoPost() {
		return conteudoDoPost;
	}
	
	public void pops(int pops) {
		this.popularidade += pops;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	public String getDataEHora() {
		return this.utilPost.DataEhora(this.getDataCriacao()) ;
	}
	
	public String getTexto() {
		return texto;
	}

	public String getMensagem() {
		return this.utilPost.capturaMsg(this.mensagemInicial);
	}
	
	public List<Hashtag> getHashtags() {
		return hashtags;
	}
	
	public String getListaHashtags(){
		String hashtags = "";
		for (int i = 0; i < this.hashtags.size(); i++ ) {
			if(hashtags.equals("")){
				hashtags += this.hashtags.get(i).getNome();
			} else{
				hashtags += "," + this.hashtags.get(i).getNome();
			}
			
		 }
		return hashtags;
	}

	
	
	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like += like;
	}

	public void setDeslike(int deslike) {
		this.deslike += deslike;
	}

	public int getDeslike() {
		return deslike;
	}


	public String toString(){
		return this.mensagemInicial + " (" + this.getDataEHora() +")";
	}


}
