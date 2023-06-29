package DTO;

public class Disciplina {

	private long codigo;
	private String nome;
	private int creditos;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	@Override
	public String toString() {
		return "\nCódigo = " + codigo + "   Nome = " + nome + "   Créditos = " + creditos;
	}
	
}
