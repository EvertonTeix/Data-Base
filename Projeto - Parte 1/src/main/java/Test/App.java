package Test;

import java.util.*;
import DTO.*;
import DAO.*;

public class App {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StudentManager studentManager = new StudentManager();
		Student student = new Student();

		int opcao_menu;

		do {
			System.out.print(
					"\n_________ MENU _________\n\n0 - SAIR\n1 - ADICIONAR ESTUDANTE\n2 - LISTAR ESTUDANTES\n3 - ATUALIZAR ESTUDANTE\n4 - REMOVER ESTUDANTE\n");
			System.out.print("\nDigite a opcao que deseja: ");
			opcao_menu = input.nextInt();

			switch (opcao_menu) {

			case 1:

				input.nextLine();

				System.out.print("\nDigite o nome do estudante: ");
				String nome = input.nextLine();

				System.out.print("Digite o email do estudante: ");
				String email = input.nextLine();

				student.setName(nome);
				student.setEmail(email);

				studentManager.addStudent(student);

				break;

			case 2:

				studentManager.getStudents();

				break;

			case 3:

				studentManager.getStudents();

				System.out.print("\nDigite o id do estudante que deseja atualizar: ");
				long id = input.nextLong();

				input.nextLine();

				System.out.print("\nDigite o novo nome do estudante: ");
				String novo_nome = input.nextLine();

				System.out.print("Digite o novo email do estudante: ");
				String novo_email = input.nextLine();

				student.setId(id);
				student.setName(novo_nome);
				student.setEmail(novo_email);

				studentManager.updateStudent(student);

				break;

			case 4:

				studentManager.getStudents();

				input.nextLine();

				System.out.print("\nDigite o id do estudante que deseja remover: ");
				long idRemover = input.nextInt();

				student.setId(idRemover);
				studentManager.deleteStudent(student);

				break;
			}

		} while (opcao_menu != 0);

		input.close();
	}

}
