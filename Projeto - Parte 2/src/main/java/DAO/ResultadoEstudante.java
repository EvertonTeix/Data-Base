package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.Connecting;
import DTO.*;

public class ResultadoEstudante {

	public void adcionarResultadoEstudante(AlunoDisciplina alunoDisciplina) {

		try {

			Connection connection = Connecting.getInstance().getConnection();
			String sql = "INSERT INTO aluno_disciplina (aluno_matr, disciplina_cod, frequencia, nota, periodo) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setLong(1, alunoDisciplina.getAluno_matr());
			statement.setLong(2, alunoDisciplina.getDisciplina_cod());
			statement.setInt(3, alunoDisciplina.getFrequencia());
			statement.setFloat(4, alunoDisciplina.getNota());
			statement.setString(5, alunoDisciplina.getPeriodo());

			statement.execute();
			connection.close();

			System.out.print("Resultado inserido com sucesso.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void exibirHistorico(Aluno aluno) {

		try {

			Connection connection = Connecting.getInstance().getConnection();
			String sql = "SELECT d.nome, ad.periodo, ad.nota, ad.frequencia "
						+ "FROM aluno_disciplina ad "
						+ "JOIN aluno a ON a.matricula = ad.aluno_matr "
						+ "JOIN disciplina d ON d.codigo = ad.disciplina_cod "
						+ "WHERE a.matricula = ?";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setLong(1, aluno.getMatricula());		
			ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            String nomeDisciplina = resultSet.getString("nome");
	            String periodo = resultSet.getString("periodo");
	            float nota = resultSet.getFloat("nota");
	            double frequencia = resultSet.getDouble("frequencia");

	            System.out.print("\nDisciplina: " + nomeDisciplina);
	            System.out.print("\nPeríodo: " + periodo);
	            System.out.print("\nNota: " + nota);
	            System.out.print("\nFrequência: " + frequencia + "%");
	            System.out.print("\n------------------------");
	        }

	        resultSet.close();
	        statement.close();
	        connection.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exibirTurma(AlunoDisciplina alunoDisciplina) {

		try {

			Connection connection = Connecting.getInstance().getConnection();
			String sql = "SELECT a.matricula, a.nome, ad.nota, ad.frequencia "
					+ "FROM aluno_disciplina ad "
					+ "JOIN aluno a on a.matricula = ad.aluno_matr "
					+ "JOIN disciplina d on d.codigo = ad.disciplina_cod "
					+ "WHERE d.codigo = " + alunoDisciplina.getDisciplina_cod() + " AND ad.periodo = '" + alunoDisciplina.getPeriodo() + "'";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	        	Long matricula = resultSet.getLong("matricula");
	            String nome = resultSet.getString("nome");
	            float nota = resultSet.getFloat("nota");
	            double frequencia = resultSet.getDouble("frequencia");

	            System.out.print("\nMatrícula: " + matricula);
	            System.out.print("\nNome: " + nome);
	            System.out.print("\nNota: " + nota);
	            System.out.print("\nFrequência: " + frequencia + "%");
	            System.out.print("\n------------------------");
	        }

	        resultSet.close();
	        statement.close();
	        connection.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
