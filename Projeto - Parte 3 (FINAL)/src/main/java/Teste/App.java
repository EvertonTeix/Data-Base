package Teste;

import java.util.*;
import DTO.*;
import DAO.*;

public class App {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		AlunoMetodos alunoMetodos = new AlunoMetodos();
		Aluno aluno = new Aluno();
		DisciplinaMetodos disciplinaMetodos = new DisciplinaMetodos();
		Disciplina disciplina = new Disciplina();
		ResultadoEstudante resultadoEstudante = new ResultadoEstudante();
		AlunoDisciplina alunoDisciplina = new AlunoDisciplina();
		ListarTurmas listarTurmas = new ListarTurmas();
		
		
		
		int opcao_menu;
		
		do {
			System.out.print(
					"\n_________ MENU _________\n"
					+ "\n0 - SAIR"
					+ "\n1 - ADICIONAR ESTUDANTE"
					+ "\n2 - LISTAR ESTUDANTES"
					+ "\n3 - ATUALIZAR ESTUDANTE"
					+ "\n4 - REMOVER ESTUDANTE"
					+ "\n5 - BUSCAR ESTUDANTES"
					+ "\n6 - INSERIR DISCIPLINAS"
					+ "\n7 - LISTAR DISCIPLINAS"
					+ "\n8 - ATUALIZAR DISCIPLINA"
					+ "\n9 - REMOVER DISCIPLINA"
					+ "\n10 - ADICIONAR RESULTADO ESTUDANTE"
					+ "\n11 - EXIBIR HISTÓRICO ESTUDANTE"
					+ "\n12 - EXIBIR TURMA"
					+ "\n13 - LISTAR TURMAS\n");
			
			System.out.print("\nDigite a opcao que deseja: ");
			opcao_menu = input.nextInt();

			switch (opcao_menu) {

			case 1:

				input.nextLine();

				System.out.print("\nDigite o nome do estudante: ");
				String nome = input.nextLine();
				aluno.setNome(nome);

				System.out.print("Digite o email do estudante: ");
				String email = input.nextLine();
				aluno.setEmail(email);
				
				System.out.print("Digite o telefone: ");
				String telefone = input.nextLine();
				aluno.setTelefone(telefone);
				
				System.out.print("Digite o sexo do estudante: ");
				String sexo = input.nextLine();
				aluno.setSexo(sexo);
				
				System.out.print("Digite a data de nascimento (separada por espaço)");
				int dia = input.nextInt();
				int mes = input.nextInt();
				int ano = input.nextInt();
				
				GregorianCalendar data = new GregorianCalendar(ano, mes - 1, dia);
				aluno.setData_nasc(data);
				
				alunoMetodos.adicionarAluno(aluno);
				break;

			case 2:

				alunoMetodos.getAlunos();

				break;

			case 3:

				alunoMetodos.getAlunos();
				
				System.out.print("\nDigite a matrícula do estudante que deseja atualizar: ");
				long matricula = input.nextLong();
				aluno.setMatricula(matricula);
				
				input.nextLine();

				System.out.print("\nDigite o novo nome do estudante: ");
				String novo_nome = input.nextLine();
				aluno.setNome(novo_nome);

				System.out.print("Digite o novo email do estudante: ");
				String novo_email = input.nextLine();
				aluno.setEmail(novo_email);
				
				System.out.print("Digite o novo telefone: ");
				String novo_telefone = input.nextLine();
				aluno.setTelefone(novo_telefone);
				
				System.out.print("Digite o sexo do estudante: ");
				String novo_sexo = input.nextLine();
				aluno.setSexo(novo_sexo);
				
				System.out.print("Digite a nova data de nascimento (separada por espaço)");
				int novo_dia = input.nextInt();
				int novo_mes = input.nextInt();
				int novo_ano = input.nextInt();
				
				GregorianCalendar nova_data = new GregorianCalendar(novo_ano, novo_mes - 1, novo_dia);
				aluno.setData_nasc(nova_data);
				
				alunoMetodos.atualizarAluno(aluno);

				break;

			case 4:

				alunoMetodos.getAlunos();

				input.nextLine();

				System.out.print("\nDigite a matrícula do estudante que deseja remover: ");
				long matriculaRemover = input.nextInt();

				aluno.setMatricula(matriculaRemover);
				alunoMetodos.removerAluno(aluno);

				break;
				
			case 5: 
				
				input.nextLine();
				
				System.out.print("\nDigite sua busca: ");
				String busca = input.nextLine();
				
				alunoMetodos.buscarAluno(busca);
				
				break;
				
			case 6:
				
				input.nextLine();

				System.out.print("\nDigite o nome da disciplina: ");
				String nome_disciplina = input.nextLine();
				disciplina.setNome(nome_disciplina);

				System.out.print("Digite a qauntidade de créditos da disciplina: ");
				int creditos = input.nextInt();
				disciplina.setCreditos(creditos);
				
				disciplinaMetodos.adicionarDisciplina(disciplina);
				
				break;
				
			case 7:
				
				disciplinaMetodos.getDisciplinas();
				
				break;
			case 8:
				
				disciplinaMetodos.getDisciplinas();
				
				System.out.print("\nDigite o código da disciplina que deseja atualizar: ");
				long código = input.nextLong();
				disciplina.setCodigo(código);
				
				input.nextLine();

				System.out.print("\nDigite o novo nome da disciplina: ");
				String novo_nome_disciplina = input.nextLine();
				disciplina.setNome(novo_nome_disciplina);

				System.out.print("Digite a nova quantidade de créditos da disciplina ");
				int novo_credito = input.nextInt();
				disciplina.setCreditos(novo_credito);
				
				disciplinaMetodos.atualizarDisciplina(disciplina);
				
				
				break;
			case 9:
				
				disciplinaMetodos.getDisciplinas();
				
				System.out.print("\nDigite o código da disciplina que deseja remover: ");
				int removerDisciplina = input.nextInt();
				
				disciplina.setCodigo(removerDisciplina);
				disciplinaMetodos.removerDisciplina(disciplina);
				break;
				
			case 10: 
				
				alunoMetodos.getAlunos();
				System.out.print("\nDigite a matrícula do aluno: ");
				long aluno_matr = input.nextLong();
				alunoDisciplina.setAluno_matr(aluno_matr);
				
				disciplinaMetodos.getDisciplinas();
				System.out.print("\nDigite o código da disciplina: ");
				long disciplin_cod = input.nextLong();
				alunoDisciplina.setDisciplina_cod(disciplin_cod);
				
				input.nextLine();
				
				System.out.print("Digite o período (ex.: 2023.1):");
				String periodo = input.nextLine();
				alunoDisciplina.setPeriodo(periodo);
				
				System.out.print("Digite a nota do aluno (0 a 10): ");
				float nota = input.nextFloat();
				alunoDisciplina.setNota(nota);
				
				System.out.print("Digite a frequência do aluno (0 a 100): ");
				int frequencia = input.nextInt();
				alunoDisciplina.setFrequencia(frequencia);
				
				
				resultadoEstudante.adcionarResultadoEstudante(alunoDisciplina);
				
				break;
				
			case 11:
				
				alunoMetodos.getAlunos();
				
				System.out.print("\nDigite a matrícula do estudante que deseja exibir o histórico: ");
				Long matricula_exibir_historico = input.nextLong();
				aluno.setMatricula(matricula_exibir_historico);
				
				resultadoEstudante.exibirHistorico(aluno);
				break;
				
			case 12: 
				
				disciplinaMetodos.getDisciplinas();
				
				System.out.print("\nDigite o código da disciplina que deseja exibir a turma:  ");
				Long cod_dis = input.nextLong();
				alunoDisciplina.setDisciplina_cod(cod_dis);
				
				input.nextLine();
				
				System.out.print("Digite o período que  deseja exibir a turma:  ");
				String periodo_exibir = input.nextLine();
				alunoDisciplina.setPeriodo(periodo_exibir);
				
				resultadoEstudante.exibirTurma(alunoDisciplina);
				
				break;
				
			case 13: 
				
				listarTurmas.listarTurmas();
				
			}

		} while (opcao_menu != 0);

		input.close();
	}

}
