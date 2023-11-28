package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.directory.InvalidAttributeValueException;

import model.entities.Aluno;
import model.entities.Funcionario;
import model.entities.Professor;
import model.entities.Turma;
import model.entities.exceptions.LimitedSignatureException;
import services.util.Validador;

public class CrudTurma implements Crud {
	List<Turma> turmas = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	@Override
	public void adicionar() {
		List<Funcionario> listaFunc = new ArrayList<>(CrudFuncionario.getListaFunc());
		while(true) {
			try {
				System.out.print("DIGITE O CPF DO PROFESSOR: ");
				String cpf = input.nextLine();
				Validador.validaCpf(cpf);
				boolean flag = true;
				boolean flag2 = true;
				for (Funcionario funcionario : listaFunc) {
					if (funcionario.getCpf().equals(cpf)) {
						if (funcionario instanceof Professor) {
							flag = false;

							turmas.add(new Turma((Professor) funcionario));
							System.out.println("Turma criada;");
							flag2=false;
							
							break;
						}
					}
				}
				if(flag2==false)break;
				if(flag == true) {
						System.out.println("N�o existe nenhum funcionario cadastrado com esse CPF ou"
								+ " n�o existe um professor cadastrado com esse CPF;");
					}
			} catch(InvalidAttributeValueException e) {
				System.out.println(e.getMessage());
				input.nextLine();
				System.out.println("presione s para sair(qualquer outra letra para continuar)");
				char op = input.next().charAt(0);
				input.nextLine();
				if(op=='s')break;
			}
		}
	}

	@Override
	public void listar() {
		if(turmas.size() == 0) System.out.println("Cadastre uma turma antes de usar essa fun��o;");
		else {
			for (Turma turma : turmas) {
				System.out.println("Turma de " + turma.getProfessor().getEspecialidade() + " do Professor "
						+ turma.getProfessor().getNome());
				for (Aluno aluno : turma.getAlunos()) {
					System.out.println("Aluno: " + aluno.getNome());
				}
			}
		}

	}

	@Override
	public void remover() {
		if (turmas.size()== 0) System.out.println("Cadastre uma turma antes de usar essa fun��o;");
		else {
			try {
				System.out.println("DIGITE O CPF DO PROFESSOR");
				String cpf = input.nextLine();
				Validador.validaCpf(cpf);
				boolean flag = true;
				for (Turma turma : turmas) {
					if (turma.getProfessor().getCpf().equals(cpf)) {
						flag = false;
						turmas.remove(turma);
						System.out.println("Turma removida;");
						break;
					}
				}
				if(flag == true) {
					System.out.println("N�o existe nenhuma turma com esse professor;");
				}
			} catch(InvalidAttributeValueException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			}
		}
	}

	public void addAluno() {
		if (turmas.size() == 0)
			System.out.println("Cadastre uma turma primeiro antes de adicionar um aluno");
		else {
			try {
				System.out.print("DIGITE O CPF DO PROFESSOR: ");
				String cpf = input.nextLine();
				Validador.validaCpf(cpf);
				for (Turma turma : turmas) {
					if (turma.getProfessor().getCpf().equals(cpf)) {
						System.out.print("DIGITE O CPF DO ALUNO: ");
						String cpfAluno = input.nextLine();
						Validador.validaCpf(cpfAluno);
						boolean flag = true;
						List<Aluno> listaAluno = new ArrayList<>(CrudAluno.getListaAluno());
						for (Aluno aluno : listaAluno) {
							if (aluno.getCpf().equals(cpfAluno)) {
								flag = false;
								if (aluno.getPlano().getCountT() == 0) {
									throw new LimitedSignatureException("Plano do aluno possui limita��o"
											+ " na quantidade de turmas que ele pode participar;\n"
											+ "Troque de plano para poder acessar mais turmas;");
								} else {
									turma.getAlunos().add(aluno);
									aluno.getPlano().setCountT(aluno.getPlano().getCountT() - 1);
									System.out.println("o aluno " + aluno.getNome() + " foi adicionado.");
									break;
								}
							}
						}
						if (flag == true) {
							System.out.println("N�o existe nenhum aluno cadastrado com esse cpf;");
						}
					}
				}
			} catch (LimitedSignatureException e) {
				System.out.println(e.getMessage());
			} catch (InvalidAttributeValueException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void removeAluno() {
		if(turmas.size() == 0) System.out.println("Cadastre uma turma antes de tentar remover um aluno;");
		else {
			try {
				System.out.print("DIGITE O CPF DO PROFESSOR: ");
				String cpf = input.nextLine();
				Validador.validaCpf(cpf);
				for (Turma turma : turmas) {
					if (turma.getProfessor().getCpf().equals(cpf)) {
						System.out.print("DIGITE O CPF DO ALUNO: ");
						String cpfAluno = input.nextLine();
						List<Aluno> listaAluno = new ArrayList<>(turma.getAlunos());
						boolean flag = true;
						for (Aluno aluno : listaAluno) {
							if (aluno.getCpf().equals(cpfAluno)) {
								turma.getAlunos().remove(aluno);
								aluno.getPlano().setCountT(aluno.getPlano().getCountT() + 1);
								System.out.println("Aluno " + aluno.getNome() + " foi removido.");
								flag = false;
								break;
							}
						}
						if (flag == true) {
							System.out.println("O aluno n�o est� cadastrado nessa turma;");
						}
					}
				}
			} catch (InvalidAttributeValueException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			}
		}
	}

	public void listarAluno() {
		if(turmas.size() == 0) System.out.println("Cadastre pelo menos uma turma antes de usar essa fun��o;");
		else {
			try {
				System.out.print("DIGITE O CPF DO PROFESSOR: ");
				String cpf = input.nextLine();
				Validador.validaCpf(cpf);
				for (Turma turma : turmas) {
					if (turma.getProfessor().getCpf().equals(cpf)) {
						List<Aluno> listaAluno = new ArrayList<>(turma.getAlunos());
						for (Aluno aluno : listaAluno) {
							System.out.println("Aluno: " + aluno.getNome());
						}
					}
				}
			} catch (InvalidAttributeValueException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			}
		}
	}

	@Override
	public void atualizar() {

	}
}
