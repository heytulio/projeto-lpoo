package services.util;

import java.util.InputMismatchException;

import javax.naming.directory.InvalidAttributeValueException;

public class Validador {

	public static boolean validaCpf(String cpf) throws InvalidAttributeValueException {
		if (cpf.length() != 11) {
			throw new InvalidAttributeValueException("CPF POSSUI TAMANHO DIFERENTE DO PADR�O;");
		} else {

			for (int i = 0; i < cpf.length(); i++) {
				var verifica = cpf.charAt(i);
				if (!(Character.isDigit(verifica))) {
					throw new InvalidAttributeValueException("CPF POSSUI DIGITOS INVÁLIDOS, INSIRA UM CPF VALIDO");
				}

			}
			return true;
		}
	}

	public static boolean validaNome(String nome) throws InvalidAttributeValueException {
		nome = nome.replace(' ', 'a');
		if (nome.length() < 3)
			throw new InvalidAttributeValueException("NOME TEM QUE POSSUIR MAIS QUE 3 CARACTERES");
		for (int i = 0; i < nome.length(); i++) {
			var verifica = nome.charAt(i);
			if (!(Character.isLetter(verifica))==true) {
				throw new InvalidAttributeValueException("O NOME E COMPOSTO POR NUMERO NÃO E VALIDO");
			}

		}
		return true;

	}

	public static boolean validaIdade(char d, String idade) throws InvalidAttributeValueException {
		int idad=0;
		try {
			idad=Integer.parseInt(idade);
		}catch (InputMismatchException e) {
			throw new InvalidAttributeValueException("IDADE INFORMADA É INVALIDA;");
		}
		if (d == 'a') {
			if (idad > 100 || idad < 10)
				throw new InvalidAttributeValueException("IDADE INFORMADA É INVALIDA;");
		}else if (d == 'f') {
			if (idad > 65 || idad < 18)
				throw new InvalidAttributeValueException("IDADE INFORMADA É INVALIDA;");
		}
		return true;
	}

}
