package teste;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.management.InvalidAttributeValueException;

import services.CrudAluno;
import services.CrudFuncionario;
import services.CrudTurma;
import services.PagamentoCartao;
import services.PagamentoDinheiro;
import services.util.Validador;

public class Teste {

	public static void main(String[] args) throws InvalidAttributeValueException {
		// TESTE DE CODIGO
		Scanner input = new Scanner(System.in);
		
		CrudAluno ca = new CrudAluno();
		CrudFuncionario cf = new CrudFuncionario();
		PagamentoDinheiro pg = new PagamentoDinheiro();
		PagamentoCartao pgc = new PagamentoCartao();
		CrudTurma ct = new CrudTurma();
		

		String path = System.getProperty("user.dir");
		System.out.println(path);
		
		//TODO Criar as novas exceptions
		//TODO Implementar validacoes no Validador
		//TODO Criar o pacote repositories e implementar o sistema de backup
		//TODO tentar quebrar o codigo testando as excecoes, e anotando o que passar
		
		while (true) {
			print();
			System.out.print("INFORME A OPERACAO: ");
			char op = input.next().charAt(0);
			switch (op) {
			case '1':
				System.out.println("---------------------------------");
				System.out.println("1 - Adicionar aluno;\n"
						+ "2 - Remover aluno;\n"
						+ "3 - Listar alunos;\n"
						+ "4 - Atualizar aluno;\n"
						+ "0 - Sair do sub-menu;");
				System.out.print("escolha a opção: ");
				char opc = input.next().charAt(0);
				System.out.println("---------------------------------");
				if(opc=='1') ca.adicionar();
				else if(opc=='2') ca.remover();
				else if(opc=='3') ca.listar();
				else if(opc == '4') ca.atualizar();
				else if(opc == '5') {
					ca.atualizarPlano();
				}
				else if(opc == '0') break;
				else System.out.println("Comando invalido;");
				break;
			case '2':
				System.out.println("---------------------------------");
				System.out.println("1 - Adicionar funcionario;\n"
						+ "2 - Remover funcionario;\n"
						+ "3 - Listar funcionarios;\n"
						+ "4 - Atualizar funcionario;\n"
						+ "0 - Sair do sub-menu;");
				System.out.print("escolha a opção: ");
				char opc2 = input.next().charAt(0);
				System.out.println("---------------------------------");
				if(opc2=='1') cf.adicionar();
				else if(opc2=='2') cf.remover();
				else if(opc2=='3') cf.listar();
				else if(opc2 == '4') cf.atualizar();
				else if(opc2 == '0') break;
				else System.out.println("Comando invalido;");
				break;
			case '3':
				System.out.println("---------------------------------");
				System.out.println("1 - Adicionar turma;\n"
						+ "2 - Remover turma;\n"
						+ "3 - Listar turmas;\n"
						+ "0 - Sair do sub-menu;");
				System.out.print("escolha a opção: ");
				char opc3 = input.next().charAt(0);
				System.out.println("---------------------------------");
				if(opc3=='1') ct.adicionar();
				else if(opc3=='2') ct.remover();
				else if(opc3=='3') ct.listar();
				break;
			case '4':
				System.out.println("---------------------------------");
				System.out.println("1 - Adicionar aluno a turma;\n"
						+ "2 - Remover aluno da turma;\n"
						+ "3 - Listar dados da turma;\n"
						+ "0 - Sair do sub-menu;");
				System.out.print("escolha a opção: ");
				char opc4 = input.next().charAt(0);
				System.out.println("---------------------------------");
				if(opc4=='1') ct.addAluno();
				else if(opc4=='2') ct.removeAluno();
				else if(opc4=='3') ct.listarAluno();
				break;
			case '5':
				try {
					System.out.println("---------------------------------");
					System.out.println("Bem-vindo a area de pagamentos");
					System.out.print("qual a opção de pagamento dinheiro ou cartÃ£o (D/C): ");
					char op1 =input.next().charAt(0);
					System.out.println("---------------------------------");
					input.nextLine();
					System.out.println("Digite o CPF: ");
					String cpf = input.nextLine();
					if(op1=='d') {
						pg.pagamento(cpf);
					}else if(op1=='c') {
						pgc.pagamento(cpf);
					}
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					input.nextLine();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case '6':
				System.out.println("PROGRAMA ENCERADO ");
				break;
			
			default:
				System.out.println("OPERACAO NAO ENCONTRADA");
				break;
			}
			if (op == '6') {
				break;
			}
		}
		
		input.close();
			
		}
	private static void print() {
		System.out.println("---------------------------------");
		System.out.println();
		System.out.println("1: Menu de alunos;");
		System.out.println("2: Menu de funcionarios");
		System.out.println("3: Menu de cadastro de turma");
		System.out.println("4: Menu de gerenciamento de alunos na turma");
		System.out.println("5: Pagamento de Mensalidade");
		System.out.println("6: fechar programa");
		System.out.println();
		System.out.println("---------------------------------");
		
		
		
		
	}

}
