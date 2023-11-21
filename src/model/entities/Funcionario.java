package model.entities;

import java.util.Arrays;

public class Funcionario {
	private String cpf;
	private String nome;
	private int idade;
	private String[] endereco = new String[5];
	private double salario;

	public Funcionario(String cpf, String nome, int idade, String[] endereco, double salario) {
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.salario = salario;
		
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
		return String.format("CPF: %s, NOME: %s, IDADE: %d, ENDEREÇO: %s, SALARIO: %.2f", cpf, nome, idade, Arrays.toString(endereco), salario);
	}
	
	
}
