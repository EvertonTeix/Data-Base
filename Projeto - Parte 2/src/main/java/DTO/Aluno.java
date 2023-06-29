package DTO;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Aluno {

	private long matricula;
	private String nome;
	private String email;
	private String telefone;
	private Calendar data_nasc;
	private String sexo;

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Calendar getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Calendar data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String dataEmText = formatador.format(this.getData_nasc().getTime());
		
		return "\nMatrícula = " + matricula + 
			   "\nNome = " + nome + 
			   "\nEmail = " + email + 
			   "\nTelefone = " + telefone + 
			   "\nData de Nascimento = " + dataEmText + 
			   "\nSexo = " + sexo;
	}
	
	
}
