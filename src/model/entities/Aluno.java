package model.entities;

import java.time.LocalDate;
import java.util.Arrays;

import javax.management.InvalidAttributeValueException;

public class Aluno {
	private String cpf;
	private String nome;
	private int idade;
	private String[] endereco = new String[5]; // {logradouro, numero, cidade, cep, estado} se tiver mais algo pra
												// complementar faz dps
	private Plano plano;
	private LocalDate asinatura;

	// DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public Aluno(String cpf, String nome, int idade, String[] endereco, Plano plano) throws InvalidAttributeValueException {
		if (cpf == null || cpf.length() < 11) {
			throw new InvalidAttributeValueException("CPF INFORMADO NAO � VALIDO");
		} else {
			this.cpf = cpf;
		}
		if (nome == null) {
			throw new InvalidAttributeValueException("NOME INFORMADO NAO � VALIDO");
		} else {
			this.nome = nome;
		}
		if (idade < 12 || idade > 100) {
			throw new InvalidAttributeValueException("IDADE INFORMADA N�O � VALIDA");
		} else {
			this.idade = idade;
		}
		if(endereco.length!=5) {
			throw new InvalidAttributeValueException("ENDEREÇO INFORMADO NÃO É VALIDO");
		}else{
			this.endereco = endereco; 
		}
		if(plano instanceof Plano) {
			this.plano = plano;
		}else {
			throw new InvalidAttributeValueException("PLANO INFORMADO NÃO É VALIDO");
		}
			this.setAsinatura(LocalDate.now());
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String[] getEndereco() {
		return endereco;
	}

	public void setEndereco(String[] endereco) {
		this.endereco = endereco;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	@Override
	public String toString() {
		return String.format("%s,%s,%d,%s,%s,%s", cpf, nome, idade, Arrays.toString(endereco),
				plano.getPlano().toString(), asinatura);
	}

	public LocalDate getAsinatura() {
		return asinatura;
	}

	public void setAsinatura(LocalDate asinatura) {
		this.asinatura = asinatura;
	}

}
