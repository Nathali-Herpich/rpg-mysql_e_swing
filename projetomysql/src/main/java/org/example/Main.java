package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Cadastro de livros");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());


        JButton btnCadastrarLivro = new JButton("Cadastrar livro novo: ");
        JButton btnVisualizar = new JButton("Visualizar livros cadastrados");
        JButton sair = new JButton("Sair");


        frame.add(btnCadastrarLivro);
        frame.add(btnVisualizar);
        frame.add(sair);


        btnCadastrarLivro.addActionListener(e -> abrirFormularioLivros());
        btnVisualizar.addActionListener(e -> abrirtabela());
        sair.addActionListener(e -> sair());

        frame.setVisible(true);
    }

    private static void abrirFormularioLivros() {
        JFrame form = new JFrame("Novo livro");
        form.setSize(400, 300);
        form.setLayout(new GridLayout(5, 2));

        JTextField titulo = new JTextField();
        JTextField autor = new JTextField();
        JTextField ano = new JTextField();
        JTextField genero = new JTextField();
        JButton salvar = new JButton("Salvar");

        form.add(new JLabel("Título "));
        form.add(titulo);
        form.add(new JLabel("Autor"));
        form.add(autor);
        form.add(new JLabel("Ano de lançamento "));
        form.add(ano);
        form.add(new JLabel("Gênero do livro"));
        form.add(genero);
        form.add(salvar);

        salvar.addActionListener(e -> {
            try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/livros", "root", "xxxxxxxxx")) {
                String sql = "INSERT INTO livros (titulo, autor, ano, genero) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1, autor.getText());
                stmt.setString(2, autor.getText());
                stmt.setInt(3, Integer.parseInt(ano.getText()));
                stmt.setString(4, genero.getText());

                stmt.executeUpdate();

                JOptionPane.showMessageDialog(form, "Livro Cadastrado");
                form.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(form, "Erro: " + ex.getMessage());
            }
        });

        form.setVisible(true);
    }

    private static void abrirtabela() {
        JFrame form = new JFrame("Livros cadastrados");
        form.setSize(500, 300);
        form.setLayout(new BorderLayout());

        String[] colunas = {"Título", "Autor", "Ano", "Gênero"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        form.add(scrollPane, BorderLayout.CENTER);

        try (Connection conexao = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/livros", "root", "xxxxxxxxx")) {

            String sql = "SELECT titulo, autor, ano, genero FROM livros";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int ano = rs.getInt("ano");
                String genero = rs.getString("genero");

                Object[] linha = {titulo, autor, ano, genero};
                modelo.addRow(linha);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, "Erro: " + ex.getMessage());
        }

        form.setVisible(true);
    }

    private static void sair() {
        System.exit(0);
    }
}
