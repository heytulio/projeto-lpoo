package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Aluno;

public class PagamentoCartao implements Pagamento {

	@Override
	public void pagamento(String cpf) {
		List<Aluno> alunos = new ArrayList<>();
		alunos = CrudAluno.getListaAluno();
		for (Aluno aluno:alunos) {
			if(aluno.getCpf().equals(cpf)) {
				aluno.setAsinatura(aluno.getAsinatura().plusMonths(1));
				Double total = aluno.getPlano().getPrice()*1.02;
				System.out.println("o aluno: "+aluno.getNome()+" teve sua mensalidade pagano valor de: "+total);
			}
		}
		
	}

}
