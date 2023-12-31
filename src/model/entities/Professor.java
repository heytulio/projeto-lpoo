package model.entities;

import model.entities.enums.Especialidade;

public class Professor extends Funcionario{
	private Especialidade especialidade;

	public Professor(String cpf, String nome, int idade, String[] endereco, double salario, Especialidade especialidade) {
		super(cpf, nome, idade, endereco, salario);
		this.especialidade = especialidade;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {
		return super.toString()+String.format(" ESPECIALIDADE: %s", especialidade);
	}
	
	
}
