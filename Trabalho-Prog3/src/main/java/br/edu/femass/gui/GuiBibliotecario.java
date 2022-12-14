package br.edu.femass.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiBibliotecario {
    public Container getJPanel;
    public Container getjPanel;
    private JPanel jPBibliotecario;
    private JButton bntCadAutor;
    private JButton bntCadLivro;
    private JButton bntExemplar;

    public GuiBibliotecario() {
        bntCadAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAutor guiAutor = new GuiAutor();
                JFrame frame = new JFrame("Autor");
                try {
                    new GuiAutor().abrirTelaModal();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                frame.setContentPane(guiAutor.getjPanel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        bntCadLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLivro guiLivro = new GuiLivro();
                JFrame frame = new JFrame("Livro");
                try{
                    new GuiLivro().abrirTelaModal();
                }catch (Exception m){
                    JOptionPane.showMessageDialog(null, m.getMessage());
                }
                frame.setContentPane(guiLivro.getjPanel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        bntExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiExemplar guiExemplar = new GuiExemplar();
                JFrame frame = new JFrame("Exemplar");
                try{
                    new GuiExemplar().abrirTelaModal();
                }catch (Exception m){
                    JOptionPane.showMessageDialog(null, m.getMessage());
                }
                frame.setContentPane(guiExemplar.getjPanel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public void abrirTela() {
        JFrame frame = new JFrame();
        GuiBibliotecario guiBibliotecario = new GuiBibliotecario();
        frame.setContentPane(guiBibliotecario.jPBibliotecario);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu do Bibliotec??rio(a):");
        frame.pack();
        frame.setVisible(true);
    }

    public void abrirTelaModal() {
        JDialog frame = new JDialog(new Frame(), true);
        GuiBibliotecario guiBibliotecario = new GuiBibliotecario();
        frame.setContentPane(guiBibliotecario.jPBibliotecario);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu do Bibliotec??rio(a):");
        frame.pack();
        frame.setVisible(true);
    }
}
