package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connecting;
import DTO.*;

public class DisciplinaMetodos {

	public void adicionarDisciplina(Disciplina disciplina) {

		try {
			Connection connection = Connecting.getInstance().getConnection();

			String sql = "INSERT INTO disciplina (NOME, CREDITOS) VALUES (?, ?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, disciplina.getNome());
			statement.setInt(2, disciplina.getCreditos());
			
			statement.execute();
			connection.close();

			System.out.print("Disciplina inserida com sucesso.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void atualizarDisciplina(Disciplina disciplina) {

		try {

			Connection connection = Connecting.getInstance().getConnection();
			String sql = "UPDATE disciplina SET NOME = ?, CREDITOS = ? WHERE CODIGO = ?";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, disciplina.getNome());
			statement.setInt(2, disciplina.getCreditos());
			statement.setLong(3, disciplina.getCodigo());

			statement.execute();
			statement.close();
			connection.close();

			System.out.print("Disciplina atualizada com sucesso.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removerDisciplina(Disciplina disciplina) {

		try {

			Connection connection = Connecting.getInstance().getConnection();
			String sql = "DELETE from disciplina WHERE codigo = ?";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setLong(1, disciplina.getCodigo());

			statement.execute();
			statement.close();
			connection.close();

			System.out.print("Disciplina excluída com sucesso.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Disciplina> getDisciplinas() {
		List<Disciplina> disciplina = new ArrayList<Disciplina>();

		try {

			Connection connection = Connecting.getInstance().getConnection();
			String sql = "SELECT * FROM disciplina";
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				long codigo = resultSet.getLong("CODIGO");
				String nome = resultSet.getString("NOME");
				int creditos = resultSet.getInt("CREDITOS");

				Disciplina disc = new Disciplina();
				disc.setCodigo(codigo);
				disc.setNome(nome);
				disc.setCreditos(creditos);

				disciplina.add(disc);
			}

			resultSet.close();
			statement.close();
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		for (int i = 0; i < disciplina.size(); i++) {
			Disciplina disciplina1 = disciplina.get(i);
			System.out.println(disciplina1.toString());
		}

		return disciplina;
	}
}
