package services.util;

import javax.naming.directory.InvalidAttributeValueException;

public class Validador {
	
	public static boolean validaCpf(String cpf) throws InvalidAttributeValueException{
		if(cpf.length() != 11) {
			throw new InvalidAttributeValueException("CPF POSSUI TAMANHO DIFERENTE DO PADRÃO;");
		} else {
			boolean flag = true;
			for (int i = 0; i<cpf.length(); i++) {
				var verifica = cpf.charAt(i);
				if(Character.isLetter(verifica)) {
					throw new InvalidAttributeValueException("CPF POSSUI LETRAS, INSIRA UM CPF VALIDO");
				} else {
					flag = true;
				}
			}
			return flag;
		}
	}
	
}
