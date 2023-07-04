package DAO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Connection.Connecting;
import DTO.*;

public class AlunoMetodos {

	public void adicionarAluno(Aluno aluno) {

		try {
			
			Connection connection = Connecting.getInstance().getConnection();
			String sql = "INSERT INTO aluno (NOME, EMAIL, TELEFONE, DATA_NASC, SEXO) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);

			
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd");
			String dataEmText = formatador.format(aluno.getData_nasc().getTime());
			
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getEmail());
			statement.setString(3, aluno.getTelefone());
			statement.setString(4, dataEmText);
			statement.setString(5, aluno.getSexo());
			
			statement.execute();
			connection.close();

			System.out.print("Estudante inserido com sucesso.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void atualizarAluno(Aluno aluno) {

		try {

			Connection connection = Connecting.getInstance().getConnection();
			String sql = "UPDATE aluno SET NOME = ?, EMAIL = ?, TELEFONE = ?, DATA_NASC = ?, SEXO = ? WHERE matricula = ?";
			PreparedStatement statement = connection.prepareStatement(sql);

			SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd");
			String dataEmText = formatador.format(aluno.getData_nasc().getTime());
			
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getEmail());
			statement.setString(3, aluno.getTelefone());
			statement.setString(4, dataEmText);
			statement.setString(5, aluno.getSexo());
			statement.setLong(6, aluno.getMatricula());

			statement.execute();
			statement.close();
			connection.close();

			System.out.print("Usuário atualizado com sucesso.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removerAluno(Aluno aluno) {

		try {

			Connection connection = Connecting.getInstance().getConnection();
			String sql = "DELETE from aluno WHERE matricula = ?";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setLong(1, aluno.getMatricula());

			statement.execute();
			statement.close();
			connection.close();

			System.out.print("Aluno excluído com sucesso.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Aluno> getAlunos() {
		List<Aluno> aluno = new ArrayList<Aluno>();

		try {

			Connection connection = Connecting.getInstance().getConnection();
			String sql = "SELECT * FROM alunos_info";
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				long matricula = resultSet.getInt("MATRICULA");
				String nome = resultSet.getString("NOME");
				String email = resultSet.getString("EMAIL");
				String telefone = resultSet.getString("TELEFONE");
				String sexo = resultSet.getString("SEXO");		
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(resultSet.getDate("DATA_NASC"));
				float media = resultSet.getFloat("MEDIA");

				Aluno alun = new Aluno();
				alun.setMatricula(matricula);
				alun.setNome(nome);
				alun.setEmail(email);
				alun.setTelefone(telefone);
				alun.setSexo(sexo);
				alun.setData_nasc(dataNascimento);
				alun.setMedia(media);

				aluno.add(alun);
			}

			resultSet.close();
			statement.close();
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		for (int i = 0; i < aluno.size(); i++) {
			Aluno aluno1 = aluno.get(i);
			System.out.println(aluno1.toString());
		}

		return aluno;

	}
	
	public List<Aluno> buscarAluno(String palavraPesquisar) {
		List<Aluno> aluno = new ArrayList<Aluno>();

		try {

			Connection connection = Connecting.getInstance().getConnection();
			String sql = "SELECT * FROM alunos_info a WHERE LOWER(a.nome) LIKE ? OR LOWER(a.email) LIKE ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			String codSql = "%"+ palavraPesquisar + "%";
			
			statement.setString(1, codSql);
			statement.setString(2, codSql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				long matricula = resultSet.getInt("MATRICULA");
				String nome = resultSet.getString("NOME");
				String email = resultSet.getString("EMAIL");
				String telefone = resultSet.getString("TELEFONE");
				String sexo = resultSet.getString("SEXO");		
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(resultSet.getDate("DATA_NASC"));
				float media = resultSet.getFloat("MEDIA");

				Aluno alun = new Aluno();
				alun.setMatricula(matricula);
				alun.setNome(nome);
				alun.setEmail(email);
				alun.setTelefone(telefone);
				alun.setSexo(sexo);
				alun.setData_nasc(dataNascimento);
				alun.setMedia(media);

				aluno.add(alun);
			}

			resultSet.close();
			statement.close();
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		for (int i = 0; i < aluno.size(); i++) {
			Aluno aluno1 = aluno.get(i);
			System.out.println(aluno1.toString());
		}

		return aluno;

}}