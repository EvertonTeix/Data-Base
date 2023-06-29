package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.*;
import Connection.*;

public class StudentManager {

	public void addStudent(Student student) {

		try {
			Connection connection = Conex.getInstance().getConnection();

			String sql = "INSERT INTO student (NAME, EMAIL) VALUES (?, ?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, student.getName());
			statement.setString(2, student.getEmail());

			statement.execute();
			connection.close();

			System.out.print("Estudante inserido com sucesso.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Student> getStudents() {
		List<Student> student = new ArrayList<Student>();

		try {

			Connection connection = Conex.getInstance().getConnection();
			String sql = "SELECT * FROM student";
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				long id = resultSet.getInt("ID");
				String nome = resultSet.getString("NAME");
				String email = resultSet.getString("EMAIL");

				Student st = new Student();
				st.setId(id);
				st.setName(nome);
				st.setEmail(email);

				student.add(st);
			}

			resultSet.close();
			statement.close();
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		for (int i = 0; i < student.size(); i++) {
			Student student1 = student.get(i);
			System.out.println(student1.toString());
		}

		return student;

	}

	public void updateStudent(Student student) {

		try {

			Connection connection = Conex.getInstance().getConnection();
			String sql = "UPDATE student SET name = ?, email = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, student.getName());
			statement.setString(2, student.getEmail());
			statement.setLong(3, student.getId());

			statement.execute();
			statement.close();
			connection.close();

			System.out.print("Usuário editado com sucesso.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent(Student student) {

		try {

			Connection connection = Conex.getInstance().getConnection();
			String sql = "DELETE from student WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setLong(1, student.getId());
			statement.execute();
			statement.close();
			connection.close();

			System.out.print("Usuário excluído com sucesso.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
