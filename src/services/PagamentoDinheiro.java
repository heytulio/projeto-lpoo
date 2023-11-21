package services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Aluno;

public class PagamentoDinheiro implements Pagamento {

	@Override
	public void pagamento(String cpf) {
		var flag=false;
		List<Aluno> alunos = new ArrayList<>();
		alunos = CrudAluno.getListaAluno();
		for (Aluno aluno:alunos) {
			if(aluno.getCpf().equals(cpf)) {
				aluno.setAsinatura(aluno.getAsinatura().plusMonths(1));
				System.out.println("o aluno: "+aluno.getNome()+" teve sua mensalidade pagano valor de: "+aluno.getPlano().getPrice());
				flag=true;
			}
		}
		if(flag==false)System.out.println("CPF NÃO ENCONTRADO ");
	}

}
