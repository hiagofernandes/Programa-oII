package util;

import java.io.Serializable;


import exceptions.DadoInvalidoException;
import exceptions.LoginException;
import usuario.Usuario;

public class UtilitiesController implements Serializable {

	private static final long serialVersionUID = 1L;

	public UtilitiesUser utilUser;

	public UtilitiesController() {

		utilUser = new UtilitiesUser();

	}

	// Metodo que verificar se há algum usuario logado
	public void isUsuarioLogado(String msg, Usuario logado)
			throws LoginException {
		if (logado == null) {
			throw new LoginException(msg);
		}
	}

	// Metodo q verifica dados do cadastrarUsuario
	public void verificacao(String nome, String email, String senha, String data) throws DadoInvalidoException {
			utilUser.isNomeValido(nome);
			utilUser.isSenhaValida(senha);
			utilUser.isDataValida(data);
			utilUser.isEmailValido(email);
		
		
		
	}
	
	/*public void verificacaoAtualizacao(String atributo, String valor, Usuario logado, )
			throws AtualizacaoException {
		
		try {

		if (atributo.equals("Nome")) {
			logado.setNome(valor);
		} else if (atributo.equals("E-mail")) {
			this.utilUser.isEmailValido(valor);
			this.usuarios.remove(this.logado.getEmail(), this.logado);
			this.logado.setEmail(valor);
			this.usuarios.put(valor, this.logado);
		} else if (atributo.equals("Senha")) {
			throw new Exception("Eh necessario digitar velha senha");
		} else if (atributo.equals("Foto")) {
			this.utilUser.isFotoValida(valor);
			this.logado.setImagem(valor);
		} else if (atributo.equals("Data de Nascimento")) {
			this.utilUser.isDataNascimentoValida(valor);
			this.logado.setDataNascimento(utilUser.dataFormatChanges(valor));
		} else {
			throw new Exception("Atributo invalido.");
		}
		}
		catch(Exception e){
			e.getMessage()
			System.err.println("");
			
		}
	}
*/
}
