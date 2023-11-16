package model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Aluno;
import model.entities.Funcionario;
import model.entities.Professor;
import model.entities.Turma;

public class CrudTurma implements Crud {
	List<Turma> turmas = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	@Override
	public void adicionar() {
		List<Funcionario> listaFunc = new ArrayList<>(CrudFuncionario.getListaFunc());
		System.out.println("DIGITE O CPF DO PROFESSOR");
		String cpf = input.nextLine();
		for (Funcionario funcionario : listaFunc) {
			if (funcionario.getCpf().equals(cpf)) {
				if (funcionario instanceof Professor) {
					turmas.add(new Turma((Professor) funcionario));
				}
			}

		}
	}

	@Override
	public void listar() {
		for (Turma turma : turmas) {
			System.out.println("turma de " + turma.getProfessor().getEspecialidade() + " do professor "
					+ turma.getProfessor().getNome());
			for (Aluno aluno : turma.getAlunos()) {
				System.out.println("Aluno: " + aluno.getNome());
			}
		}

	}

	@Override
	public void remover() {
		System.out.println("DIGITE O CPF DO PROFESSOR");
		String cpf = input.nextLine();
		for (Turma turma : turmas) {
			if (turma.getProfessor().getCpf().equals(cpf)) {
				turmas.remove(turma);
				break;
			}
		}
	}

	public void addAluno() {
		System.out.println("DIGITE O CPF DO PROFESSOR");
		String cpf = input.nextLine();
		for (Turma turma : turmas) {
			if (turma.getProfessor().getCpf().equals(cpf)) {
				System.out.println("DIGITE O CPF DO ALUNO ");
				String cpfAluno = input.nextLine();
				List<Aluno> listaAluno = new ArrayList<>(CrudAluno.getListaAluno());
				for (Aluno aluno : listaAluno) {
					if (aluno.getCpf().equals(cpfAluno)) {
						turma.getAlunos().add(aluno);
						System.out.println("o aluno "+aluno.getNome()+" foi adicionado.");
					}
				}

			}
		}
	}

	public void removeAluno() {
		System.out.println("DIGITE O CPF DO PROFESSOR");
		String cpf = input.nextLine();
		for (Turma turma : turmas) {
			if (turma.getProfessor().getCpf().equals(cpf)) {
				System.out.println("DIGITE O CPF DO ALUNO ");
				String cpfAluno = input.nextLine();
				List<Aluno> listaAluno = new ArrayList<>(turma.getAlunos());
				for (Aluno aluno : listaAluno) {
					if (aluno.getCpf().equals(cpfAluno)) {
						turma.getAlunos().remove(aluno);
						System.out.println("o aluno "+aluno.getNome()+" foi removido.");
						break;
					}
				}

			}
		}
	}

	public void listarAluno() {
		System.out.println("DIGITE O CPF DO PROFESSOR");
		String cpf = input.nextLine();
		for (Turma turma : turmas) {
			if (turma.getProfessor().getCpf().equals(cpf)) {
				List<Aluno> listaAluno = new ArrayList<>(turma.getAlunos());
				for (Aluno aluno : listaAluno) {
					System.out.println("Aluno: " + aluno.getNome());
				}
			}
		}
	}
}
