package usuario;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import notificoes.Notificacao;
import post.Post;

public class Usuario implements Comparable<Usuario>, Serializable {

	private static final long serialVersionUID = 1L;

	private String nome, email, senha, imagem;
	private LocalDate dataDeNascimento;
	private TipoUsuario tipoUsuario;

	private List<Usuario> amigos;

	private Notificacao notificacoes;

	private List<String> pedidosDeAmizade;
	private List<Post> postagens;

	private int pops;

	public Usuario(String nome, String email, String senha,
			LocalDate dataNascimento, String imagem) throws Exception {

		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.imagem = imagem;
		this.dataDeNascimento = dataNascimento;
		this.amigos = new ArrayList<Usuario>();
		this.notificacoes = new Notificacao();
		this.pedidosDeAmizade = new ArrayList<String>();
		this.postagens = new ArrayList<Post>();
		this.tipoUsuario = new Normal();

	}

	public void adicionaAmigo(Usuario usuario) {
		this.amigos.add(usuario);
	}

	public void removeAmigo(Usuario usuario) {
		for (int i = 0; i < this.amigos.size(); i++) {
			if (this.amigos.get(i).equals(usuario)) {
				this.amigos.remove(i);
			}
		}
	}

	public void rejeitaAmizade(String email) {
		int qtdeDePedidos = getPedidosDeAmizade().size();

		for (int i = 0; i < qtdeDePedidos; i++) {
			if (getPedidosDeAmizade().get(i).equals(email)) {
				this.pedidosDeAmizade.remove(i);
			}
		}
	}

	public void adicionaPedidoDeAmizade(String email) {
		this.pedidosDeAmizade.add(email);
	}

	// Getters
	public String getEmail() {
		return this.email;
	}

	public String getImagem() {
		return this.imagem;
	}

	public String getSenha() {
		return this.senha;
	}

	public LocalDate getDataNascimento() {
		return this.dataDeNascimento;
	}

	public String getNome() {
		return this.nome;
	}

	public List<Usuario> getAmigos() {
		return this.amigos;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public List<String> getPedidosDeAmizade() {
		return this.pedidosDeAmizade;
	}

	public Notificacao getNotificacoes() {
		return notificacoes;
	}

	public List<Post> getPost() {
		return this.postagens;
	}

	public String getTipoUsuarioString() {
		if (pops < 500) {
			return "Normal Pop";
		} else if (pops >= 500 && pops < 1000) {
			return "Celebridade Pop";
		}
		return "Icone Pop";
	}

	// Setters
	public void setEmail(String email) {
		this.email = email;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setNome(String nome) throws Exception {
		this.nome = nome;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataDeNascimento = dataNascimento;
	}

	public void setPops(int pops) {
		this.pops = pops;
	}

	// Post

	public void adicionarPostagem(Post post) {
		postagens.add(post);
	}

	public void deletarPostagem(Post post) {
		postagens.remove(post);
	}

	public int calculaPopularidade() {
		int popularidade = 0;
		for (Post post : postagens) {
			popularidade += post.getPopularidade();
		}
		return popularidade;
	}

	// Curtir e Rejeitar

	public Post getPost(int index) {

		return this.postagens.get(index);
	}

	public void curtir(Post post) {
		this.verificaTipoDeUsuario();
		int pops = tipoUsuario.curtir(post);
		post.pops(pops);
		post.setLike(1);

	}

	public void rejeitar(Post post) {

		post.pops(tipoUsuario.rejeitar(post));
		post.setDeslike(1);

	}

	// Mudança dinamica

	private void changeToUsuarioNormal() {

		tipoUsuario = new Normal();

	}

	private void changeToUsuarioCelebridadePOP() {

		tipoUsuario = new CelebridadePOP();

	}

	private void changeToUsuarioIconePOP() {

		tipoUsuario = new IconePOP();

	}

	private void verificaTipoDeUsuario() {

		if (pops < 500) {
			changeToUsuarioNormal();
		} else if (pops >= 500 && pops < 1000) {
			changeToUsuarioCelebridadePOP();
		} else {
			changeToUsuarioIconePOP();
		}

	}

	public void adicionaNotificacao(String msg) {
		this.notificacoes.adicionaNotificacao(msg);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario u = (Usuario) obj;
			return this.getEmail().equals(u.getEmail());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Nome: " + getNome() + ";" + " Email: " + getEmail();
	}

	// Metodo de comparacao entre usuarios para ordenacao
	@Override
	public int compareTo(Usuario otherUser) {

		return 0;
	}

}