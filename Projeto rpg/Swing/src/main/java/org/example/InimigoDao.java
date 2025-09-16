package org.example;

import org.example.Inimigo.Inimigo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InimigoDao {
    private Connection conexao;

    public InimigoDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void salvar(Inimigo p) throws SQLException {
        String sql = "INSERT INTO personagem (raca, poder, caracteristica) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, p.getRaca());
        stmt.setInt(2, p.getPoder());
        stmt.setString(3, p.getCaracteristica());
        stmt.executeUpdate();
    }
}
