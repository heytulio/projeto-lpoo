package services.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.directory.InvalidAttributeValueException;

public class Validador {

	public static boolean validaCpf(String cpf) throws InvalidAttributeValueException {
		if (cpf.length() != 11) {
			throw new InvalidAttributeValueException("CPF POSSUI TAMANHO DIFERENTE DO PADRï¿½O;");
		} else {
			for (int i = 0; i < cpf.length(); i++) {
				var verifica = cpf.charAt(i);
				if (!(Character.isDigit(verifica))) {
					throw new InvalidAttributeValueException("CPF POSSUI DIGITOS INVÃ�LIDOS, INSIRA UM CPF VALIDO");
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
			if (!(Character.isLetter(verifica)) == true) {
				throw new InvalidAttributeValueException("O NOME E COMPOSTO POR NUMERO NÃƒO E VALIDO");
			}
		}
		return true;
	}

	public static boolean validaIdade(char d, String idade) throws InvalidAttributeValueException {
		int idad = 0;
		idad = Integer.parseInt(idade);
		if (d == 'a') {
			if (idad > 100 || idad < 10)
				throw new InvalidAttributeValueException("IDADE INFORMADA Ã‰ INVALIDA;");
		} else if (d == 'f') {
			if (idad > 65 || idad < 18)
				throw new InvalidAttributeValueException("IDADE INFORMADA Ã‰ INVALIDA;");
		}
		return true;
	}

	public static boolean validaCep(String cep) throws InvalidAttributeValueException {
		String regexCep = "^\\d{5}-\\d{3}$";
		Pattern patternAuth = Pattern.compile(regexCep);
		Matcher matcher = patternAuth.matcher(cep);
		if (matcher.matches() == true)
			return true;
		else
			throw new InvalidAttributeValueException("CEP INSERIDO É INVALIDO");
	}

}
