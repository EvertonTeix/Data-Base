package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.Connecting;

public class ListarTurmas {

	public void listarTurmas() {

		try {

			Connection connection = Connecting.getInstance().getConnection();
			String sql = "SELECT * FROM turmas_info";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String disciplina = resultSet.getString("disciplina");
				String periodo = resultSet.getString("periodo");
				int quantidadeEstudantes = resultSet.getInt("quantidade_estudantes");
				double maiorNota = resultSet.getDouble("maior_nota");
				double menorNota = resultSet.getDouble("menor_nota");
				double mediaNotas = resultSet.getDouble("media_notas");

				System.out.println("\nDisciplina: " + disciplina);
				System.out.println("Período: " + periodo);
				System.out.println("Quantidade de estudantes: " + quantidadeEstudantes);
				System.out.println("Maior nota: " + maiorNota);
				System.out.println("Menor nota: " + menorNota);
				System.out.println("Média das notas: " + mediaNotas);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
