<h1 align="center">Data-Base</h1>

<p align="center">
  <em>Este repositório contém o projeto da disciplina de Fundamentos de Banco de Dados, feito no 3º módulo, dividido em três partes distintas, mas que se complementam.</em>
</p>

<h2>Parte 1</h2>

<div>
  <p>
    <strong>Implementação da classe StudentManager:</strong>
  </p>
  <p>
    Crie a classe <code>StudentManager</code> contendo os métodos a seguir:
  </p>
  <ul>
    <li><code>addStudent(Student student)</code></li>
    <li><code>List<Student> getStudents()</code></li>
    <li><code>updateStudent(Student student)</code></li>
    <li><code>deleteStudent(Student student)</code></li>
  </ul>
  <p>
    <em>Esses métodos são responsáveis por adicionar, listar, atualizar e remover estudantes do banco de dados.</em>
  </p>
</div>

<h2>Parte 2</h2>

<div>
  <p>
    <strong>Estrutura do Banco de Dados:</strong>
  </p>
  <p>
    O sistema de controle acadêmico envolve as entidades Aluno, Disciplina e Aluno_Disciplina.
  </p>
  <p>
    <strong>Tabela Aluno:</strong>
    <br>
    <code>aluno(matricula, nome, email, telefone, data_nasc, sexo)</code>
    <br>
    A tabela Aluno contém os seguintes campos:
    <ul>
      <li>matricula (chave primária)</li>
      <li>nome</li>
      <li>email</li>
      <li>telefone</li>
      <li>data_nasc</li>
      <li>sexo</li>
    </ul>
  </p>
  <p>
    <strong>Tabela Disciplina:</strong>
    <br>
    <code>disciplina(codigo, nome, creditos)</code>
    <br>
    A tabela Disciplina contém os seguintes campos:
    <ul>
      <li>codigo (chave primária)</li>
      <li>nome</li>
      <li>creditos</li>
    </ul>
  </p>
  <p>
    <strong>Tabela Aluno_Disciplina:</strong>
    <br>
    <code>aluno_disciplina(aluno_matr, disciplina_cod, periodo, nota, frequencia)</code>
    <br>
    A tabela Aluno_Disciplina contém os seguintes campos:
    <ul>
      <li>aluno_matr (chave estrangeira referenciando a tabela Aluno)</li>
      <li>disciplina_cod (chave estrangeira referenciando a tabela Disciplina)</li>
      <li>periodo</li>
      <li>nota</li>
      <li>frequencia</li>
    </ul>
  </p>
</div>

<div>
  <p>
    <strong>Funcionalidades do Sistema:</strong>
  </p>
  <ol>
    <li>
      Adicionar estudante:
      <ul>
        <li>Informar os dados e adicionar ao banco (a matrícula deve ser gerada automaticamente).</li>
      </ul>
    </li>
    <li>
      Atualizar estudante:
      <ul>
        <li>Informar a matrícula e, em seguida, informar os demais dados a serem atualizados.</li>
      </ul>
    </li>
    <li>
      Remover estudante:
      <ul>
        <li>Informar apenas a matrícula do estudante a ser removido.</li>
      </ul>
    </li>
    <li>
      Listar estudantes:
      <ul>
        <li>Exibir todos os dados cadastrais de todos os estudantes.</li>
      </ul>
    </li>
    <li>
      Buscar estudantes:
      <ul>
        <li>Informar uma string qualquer, e o sistema deverá listar os estudantes cuja a string informada seja parte do seu nome ou email (case insensitive, não considerar se é maiúscula ou minúscula).</li>
      </ul>
    </li>
    <li>
      Listar, adicionar, atualizar e remover disciplina:
      <ul>
        <li>Similar às funcionalidades de estudante.</li>
      </ul>
    </li>
    <li>
      Adicionar resultado do estudante:
      <ul>
        <li>Informar a matrícula do aluno, o código da disciplina, o período (ex: 2021.1), a nota (de 0 a 10) e a frequência (de 0 a 100).</li>
      </ul>
    </li>
    <li>
      Exibir histórico do estudante:
      <ul>
        <li>Informar a matrícula do estudante e exibir o nome das disciplinas que ele cursou com o respectivo período, nota e frequência (exibir como porcentagem).</li>
      </ul>
    </li>
    <li>
      Exibir turma:
      <ul>
        <li>Informar o código da disciplina e o período e exibir a matrícula, o nome, a nota e a frequência dos alunos daquela disciplina e período informados.</li>
      </ul>
    </li>
  </ol>
  <p>
    <em>Importante:</em>
    <br>
    Os dados das consultas 8 e 9 devem ser acessados através de uma única consulta.
    <br>
    Popule o banco de dados de maneira a facilitar os testes das funcionalidades.
  </p>
</div>

<h2>Parte 3</h2>

<div>
  <p>
    <strong>Funcionalidades Adicionais:</strong>
  </p>
  <ol start="10">
    <li>
      Alterar a funcionalidade de exibir estudantes:
      <ul>
        <li>Adicione a média do estudante em cada estudante (o cálculo da média deve ser feito na consulta ao banco, e não na aplicação).</li>
      </ul>
    </li>
    <li>
      Listar turmas:
      <ul>
        <li>Exiba uma linha para cada disciplina e período com o nome da disciplina, o período, a quantidade de estudantes que cursaram a disciplina, a maior nota, a menor nota e a média das notas da turma (a contagem de alunos e cálculos relacionados à nota devem ser feitos na consulta ao banco, e não na aplicação).</li>
      </ul>
    </li>
    <li>
      Criar duas views:
      <ul>
        <li>alunos_info: definida pela consulta da questão 2</li>
        <li>turmas_info: definida pela consulta da questão 3</li>
      </ul>
    </li>
    <li>
      Na tabela de aluno, acrescente uma coluna chamada "distincao" do tipo char(20).
      <br>
      Crie uma trigger (ou mais de uma, se julgar necessário) que, para cada inserção aluno_disciplina, atualiza o valor da coluna distincao da tabela aluno segundo as regras abaixo:
      <ul>
        <li>Se a média das notas do aluno for igual a 10, distincao deve ser atualizada para "Summa Cum Laude".</li>
        <li>Se a média das notas do aluno for entre 9 e 9.9, distincao deve ser atualizada para "Magna Cum Laude".</li>
      </ul>
    </li>
  </ol>
</div>
