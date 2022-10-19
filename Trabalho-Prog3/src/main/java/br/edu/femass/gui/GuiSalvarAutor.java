package br.edu.femass.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiSalvarAutor {
    private JPanel jPanel;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtNacionalidade;
    private JButton bntSalvar;
    private Container getjPanel;

    public GuiSalvarAutor() {
        bntSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiSalvarAutor guiSalvarAutor = new GuiSalvarAutor();
                JFrame frame = new JFrame("Cadastrar Autor");
                frame.setContentPane(guiSalvarAutor.getjPanel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public void abrirTela() {
        JFrame frame = new JFrame();
        GuiSalvarAutor guiSalvarAutor = new GuiSalvarAutor();
        frame.setContentPane(guiSalvarAutor.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu do Bibliotecário(a):");
        frame.pack();
        frame.setVisible(true);
    }

    public void abrirTelaModal() {
        JDialog frame = new JDialog(new Frame(), true);
        GuiSalvarAutor guiSalvarAutor = new GuiSalvarAutor();
        frame.setContentPane(guiSalvarAutor.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu do Bibliotecário(a):");
        frame.pack();
        frame.setVisible(true);
    }
}
