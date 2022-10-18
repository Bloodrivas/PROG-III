package br.edu.femass.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPrincipal {
    private JPanel jPanel;
    private JLabel txtMenu;
    private JButton bntBibliotecario;
    private JButton bntLeitores;
    private javax.swing.JPanel JPanel;

    public JPanel getJPanel() {
        return JPanel;
    }

    public GuiPrincipal() {
        bntBibliotecario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiBibliotecario guiBibliotecario = new GuiBibliotecario();
                JFrame frame = new JFrame("Bibliotecário");
               // frame.setContentPane(guiBibliotecario.getJPanel);
            }
        });
        bntLeitores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
