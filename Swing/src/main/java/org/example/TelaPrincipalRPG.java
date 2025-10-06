package org.example;

import org.example.estilo.Estilo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TelaPrincipalRPG {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Cadastro RPG");
        frame.setSize(300, 200);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new FlowLayout());

        JButton btnPersonagem = new JButton("Cadastrar Personagem");
        Estilo.botaoPersonagem(btnPersonagem);
        JButton btnInimigo = new JButton("Cadastrar Inimigo");
        Estilo.botaoInimigo(btnInimigo);

        frame.add(btnPersonagem);
        frame.add(btnInimigo);

        btnPersonagem.addActionListener(e -> abrirFormularioPersonagem());
        btnInimigo.addActionListener(e -> abrirFormularioInimigo());

        frame.setVisible(true);
    }

    private static void abrirFormularioPersonagem() {
        JFrame form = new JFrame("Novo Personagem");
        form.setSize(400, 300);
        form.setLayout(new GridLayout(5, 2));

        JTextField nome = new JTextField();
        JTextField idade = new JTextField();
        JTextField arma = new JTextField();
        JTextField descricao = new JTextField();
        JButton salvar = new JButton("Salvar");
        Estilo.aplicarBotao(salvar);

        form.add(new JLabel("Nome:"));
        form.add(nome);
        form.add(new JLabel("Idade:"));
        form.add(idade);
        form.add(new JLabel("Arma:"));
        form.add(arma);
        form.add(new JLabel("Descrição:"));
        form.add(descricao);
        form.add(salvar);

        salvar.addActionListener(e -> {
            try (Connection conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/projetorpg", "root", "")) {
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

        form.setVisible(true);
    }

    private static void abrirFormularioInimigo() {
        JFrame form = new JFrame("Novo Inimigo");
        form.setSize(400, 250);
        form.setLayout(new GridLayout(4, 2));

        JTextField raca = new JTextField();
        JTextField poder = new JTextField();
        JTextField caracteristica = new JTextField();
        JButton salvar = new JButton("Salvar");
        Estilo.aplicarBotao(salvar);

        form.add(new JLabel("Raça:"));
        form.add(raca);
        form.add(new JLabel("Poder:"));
        form.add(poder);
        form.add(new JLabel("Característica:"));
        form.add(caracteristica);
        form.add(salvar);

        salvar.addActionListener(e -> {
            try (Connection conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/projetorpg", "root", "")) {
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
