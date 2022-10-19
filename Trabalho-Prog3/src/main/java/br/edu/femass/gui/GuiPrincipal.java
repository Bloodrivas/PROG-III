package br.edu.femass.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPrincipal {
    private JPanel jPanel;
    private JLabel txtMenu;
    private JButton bntBibliotecario;
    private JButton bntAtendente;
    private javax.swing.JPanel JPanel;

    public JPanel getJPanel() {
        return JPanel;
    }

    public GuiPrincipal() {
        bntBibliotecario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiBibliotecario guiBibliotecario = new GuiBibliotecario();
                new GuiBibliotecario().abrirTelaModal();
                JFrame frame = new JFrame("Bibliotecário");
                frame.setContentPane(guiBibliotecario.getjPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        bntAtendente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAtendente guiAtendente = new GuiAtendente();
                new GuiAtendente().abrirTelaModal();
                JFrame frame = new JFrame("Atendente");
                frame.setContentPane(guiAtendente.getjpanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public void abrirTela() {
        JFrame frame = new JFrame();
        GuiPrincipal guiPrincipal = new GuiPrincipal();
        frame.setContentPane(guiPrincipal.jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Menu Principal");
        frame.pack();
        frame.setVisible(true);
    }
}
