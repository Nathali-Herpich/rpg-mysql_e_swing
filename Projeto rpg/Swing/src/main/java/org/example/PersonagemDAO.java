package org.example;

import org.example.Personagem.Personagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonagemDAO  {
    private Connection conexao;

    public PersonagemDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void salvar(Personagem p) throws SQLException {
        String sql = "INSERT INTO personagem (nome, idade, arma, descricao) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, p.getNome());
        stmt.setInt(2, p.getIdade());
        stmt.setString(3, p.getArma());
        stmt.setString(4, p.getDescricao());
        stmt.executeUpdate();
    }
}
