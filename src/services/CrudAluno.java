package services;

import java.time.LocalDate;
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
		TipoDePlano plano1 = TipoDePlano.valueOf("BASICO");
		String[] enderecoVitrine1 = new String[] { "LOGRADOURO", "NUMERO", "CEP", "CIDADE", "ESTADO" };
		listaAluno.add(new Aluno("11111111111", "joao", 13, enderecoVitrine1, new Plano(plano1)));
		listaAluno.add(new Aluno("22222222222", "jose", 13, enderecoVitrine1, new Plano(plano1)));

		// o grosso ta funcionando, tem que fazer ele ficar no loop de informar o
		// //negocio correto;
		while (true) {
			try {
				System.out.print("INFORME O CPF: ");
				var cpf = input.nextLine();
				Validador.validaCpf(cpf);
				System.out.print("INFORME O NOME: ");
				var nome = input.nextLine();
				if (nome.length() < 3)
					throw new InvalidAttributeValueException("NOME TEM QUE POSSUIR MAIS QUE 3 CARACTERES");
				System.out.print("INFORME A IDADE: ");
				var idade = input.nextInt();
				if (idade > 100 || idade < 10)
					throw new InvalidAttributeValueException("IDADE INFORMADA É INVALIDA;");
				input.nextLine();
				String[] endereco = new String[5];
				String[] enderecoVitrine = new String[] { "LOGRADOURO", "NUMERO", "CEP", "CIDADE", "ESTADO" };
				for (int i = 0; i < 5; i++) {
					System.out.print(enderecoVitrine[i] + ": ");
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
			} catch (InvalidAttributeValueException e) {
				System.out.println("Erro: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Erro: " + e.getStackTrace());
				input.nextLine();
			}
		}

	}

	@Override
	public void listar() {
		if (listaAluno.size() == 0)
			System.out.println("Não existem alunos cadastrados no sistema;");
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
			System.out.println("Não existem alunos cadastrados no sistema;");
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
					System.out.println("Não foi encontrado nenhum aluno com esse CPF;");
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
			System.out.println("Não existem alunos cadastrados no sistema;");
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
								"Informe os dados que serão atualizados, deixe em branco para manter o atual;");
						System.out.print("NOME: ");
						var nome = input.nextLine();
						a.setNome(nome.length() != 0 ? nome : a.getNome());
						try {
							System.out.print("IDADE: ");
							String idade = input.nextLine();
							a.setIdade(idade.length() != 0 ? Integer.parseInt(idade) : a.getIdade());
						} catch (NumberFormatException e) {
							System.out.println("Erro: " + e.getMessage());
							input.nextLine();
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
							input.nextLine();
						}
						System.out.println("INFORME O ENDEREÇO: ");
						String[] endAluno = a.getEndereco();
						String[] endereco = new String[5];
						String[] enderecoVitrine1 = new String[] { "LOGRADOURO", "NUMERO", "CEP", "CIDADE", "ESTADO" };
						System.out.println(Arrays.toString(endAluno));
						for (int i = 0; i < 5; i++) {
							System.out.print(enderecoVitrine1[i] + ": ");
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
					System.out.println("Não foi encontrado ninguem com este CPF;");
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
				//TODO arrumar o acoplamento desse metodo
				// isso aqui é ruim pra aplicacao, alto acoplamento, nao consigo pensar em como
				// fazer certo
				Pagamento pc = new PagamentoCartao();
				Pagamento pd = new PagamentoDinheiro();
				System.out.print("Informe o CPF: ");
				var cpf = input.nextLine();
				Validador.validaCpf(cpf);
				for (Aluno a : listaAluno) {
					if (a.getCpf().equals(cpf)) {
						System.out.printf("Plano atual do aluno é: %s \n", a.getPlano().getPlano());
						System.out.println("BASICO; \n" + "ESSENCIAL; \n" + "PREMIUM;\n");
						System.out.print("Para qual outro plano você deseja mudar?");
						TipoDePlano plano = TipoDePlano.valueOf(input.nextLine().toUpperCase());
						if (plano.equals(a.getPlano().getPlano())) {
							System.out.println("Plano inserido já é o plano atual do aluno");
							break;
						} else {
							System.out.println("OK; Agora é necessario pagar a pendencia do outro plano");
							System.out.println("Qual sera a forma de pagamento (D/C)? ");
							var charop = input.next().toUpperCase().charAt(0);
							if (charop == 'D')
								pd.pagamento(cpf);
							else if (charop == 'C')
								pc.pagamento(cpf);
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