package model.entities;

import java.time.LocalDate;
import java.util.Arrays;

import javax.management.InvalidAttributeValueException;

import model.entities.enums.TipoDePlano;

public class Aluno {
	private String cpf;
	private String nome;
	private int idade;
	private String[] endereco = new String[5]; // {logradouro, numero, cidade, cep, estado} se tiver mais algo pra
												// complementar faz dps
	private Plano plano;
	private LocalDate asinatura;
	

	// DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public Aluno(String cpf, String nome, int idade, String[] endereco, Plano plano) {
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.plano = plano;
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

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null) throw new IllegalArgumentException("NOME INFORMADO É INVALIDO");
		else {
			this.nome = nome;
		}
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) throws IllegalArgumentException {
		if (idade < 10 || idade>100) {
			throw new IllegalArgumentException("IDADE INSERIDA É INVALIDA");
		} else {
			this.idade = idade;
		}
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
		return String.format("CPF: %s, NOME: %s, IDADE: %d,ENDEREÇO: %s, PLANO: %s, DATA DE ASSINATURA: %s", cpf, nome, idade, Arrays.toString(endereco),
				plano.getPlano().toString(), asinatura);
	}

	public LocalDate getAsinatura() {
		return asinatura;
	}

	public void setAsinatura(LocalDate asinatura) {
		this.asinatura = asinatura;
	}
	
}
