package usuario;

import java.io.Serializable;

import post.Post;

public class IconePOP implements TipoUsuario, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public int curtir(Post post) {
		post.adicionaHashtag("#epicwin");
		return 50;

	}

	@Override
	public int rejeitar(Post post) {
		post.adicionaHashtag("#epicfail");
		return -50;

	}

}
