 package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.naming.directory.InvalidAttributeValueException;

import model.entities.Aluno;
import model.entities.Plano;
import model.entities.enums.TipoDePlano;
import services.util.Validador;

public class CrudAluno implements Crud {

	static List<Aluno> listaAluno = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	@Override
	public void adicionar() {
		while (true) {
			try {
				System.out.print("INFORME O CPF: ");
				var cpf = input.nextLine();
				Validador.validaCpf(cpf);
				System.out.print("INFORME O NOME: ");
				var nome = input.nextLine();
				Validador.validaNome(nome);
				System.out.print("INFORME A IDADE: ");
				String idad = input.next();
				Validador.validaIdade('a',idad);
				int idade = Integer.parseInt(idad);
				input.nextLine();
				String[] endereco = new String[5];
				String[] enderecoVitrine = new String[] { "LOGRADOURO", "NUMERO", "CEP", "CIDADE", "ESTADO" };
				for (int i = 0; i < 5; i++) {
					System.out.print(enderecoVitrine[i] + ": ");
					if(i == 2) {
						var cep = input.nextLine();
						Validador.validaCep(cep);
						endereco[i] = cep;
						continue;
					}
					endereco[i] = input.nextLine();
				}
				System.out.print("INFORME O PLANO (BASICO/ESSENCIAL/PREMIUM): ");
				TipoDePlano plano = TipoDePlano.valueOf(input.nextLine().toUpperCase());
				Aluno a = new Aluno(cpf, nome, idade, endereco, new Plano(plano));
				listaAluno.add(a);
				break;
			} catch (InputMismatchException e) {
				System.out.println("Erro: " + e.getMessage());
				input.nextLine();
				System.out.println("presione s para sair(qualquer outra letra para continuar)");
				char op = input.next().charAt(0);
				input.nextLine();
				if(op=='s')break;
			} catch (InvalidAttributeValueException e) {
				System.out.println("Erro: " + e.getMessage());
				input.nextLine();
				System.out.println("presione s para sair(qualquer outra letra para continuar)");
				char op = input.next().charAt(0);
				input.nextLine();
				if(op=='s')break;
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
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
		if (listaAluno.size() == 0)
			System.out.println("N�o existem alunos cadastrados no sistema;");
		else {
			System.out.println("----------------------------");
			System.out.println("Alunos cadastrados no sistema:");
			listaAluno.stream().forEach(System.out::println);
			System.out.println();
			System.out.println("----------------------------");
		}
	}

	public CrudAluno() {
		super();
	}

	public static List<Aluno> getListaAluno() {
		return listaAluno;
	}

	@Override
	public void remover() {
		if (listaAluno.size() == 0)
			System.out.println("N�o existem alunos cadastrados no sistema;");
		else {
			try {
				System.out.print("Informe o CPF: ");
				String cpf = input.nextLine();
				Validador.validaCpf(cpf);
				boolean flag = true;
				for (Aluno aluno : listaAluno) {
					if (aluno.getCpf().equals(cpf)) {
						flag = false;
						listaAluno.remove(aluno);
						System.out.println("o aluno " + aluno.getNome() + " foi removido.");
						break;
					}
				}
				if(flag == true) {
					System.out.println("N�o foi encontrado nenhum aluno com esse CPF;");
				}
			} catch (InvalidAttributeValueException e) {
				System.out.println("Erro: " + e.getMessage());
				input.nextLine();
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
				input.nextLine();
			}
		}
	}

	@Override
	public void atualizar() {
		if (listaAluno.size() == 0)
			System.out.println("N�o existem alunos cadastrados no sistema;");
		else {
			try {
				System.out.print("Informe o CPF: ");
				var cpf = input.nextLine();
				Validador.validaCpf(cpf);
				boolean flag = true;
				for (Aluno a : listaAluno) {
					if (a.getCpf().equals(cpf)) {
						flag = false;
						System.out.println("Dados do Aluno: " + a.toString());
						System.out.println(
								"Informe os dados que ser�o atualizados, deixe em branco para manter o atual;");
						System.out.print("NOME: ");
						var nome = input.nextLine();
						Validador.validaNome(nome);
						a.setNome(nome.length() != 0 ? nome : a.getNome());
						try {
							System.out.print("IDADE: ");
							String idad = input.next();
							Validador.validaIdade('a',idad);
							input.nextLine();
							a.setIdade(idad.length() != 0 ? Integer.parseInt(idad) : a.getIdade());
						} catch (NumberFormatException e) {
							System.out.println("Erro: " + e.getMessage());
							input.nextLine();
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
							input.nextLine();
						}
						System.out.println("INFORME O ENDERE�O: ");
						String[] endAluno = a.getEndereco();
						String[] endereco = new String[5];
						String[] enderecoVitrine1 = new String[] { "LOGRADOURO", "NUMERO", "CEP", "CIDADE", "ESTADO" };
						System.out.println(Arrays.toString(endAluno));
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
								endAluno[i] = endereco[i];
							}
						}
						a.setEndereco(endAluno);
					}
				}
				if (flag == true) {
					System.out.println("N�o foi encontrado ninguem com este CPF;");
				}
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			} catch(InvalidAttributeValueException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			}
		}
	}

	public void atualizarPlano() {
		if (listaAluno.size() == 0)
			System.out.println("Cadastre um aluno primeiro");
		else {
			try {
				Pagamento p;
				System.out.print("Informe o CPF: ");
				var cpf = input.nextLine();
				Validador.validaCpf(cpf);
				for (Aluno a : listaAluno) {
					if (a.getCpf().equals(cpf)) {
						System.out.printf("Plano atual do aluno �: %s \n", a.getPlano().getPlano());
						System.out.println("BASICO; \n" + "ESSENCIAL; \n" + "PREMIUM;\n");
						System.out.print("Para qual outro plano voc� deseja mudar?");
						TipoDePlano plano = TipoDePlano.valueOf(input.nextLine().toUpperCase());
						if (plano.equals(a.getPlano().getPlano())) {
							System.out.println("Plano inserido j� � o plano atual do aluno");
							break;
						} else {
							System.out.println("OK; Agora � necessario pagar a pendencia do outro plano");
							System.out.println("Qual sera a forma de pagamento (D/C)? ");
							var charop = input.next().toUpperCase().charAt(0);
							if (charop == 'D') {
								p=new PagamentoDinheiro();
								p.pagamento(cpf);
							}
							else if (charop == 'C') {
								p=new PagamentoCartao();
								p.pagamento(cpf);
							}
							a.setPlano(new Plano(plano));
							System.out.println("Plano alterado com sucesso!");
							break;
						}
					}
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Erro: " + e.getMessage());
				input.nextLine();
			} catch(InvalidAttributeValueException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
				input.nextLine();
			}
		}
	}

}