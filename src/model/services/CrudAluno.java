package model.services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.management.InvalidAttributeValueException;

import model.entities.Aluno;
import model.entities.Plano;
import model.entities.enums.TipoDePlano;

public class CrudAluno implements Crud {

	static List<Aluno> listaAluno = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	@Override
	public void adicionar() {
		// TipoDePlano plano1 = TipoDePlano.valueOf("BASICO");
		// String[] enderecoVitrine1 = new String[] { "LOGRADOURO", "NUMERO", "CEP",
		// "CIDADE", "ESTADO" };
		// listaAluno.add(new Aluno("11111111111","joao",13,enderecoVitrine1,new
		// Plano(plano1)));
		// listaAluno.add(new Aluno("22222222222","joao",13,enderecoVitrine1,new
		// Plano(plano1)));

		// o grosso ta funcionando, tem que fazer ele ficar no loop de informar o
		// //negocio correto;
		try {
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
			System.out.print("INFORME O PLANO(BASICO/ESSENCIAL/PREMIUM): ");
			TipoDePlano plano = TipoDePlano.valueOf(input.nextLine().toUpperCase());
			Aluno a = new Aluno(cpf, nome, idade, endereco, new Plano(plano));
			listaAluno.add(a);

		} catch (InputMismatchException e) {
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
		for (Aluno aluno : listaAluno) {
			System.out.println(aluno.toString());
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
		System.out.println("digite o cpf: ");
		String cpf = input.next();
		for(Aluno aluno:listaAluno) {
			if(aluno.getCpf().equals(cpf)) {
				listaAluno.remove(aluno);
				System.out.println("o aluno "+aluno.getNome()+" foi removido.");
				break;
			}
		}
		
	}

}