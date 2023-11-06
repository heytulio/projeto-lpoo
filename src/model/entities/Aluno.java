package model.entities;

import model.entities.enums.Plano;

import java.util.Arrays;

import javax.management.InvalidAttributeValueException;

public class Aluno {
	private String cpf;
	private String nome;
	private int idade;
	private String[] endereco = new String[5]; // {logradouro, numero, cidade, cep, estado} se tiver mais algo pra
												// complementar faz dps
	private Plano plano;

	public Aluno(String cpf, String nome, int idade, String[] endereco, Plano plano) throws InvalidAttributeValueException {
		if (cpf == null || cpf.length() < 11) {
			throw new InvalidAttributeValueException("CPF INFORMADO NAO É VALIDO");
		} else {
			this.cpf = cpf;
		}
		if (nome == null) {
			throw new InvalidAttributeValueException("NOME INFORMADO NAO É VALIDO");
		} else {
			this.nome = nome;
		}
		if (idade < 12 || idade > 100) {
			throw new InvalidAttributeValueException("IDADE INFORMADA NÃO É VALIDA");
		} else {
			this.idade = idade;
		}
		this.endereco = endereco; //tem que fazer um metodo para validar esse endereco
		this.plano = plano; //o mesmo para o plano
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
		return String.format("%s,%s,%d,%s,%s", cpf, nome, idade, Arrays.toString(endereco), plano);
	}
	
}
