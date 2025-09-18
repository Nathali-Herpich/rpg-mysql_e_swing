package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TelaPrincipalRPG {
    public static void main(String[] args) {
        // Ponto de entrada do programa. Tudo começa aqui.
        JFrame frame = new JFrame("Sistema de Cadastro RPG");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        // Acima está esta o código. Abaixo a explicação
        // Cria uma janela (JFrame) com título e tamanho.
        //Define que o programa será encerrado ao fechar a janela.
        //Usa FlowLayout para organizar os botões horizontalmente.


        JButton btnPersonagem = new JButton("Cadastrar Personagem");
        JButton btnInimigo = new JButton("Cadastrar Inimigo");
        // Cria dois botões para abrir os formulários de cadastro.

        frame.add(btnPersonagem);
        frame.add(btnInimigo);
        // Adiciona os botões à janela.

        btnPersonagem.addActionListener(e -> abrirFormularioPersonagem());
        btnInimigo.addActionListener(e -> abrirFormularioInimigo());
        // Define o que acontece quando os botões são clicados: abre o formulário correspondente.

        frame.setVisible(true);
        // Torna a janela visível.
    }

    private static void abrirFormularioPersonagem() {
        JFrame form = new JFrame("Novo Personagem");
        form.setSize(400, 300);
        form.setLayout(new GridLayout(5, 2));
        // Janela com layout em grade: 5 linhas e 2 colunas.

        JTextField nome = new JTextField();
        JTextField idade = new JTextField();
        JTextField arma = new JTextField();
        JTextField descricao = new JTextField();
        JButton salvar = new JButton("Salvar");
        // Campos de texto para preencher os dados do personagem.

        form.add(new JLabel("Nome:"));
        form.add(nome);
        form.add(new JLabel("Idade:"));
        form.add(idade);
        form.add(new JLabel("Arma:"));
        form.add(arma);
        form.add(new JLabel("Descrição:"));
        form.add(descricao);
        form.add(salvar);
        // Adiciona os rótulos e campos à janela.

        salvar.addActionListener(e -> {
            try (Connection conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/projetorpg", "root", "xxxxxxxxx")) {
                String sql = "INSERT INTO personagem (nome, idade, arma, descricao) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1, nome.getText());
                stmt.setInt(2, Integer.parseInt(idade.getText()));
                stmt.setString(3, arma.getText());
                stmt.setString(4, descricao.getText());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(form, "Personagem cadastrado!");
                form.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(form, "Erro: " + ex.getMessage());
            }
        });
        // Quando o botão "Salvar" é clicado;
        //Conecta ao banco projetorpg
        //Insere os dados na tabela personagem
        //Mostra uma mensagem de sucesso ou erro
        //Fecha a janela


        form.setVisible(true);
    }



    // mesma lógica do personagem, mas para inimigos

    private static void abrirFormularioInimigo() {
        JFrame form = new JFrame("Novo Inimigo");
        form.setSize(400, 250);
        form.setLayout(new GridLayout(4, 2));

        JTextField raca = new JTextField();
        JTextField poder = new JTextField();
        JTextField caracteristica = new JTextField();
        JButton salvar = new JButton("Salvar");

        form.add(new JLabel("Raça:"));
        form.add(raca);
        form.add(new JLabel("Poder:"));
        form.add(poder);
        form.add(new JLabel("Característica:"));
        form.add(caracteristica);
        form.add(salvar);

        salvar.addActionListener(e -> {
            try (Connection conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/projetorpg", "root", "xxxxxx")) {
                String sql = "INSERT INTO inimigos (raca, poder, caracteristica) VALUES (?, ?, ?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1, raca.getText());
                stmt.setInt(2, Integer.parseInt(poder.getText()));
                stmt.setString(3, caracteristica.getText());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(form, "Inimigo cadastrado!");
                form.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(form, "Erro: " + ex.getMessage());
            }
        });

        form.setVisible(true);
    }
}
