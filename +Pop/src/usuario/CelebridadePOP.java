package usuario;

import java.io.Serializable;
import java.time.LocalDate;

import post.Post;

public class CelebridadePOP implements TipoUsuario, Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDate dataAtual;

	@Override
	public int curtir(Post post) {

		int popsTotais = 25;

		if (dataAtual.toString().equals(post.getDataCriacao().toString())) {
			popsTotais += 10;
		}

		return popsTotais;
	}

	@Override
	public int rejeitar(Post post) {
		int popsTotais = -25;

		if (dataAtual.toString().equals(post.getDataCriacao().toString())) {
			popsTotais -= 10;
		}

		return popsTotais;
	}

}
