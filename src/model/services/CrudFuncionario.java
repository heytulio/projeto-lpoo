package model.services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.management.InvalidAttributeValueException;

import model.entities.Funcionario;
import model.entities.Professor;
import model.entities.enums.Especialidade;

public class CrudFuncionario implements Crud {
	static List<Funcionario> listaFunc = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	@Override
	public void adicionar() {
		try {
			System.out.println("o funcionario e um professor? (S/N) ");
			char op = input.nextLine().charAt(0);
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
			System.out.print("INFORME O SALARIO: ");
			double salario = input.nextDouble();
			if (op == 's') {
				System.out.print("INFORME A ESPECIALIDADE(MUSCULACAO/NATACAO/KARATE/ZUMBA): ");
				Especialidade especialidade = Especialidade.valueOf(input.next().toUpperCase());
				Professor professor = new Professor(cpf, nome, idade, endereco, salario, especialidade);
				listaFunc.add(professor);
			}
			else {
				Funcionario funcionario = new Funcionario(cpf, nome, idade, endereco, salario);
				listaFunc.add(funcionario);
			}

			//listaFunc.add(new Funcionario("33333333333", "alex Green", 19, null, 1200));
			//listaFunc.add(new Funcionario("44444444444", "maria", 22, null, 1984));
		}  catch (InputMismatchException e) {
			System.out.println("Erro: " + e.getMessage());
			input.nextLine();
		} catch (InvalidAttributeValueException e) {
			System.out.println("Erro: " + e.getMessage());
			input.nextLine();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

	@Override
	public void listar() {
		for (Funcionario funcionario : listaFunc) {
			System.out.println(funcionario.toString());
		}

	}

	@Override
	public void remover() {
		System.out.println("digite o cpf: ");
		String cpf = input.next();
		for (Funcionario funcionario : listaFunc) {
			if (funcionario.getCpf().equals(cpf)) {
				listaFunc.remove(funcionario);
				System.out.println("o funcionario " + funcionario.getNome() + " foi removido.");
				break;
			}
		}

	}

	public static List<Funcionario> getListaFunc() {
		return listaFunc;
	}

	

}
