package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	Professor professor;
	List<Aluno> alunos = new ArrayList<>();
	public Turma(Professor professor) {
		super();
		this.professor = professor;
	}
	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
		
	}
	public void removeAluno(Aluno aluno) {
		alunos.remove(aluno);
		
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public void listar() {
		
	}
	
	
	
}
