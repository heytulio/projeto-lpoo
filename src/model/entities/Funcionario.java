package model.entities;

import java.util.Arrays;

import javax.management.InvalidAttributeValueException;

public class Funcionario {
	private String cpf;
	private String nome;
	private int idade;
	private String[] endereco = new String[5];
	private double salario;

	public Funcionario(String cpf, String nome, int idade, String[] endereco, double salario)
			throws InvalidAttributeValueException {
		if (cpf == null || cpf.length() < 11) {
			throw new InvalidAttributeValueException("CPF INFORMADO NÃO É VALIDO");
		} else {
			this.cpf = cpf;
		}
		if (nome == null) {
			throw new InvalidAttributeValueException("NOME INFORMADO NÃO É VALIDO");
		} else {
			this.nome = nome;
		}
		if (idade < 18 || idade > 100) {
			throw new InvalidAttributeValueException("IDADE INFORMADA NÃO É VALIDA");
		} else {
			this.idade = idade;
		}
		this.endereco = endereco;
		if (salario <= 0) {
			throw new InvalidAttributeValueException("SALARIO INFORMADO NÃO É VALIDO");
		} else {
			this.salario = salario;
		}
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return String.format("%s,%s,%d,%s,%.2f", cpf, nome, idade, Arrays.toString(endereco), salario);
	}
	
	
}
