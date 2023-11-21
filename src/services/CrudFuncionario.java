package services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.naming.directory.InvalidAttributeValueException;

import model.entities.Funcionario;
import model.entities.Professor;
import model.entities.enums.Especialidade;
import services.util.Validador;

public class CrudFuncionario implements Crud {

	static List<Funcionario> listaFunc = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	@Override
	public void adicionar() {
		while (true) {
			try {
				System.out.print("FUNCIONARIO � PROFESSOR? (S/N) ");
				char op = input.nextLine().charAt(0);
				System.out.print("INFORME O CPF: ");
				var cpf = input.nextLine();
				Validador.validaCpf(cpf);
				System.out.print("INFORME O NOME: ");
				var nome = input.nextLine();
				Validador.validaNome(nome);
				System.out.print("INFORME A IDADE: ");
				String idad = input.next();
				Validador.validaIdade('f', idad);
				int idade=Integer.parseInt(idad);
				input.nextLine();
				String[] endereco = new String[5];
				String[] enderecoVitrine = new String[] { "LOGRADOURO", "NUMERO", "CEP", "CIDADE", "ESTADO" };
				for (int i = 0; i < 5; i++) {
					System.out.print(enderecoVitrine[i] + ": ");
					if(i == 2) {
						var cep =input.nextLine();
						Validador.validaCep(cep);
						endereco[i] = cep;
						continue;
					}
					endereco[i] = input.nextLine();
				}
				System.out.print("INFORME O SALARIO: ");
				var salario = input.nextDouble();
				if (salario < 1320.00)
					throw new IllegalArgumentException("SALARIO INSERIDO � INVALIDO");
				input.nextLine();
				if (op == 's') {
					System.out.print("INFORME A ESPECIALIDADE(MUSCULACAO/NATACAO/KARATE/ZUMBA): ");
					Especialidade especialidade = Especialidade.valueOf(input.nextLine().toUpperCase());
					Professor professor = new Professor(cpf, nome, idade, endereco, salario, especialidade);
					listaFunc.add(professor);
					break;
				} else {
					Funcionario funcionario = new Funcionario(cpf, nome, idade, endereco, salario);
					listaFunc.add(funcionario);
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Erro: " + e.getMessage());
				input.nextLine();
			} catch (InvalidAttributeValueException e) {
				System.out.println("Erro: " + e.getMessage());
				input.nextLine();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
				input.nextLine();
			}
		}
	}

	@Override
	public void listar() {
		if (listaFunc.size() == 0)
			System.out.println("N�o existem funcionarios cadastrados no sistema;");
		else {
			System.out.println("---------------------------------");
			System.out.println("Funcionarios cadastrados no sistema:");
			listaFunc.stream().forEach(System.out::println);
			System.out.println("---------------------------------");
		}
	}

	@Override
	public void remover() {
		if (listaFunc.size() == 0)
			System.out.println("N�o existem funcionarios cadastrados no sistema;");
		else {
			try {
				System.out.print("Informe o CPF: ");
				String cpf = input.next();
				Validador.validaCpf(cpf);
				boolean flag = true;
				for (Funcionario funcionario : listaFunc) {
					if (funcionario.getCpf().equals(cpf)) {
						flag = false;
						listaFunc.remove(funcionario);
						System.out.println("Funcionario " + funcionario.getNome() + " foi removido.");
						break;
					}
				}
				if (flag == true) {
					System.out.println("N�o foi encontrado nenhum funcionario com esse CPF;");
				}
			} catch (InvalidAttributeValueException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			}
		}

	}

	public static List<Funcionario> getListaFunc() {
		return listaFunc;
	}

	@Override
	public void atualizar() {
		if (listaFunc.size() == 0)
			System.out.println("N�o existem funcionarios cadastrados no sistema;");
		else {
			try {
				input.nextLine();
				System.out.print("Informe o CPF: ");
				var cpf = input.nextLine();
				Validador.validaCpf(cpf);
				boolean flag = true;
				for (Funcionario f : listaFunc) {
					if (f.getCpf().equals(cpf)) {
						flag = false;
						System.out.println("Dados do Funcionario: " + f.toString());
						System.out.println(
								"Informe os dados que ser�o atualizados, deixe em branco para manter o atual;");
						System.out.print("NOME: ");
						var nome = input.nextLine();
						Validador.validaNome(nome);
						f.setNome(nome.length() != 0 ? nome : f.getNome());
						try {
							System.out.print("IDADE: ");
							String idade = input.nextLine();
							Validador.validaIdade('f', idade);
							f.setIdade(idade.length() != 0 ? Integer.parseInt(idade) : f.getIdade());
						} catch (NumberFormatException e) {
							System.out.println("Erro: " + e.getMessage());
							input.nextLine();
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
							input.nextLine();
						}
						System.out.println("INFORME O ENDERE�O: ");
						String[] endFunc = f.getEndereco();
						String[] endereco = new String[5];
						String[] enderecoVitrine1 = new String[] { "LOGRADOURO", "NUMERO", "CEP", "CIDADE", "ESTADO" };
						for (int i = 0; i < 5; i++) {
							System.out.print(enderecoVitrine1[i] + ": ");
							if(i == 2) {
								var cep = input.nextLine();
								Validador.validaCep(cep);
								endereco[i] = cep;
								continue;
							}
							endereco[i] = input.nextLine();
						}
						for (int i = 0; i < 5; i++) {
							if (endereco[i].length() != 0) {
								endFunc[i] = endereco[i];
							}
						}
						f.setEndereco(endFunc);
						System.out.print("INFORME O SALARIO: ");
						double salario = input.nextDouble();
						if (salario < 1320)
							throw new IllegalArgumentException("SALARIO INFORMADO � INVALIDO");
						f.setSalario(salario);
						break;
					}
				}
				if (flag == true) {
					System.out.println("Nenhum funcionario foi encontrado com esse CPF;");
				}
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
				input.nextLine();
			}
		}
	}

}
