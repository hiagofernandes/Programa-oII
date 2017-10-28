package notificoes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Notificacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> notificacoes;

	public Notificacao() {
		
		notificacoes = new ArrayList<String>();

	}

	public List<String> getNotificacoes() {
		return notificacoes;
	}

	public void adicionaNotificacao(String mensagem) {
		this.notificacoes.add(mensagem);
	}

	public String getNextNotificacao() {
		String notificacao = this.notificacoes.get(0);
		this.notificacoes.remove(0);
		return notificacao;
	}

}
