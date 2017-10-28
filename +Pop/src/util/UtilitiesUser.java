package util;

import java.time.DateTimeException;


import java.time.LocalDate;

import exceptions.DadoInvalidoException;
import exceptions.MensagemInvalidaException;

public class UtilitiesUser {

	public UtilitiesUser() {

	}

	public void isDataValida(String data) throws DadoInvalidoException {
		
		if (data == null) {
			throw new DadoInvalidoException(
					"Data invalida, campo nao pode ser nulo.");
		}
		if (data.length() != 10) {
			throw new DadoInvalidoException("Formato de data esta invalida.");
		} 
		
	

	}

	public void isNomeValido(String nome) throws DadoInvalidoException {
		if (nome == null) {
			throw new DadoInvalidoException(
					"Nome dx usuarix nao pode ser vazio.");
		}
		if (nome.trim().equals("")) {
			throw new DadoInvalidoException(
					"Nome dx usuarix nao pode ser vazio.");
		}
		if (!(nome.matches("[A-Za-z?-?\\s]*+"))) {
			throw new DadoInvalidoException(
					"Nome so pode conter caracteres alfabeticos");
		}
	}

	public void isSenhaValida(String senha) throws DadoInvalidoException {
		if (senha == null) {
			throw new DadoInvalidoException("senha nao pode ser nula");
		}
		if (senha.trim().equals("")) {
			throw new DadoInvalidoException("senha nao pode ser vazia");
		}
		if (senha.length() < 6) {
			throw new DadoInvalidoException(
					"senha nao pode ter tamanho menor que 6");
		}
	}

	public void isMensagemValida(String mensagem) throws Exception {

		if (mensagem == null) {
			throw new MensagemInvalidaException(
					"Mensagem invalida, campo nulo.");
		}
		if (mensagem.trim().equals("")) {
			throw new MensagemInvalidaException(
					"Mensagem invalida, campo vazio.");
		}

	}

	public void isEmailValido(String email) throws DadoInvalidoException {
		if (email == null) {
			throw new DadoInvalidoException("email nao pode ser nulo");
		}
		if (email.trim().equals("")) {
			throw new DadoInvalidoException("email nao pode ser vazio");
		}
		if (!email.contains("@")) {
			throw new DadoInvalidoException("Formato de e-mail esta invalido.");
		}
		if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") == false) {
			throw new DadoInvalidoException("Formato de e-mail esta invalido.");
		}

	}

	public void isDataNascimentoValida(String dataNascimento) throws DadoInvalidoException{

		if (dataNascimento == null || dataNascimento.trim().equals("")) {
			throw new DadoInvalidoException(
					"Data de nascimento nao pode ser vazio");
		}
	}

	public void isFotoValida(String foto) throws DadoInvalidoException {

		if (foto == null || foto.equals("")) {
			throw new DadoInvalidoException("Foto nao pode ser vazia");
		}
	}

	public LocalDate dataFormatChanges(String data)
			throws DadoInvalidoException {

		String[] newDate = data.split("/");

		int dia = Integer.parseInt(newDate[0]);
		int mes = Integer.parseInt(newDate[1]);
		int ano = Integer.parseInt(newDate[2]);
		
		LocalDate date;
		
		try{
			date = LocalDate.of(ano, mes, dia);
		} catch(DateTimeException e){
			throw new DadoInvalidoException("Data nao existe.");
		}
		return date;

	}

}
