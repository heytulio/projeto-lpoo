package teste;

import java.util.Scanner;

import javax.management.InvalidAttributeValueException;

import model.services.CrudAluno;
import model.services.CrudFuncionario;
import model.services.CrudTurma;
import model.services.PagamentoCartao;
import model.services.PagamentoDinheiro;

public class Teste {

	public static void main(String[] args) throws InvalidAttributeValueException {
		// TESTE DE CODIGO
		Scanner input = new Scanner(System.in);
		// 1 - cadastro de aluno
		// 2 - cadastro de funcionario
		// 3 - lista alunos
		// 4 - lista funcionarios
		// 5 - pagamento de mensalidade
		// 6 - break;
		CrudAluno ca = new CrudAluno();
		CrudFuncionario cf = new CrudFuncionario();
		PagamentoDinheiro pg = new PagamentoDinheiro();
		PagamentoCartao pgc = new PagamentoCartao();
		CrudTurma ct = new CrudTurma();
		while (true) {
			print();
			System.out.println("INFORME A OPERACAO: ");
			char op = input.next().charAt(0);
			switch (op) {
			case '1':
				System.out.println("escolha a opção 1: adicionar 2: remover 3: listar");
				char opc = input.next().charAt(0);
				if(opc=='1')ca.adicionar();
				else if(opc=='2')ca.remover();
				else if(opc=='3')ca.listar();
				break;
			case '2':
				System.out.println("escolha a opção 1: adicionar 2: remover 3: listar");
				char opc2 = input.next().charAt(0);
				if(opc2=='1')cf.adicionar();
				else if(opc2=='2')cf.remover();
				else if(opc2=='3')cf.listar();
				break;
			case '3':
				System.out.println("escolha a opção 1: adicionar 2: remover 3: listar");
				char opc3 = input.next().charAt(0);
				if(opc3=='1')ct.adicionar();
				else if(opc3=='2')ct.remover();
				else if(opc3=='3')ct.listar();
				break;
			case '4':
				System.out.println("escolha a opção 1: adicionar 2: remover 3: listar");
				char opc4 = input.next().charAt(0);
				if(opc4=='1')ct.addAluno();
				else if(opc4=='2')ct.removeAluno();
				else if(opc4=='3')ct.listarAluno();
				break;
			case '5':
				System.out.println("qual a opcção de pagamento dinheiro ou cartão (D/C):");
				char op1 =input.next().charAt(0);
				System.out.println("digite o cpf: ");
				String cpf = input.next();
				if(op1=='d') {
					pg.pagamento(cpf);
				}else if(op1=='c') {
					pgc.pagamento(cpf);
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
		System.out.println("1: cadastrar/remover/listar aluno");
		System.out.println("2: cadastrar/remover/listar funcionario");
		System.out.println("3: cadastrar/remover/listar turma");
		System.out.println("4: gerenciar alunos de turma");
		System.out.println("5: pagamento de mensalidade");
		System.out.println("6: fechar programa");
		System.out.println();
		
		
		
		
	}

}
