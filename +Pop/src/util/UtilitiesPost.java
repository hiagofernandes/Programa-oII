package util;

import java.io.Serializable;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.List;

import exceptions.MensagemInvalidaException;
import post.Audio;
import post.Hashtag;
import post.Imagem;
import post.Midia;
import post.Post;

public class UtilitiesPost implements Serializable {

	private static final long serialVersionUID = 1L;

	public UtilitiesPost() {

	}

	public LocalDateTime dataPostFormatChange(String data) {

		String[] newDateAndHour = data.split(" ");

		String[] newDate = newDateAndHour[0].split("/");
		String[] newHour = newDateAndHour[1].split(":");

		int dia = Integer.parseInt(newDate[0]);
		int mes = Integer.parseInt(newDate[1]);
		int ano = Integer.parseInt(newDate[2]);

		int hora = Integer.parseInt(newHour[0]);
		int minuto = Integer.parseInt(newHour[1]);
		int segundo = Integer.parseInt(newHour[2]);

		LocalDateTime dateAndHour = LocalDateTime.of(ano, mes, dia, hora, minuto, segundo);

		return dateAndHour;

	}
	
	// Formato da Data em String
	public String DataEhora(LocalDateTime data){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String text = data.format(formatter);
		return text;
	}

	public void verificaPost(String mensagem) throws MensagemInvalidaException {

		if (mensagem == null) {
			throw new MensagemInvalidaException("Campo mensagem nao pode ser nulo");
		}
		if (mensagem.trim().equals("")) {
			throw new MensagemInvalidaException("Campo da mensagem nao pode ser vazio!");
		}

		String mensagemModificada = capturaTexto(mensagem);
		
		if (mensagemModificada.length() > Post.getNumeroMaximoDeCaracteres()) {
			throw new MensagemInvalidaException(
					"Nao eh possivel criar o post. O limite maximo da mensagem sao 200 caracteres.");
		}

	}

	
	public void adicionaConteudo(List<String> conteudo,List<Midia> midia, String msg){
		conteudo.add(msg);
		for (int i = 0; i < midia.size(); i++) {
			conteudo.add(midia.get(i).toString());
		}
	}
	
	
	public void capturaHashTags(List<Hashtag> hashtags, String mensagem) throws Exception {
		
		String[] palavras = mensagem.split(" ");
		
		int controleFor = 0;
		
		for (String palavra : palavras) {
			if (controleFor > 0 && palavra.startsWith("#") == false) {
				throw new Exception("Nao eh possivel criar o post. As hashtags devem comecar com '#'. Erro na hashtag: "+"'"+palavra+"'.");
			}
			else if (palavra.startsWith("#")) {
				controleFor += 1;
				adicionaHashtag(hashtags, palavra);
			} 
		}
	}

	public void adicionaHashtag(List<Hashtag> hashtags, String palavra){
		
		Hashtag novaHashtag = new Hashtag(palavra);
		
		for (int i = 0; i < hashtags.size(); i++ ) {
			if (hashtags.get(i).getNome().equals(palavra)) {
				hashtags.get(i).aumentaQtde(1);
			} else{
				novaHashtag = new Hashtag(palavra);
			}
		}
		
		hashtags.add(novaHashtag);
	}
	
	
	
	public void capturaAudio(List<Midia> conteudo,String mensagem) {

		String[] palavras = mensagem.split("<audio>");

		for (String palavra : palavras) {
			if (palavra.startsWith("musicas")) {
				String[] palavras2 = palavra.split("</audio>");
				for (String palavraModificada : palavras2) {
					if (palavraModificada.startsWith("musicas")) {
						Audio audio = new Audio(palavraModificada);
						conteudo.add(audio);
					}
				}
			}
		}

	}

	public void capturaImagem(List<Midia> conteudo,String mensagem) {

		String[] palavras = mensagem.split("<imagem>");

		for (String palavra : palavras) {
			if (palavra.startsWith("imagens")) {
				String[] palavras2 = palavra.split("</imagem>");
				for (String palavraModificada : palavras2) {
					if (palavraModificada.startsWith("imagens")) {
						Imagem imagem = new Imagem(palavraModificada);
						conteudo.add(imagem);
					}
				}
			}
		}
		
		

	}

	public String capturaTexto(String mensagem) {

		String msgSeparada = "";
		String[] palavras = mensagem.split("\\s*[#]|\\s*[<]");

		int i = 1;
		for (String palavra : palavras) {
			if (i == 1) {
				msgSeparada = palavra;
				i = i + 1;
			}
		}

		return msgSeparada;
	}
	
	
	public String capturaMsg(String mensagem) {

		String msgSeparada = "";
		String[] palavras = mensagem.split("\\s*[#]");

		int i = 1;
		for (String palavra : palavras) {
			if (i == 1) {
				msgSeparada = palavra;
				i = i + 1;
			}
		}

		return msgSeparada;
	}
	
	
}
