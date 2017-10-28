package usuario;

import java.io.Serializable;

import post.Post;

public class Normal implements TipoUsuario, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public int curtir(Post post) {

		return 10;
	}

	@Override
	public int rejeitar(Post post) {

		return -10;
	}

}
