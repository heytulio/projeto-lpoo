package teste;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.management.InvalidAttributeValueException;

import model.entities.Aluno;
import model.entities.Funcionario;
import model.entities.enums.Plano;

public class Teste {

	public static void main(String[] args) {
		// TESTE DE CODIGO
		Scanner input = new Scanner(System.in);
		// 1 - cadastro de aluno
		// 2 - cadastro de funcionario
		// 3 - lista alunos
		// 4 - lista funcionarios
		// 5 - break;
		List<Aluno> listaAluno = new ArrayList<>();
		List<Funcionario> listaFunc = new ArrayList<>();
		while (true) {
			System.out.println("INFORME A OPERACAO: ");
			char op = input.next().charAt(0);
			switch (op) {
			case '1':
				try {
					//o grosso ta funcionando, tem que fazer ele ficar no loop de informar o negocio correto;
					input.nextLine();
					System.out.print("INFORME O CPF: ");
					var cpf = input.nextLine();
					System.out.print("INFORME O NOME: ");
					var nome = input.nextLine();
					System.out.print("INFORME A IDADE: ");
					var idade = input.nextInt();
					input.nextLine();
					String[] endereco = new String[5];
					String[] enderecoVitrine = new String[] { "LOGRADOURO", "NUMERO", "CEP", "CIDADE", "ESTADO" };
					for (int i = 0; i < 5; i++) {
						System.out.print(enderecoVitrine[i] + ": ");
						endereco[i] = input.nextLine();
					}
					System.out.print("INFORME O PLANO: ");
					Plano plano = Plano.valueOf(input.nextLine());
					Aluno a = new Aluno(cpf, nome, idade, endereco, plano);
					listaAluno.add(a);
					break;
				} catch (InputMismatchException e) {
					System.out.println("Erro: " + e.getMessage());
					input.nextLine();
				} catch (InvalidAttributeValueException e) {
					System.out.println("Erro: " + e.getMessage());
					input.nextLine();
				} catch (Exception e) {
					System.out.println("Erro: "+e.getMessage());
				} 				
			case '2':
				break;
			case '3':
				break;
			case '4':
				break;
			case '5':
				break;
			default:
				System.out.println("OPERACAO NAO ENCONTRADA");
				break;
			}
			if(op == '5') {
				break;
			}
		}

		input.close();
	}

}
