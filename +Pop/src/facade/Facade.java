package facade;

import java.io.FileNotFoundException;
import java.io.IOException;

import controller.Controller;

public class Facade {

	private Controller controller;

	public Facade() {
		this.controller = new Controller();
	}

	public void iniciaSistema() {
		this.controller.iniciaSistema();
	}

	public void fechaSistema() throws Exception {
		this.controller.fechaSistema();
	}

	public String cadastraUsuario(String nome, String email, String senha, String dataNascimento, String imagem)
			throws Exception {

		this.controller.cadastrarUsuario(nome, email, senha, dataNascimento, imagem);
		return email;
	}

	public String cadastraUsuario(String nome, String email, String senha, String dataNascimento) throws Exception {

		this.controller.cadastrarUsuario(nome, email, senha, dataNascimento);
		return email;
	}

	// Login e Logout
	public void login(String email, String senha) throws Exception {
		this.controller.login(email, senha);
	}

	public void logout() throws Exception {
		this.controller.logout();
	}

	// Adiciona amigo
	public void adicionaAmigo(String email) throws Exception {
		this.controller.adicionaAmigo(email);
	}

	// Remover amigo
	public void removeAmigo(String email) throws Exception {
		this.controller.removeAmigo(email);
	}

	// Aceita Amizade
	public void aceitaAmizade(String email) throws Exception {
		this.controller.aceitaAmizade(email);
	}

	// Rejeita Amizade
	public void rejeitaAmizade(String email) throws Exception {
		this.controller.rejeitaAmizade(email);
	}

	// Post
	public void criaPost(String mensagem, String data) throws Exception {
		this.controller.criaPost(mensagem, data);
	}

	public void curtirPost(String email, int pops) {
		
		this.controller.curtirPost(email, pops);

	}

	public void adicionaPops(int pops) {
		this.controller.adicionaPops(pops);
	}
	
	public void getTotalPost() {
		this.controller.getTotalPosts();
	}

	// Remove Usuario
	public void removeUsuario(String usuario) throws Exception {
		this.controller.removeUsuario(usuario);
	}

	// Atualiza Perfil
	public void atualizaPerfil(String atributo, String valor) throws Exception {
		this.controller.atualizaPerfil(atributo, valor);
	}

	public void atualizaPerfil(String atributo, String valor, String velhaSenha) throws Exception {
		this.controller.atualizaPerfil(atributo, valor, velhaSenha);
	}

	// Getters
	public String getNome(String email) throws Exception {
		return this.controller.getNome(email);
	}

	public String getInfoUsuario(String atributo, String usuario) throws Exception {
		return this.controller.getInfoUsuario(atributo, usuario);
	}

	public String getInfoUsuario(String atributo) throws Exception {
		return this.controller.getInfoUsuario(atributo);
	}

	public int getQtdAmigos() {
		return this.controller.getQtdAmigos();
	}

	public int getNotificacoes() {
		return this.controller.getNotificacoes();
	}

	public String getNextNotificacao() throws Exception {
		return this.controller.getNextNotificacao();
	}
	
	public String getPost(String atributo, int post) throws Exception{	
		return this.controller.getPost(atributo, post);
	}
	
	public String getPost(int post){	
		return this.controller.getPost(post);
	}
	
	public String getConteudoPost(int indice, int post) throws Exception{
		return this.controller.getConteudoPost(indice, post);
	}
	
	public String getPopularidade() {
		return this.controller.getPopularidade();
	}
	
	public void rejeitarPost(String amigo, int post) throws FileNotFoundException, ClassNotFoundException, IOException{
		this.controller.rejeitarPost(amigo, post);
	}
	
	public int getPopsPost(int post){
		return this.controller.getPopsPost(post);
	}
	
	public int qtdCurtidasDePost(int post){
		return this.controller.qtdCurtidasDePost(post);
	}
	
	public int qtdRejeicoesDePost(int post){
		return this.controller.qtdRejeicoesDePost(post);
	}
	
	public int getPopsUsuario(String usuario) throws Exception{
		return this.controller.getPopsUsuario(usuario);
	}
	
	public int getPopsUsuario(){
		return this.controller.getPopsUsuario();
	}
	
}