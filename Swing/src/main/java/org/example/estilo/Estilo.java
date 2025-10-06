package org.example.estilo;

import javax.swing.*;
import java.awt.*;

public class Estilo {
    public static void aplicarBotao(JButton salvar) {
        salvar.setBackground(Color.DARK_GRAY);
        salvar.setForeground(Color.WHITE);
        salvar.setFont(new Font("Verdana",Font.PLAIN,16));
        salvar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public static void botaoPersonagem(JButton btn) {
        btn.setBackground(Color.DARK_GRAY);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Verdana",Font.PLAIN,14));
        btn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public static void botaoInimigo(JButton btn1) {
        btn1.setBackground(Color.DARK_GRAY);
        btn1.setForeground(Color.WHITE);
        btn1.setFont(new Font("Verdana",Font.PLAIN,14));
        btn1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
