package DTO;

public class AlunoDisciplina {
	
	private long aluno_matr;
	private long disciplina_cod; 
	private String periodo;
	private float nota;
	private int frequencia;
	
	public long getAluno_matr() {
		return aluno_matr;
	}
	public void setAluno_matr(long aluno_matr) {
		this.aluno_matr = aluno_matr;
	}
	public long getDisciplina_cod() {
		return disciplina_cod;
	}
	public void setDisciplina_cod(long disciplina_cod) {
		this.disciplina_cod = disciplina_cod;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public int getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	} 
	
}
