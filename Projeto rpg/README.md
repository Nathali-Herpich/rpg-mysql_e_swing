# 📚 Projeto RPG com Java, Swing e MySQL básicos
Este guia tem como objetivo ajudar você a entender e aplicar os principais conceitos usados no desenvolvimento de um sistema de cadastro para personagens e inimigos de RPG, utilizando Java, Swing para interface gráfica e MySQL como banco de dados.

## 🧠 Conceitos Envolvidos
- 🔸 Java
Linguagem de programação orientada a objetos, usada para criar aplicações robustas e multiplataforma.

- 🔸 Swing
Biblioteca gráfica do Java que permite criar interfaces visuais (janelas, botões, campos de texto, etc).

- 🔸 MySQL
Sistema de gerenciamento de banco de dados relacional, usado para armazenar os dados do projeto.

- 🔸 JDBC
API do Java que permite conectar e executar comandos SQL em bancos de dados.

## 🧱 Estrutura do Projeto
### 📁 Pacotes e Classes
- TelaPrincipalRPG: janela inicial com botões para cadastrar personagens ou inimigos.

- Personagem e Inimigo: classes que representam os dados.

- PersonagemDAO e InimigoDAO: classes responsáveis por salvar os dados no banco.

## 🗃️ Banco de Dados MySQL
Criação do banco:
```` sql
CREATE DATABASE projetorpg;
USE projetorpg;
````
Tabela personagem:
```` sql
CREATE TABLE personagem (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100),
  idade INT,
  arma VARCHAR(50),
  descricao TEXT
);
`````
Tabela inimigos:
``` sql
CREATE TABLE inimigos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  raca VARCHAR(100),
  poder INT,
  caracteristica TEXT
);
````
## 🔌 Conexão com MySQL via JDBC
Exemplo de conexão:

```` java
Connection conexao = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/projetorpg", "root", "SUA_SENHA");
````
Inserção de dados:
````java
String sql = "INSERT INTO personagem (nome, idade, arma, descricao) VALUES (?, ?, ?, ?)";
PreparedStatement stmt = conexao.prepareStatement(sql);
stmt.setString(1, nome);
stmt.setInt(2, idade);
stmt.setString(3, arma);
stmt.setString(4, descricao);
stmt.executeUpdate();
`````
## 🧪 Verificando dados no banco
Comando para listar personagens:
````sql
SELECT * FROM personagem;
````
Comando para listar inimigos:
````sql
SELECT * FROM inimigos;
`````

