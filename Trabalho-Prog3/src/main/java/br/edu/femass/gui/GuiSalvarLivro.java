package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiSalvarLivro {
    private JTextField txtCodigo;
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtAno;
    private JButton salvarButton;
    private JPanel jPSalvarLivro;

    public GuiSalvarLivro() {
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Livro livro = new Livro(txtCodigo.getText(), txtTitulo.getText(), txtAutor.getText(), txtAno.getText());
                    new DaoLivro().save(livro);
                    System.out.println(livro);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public void abrirTela() {
        JFrame frame = new JFrame();
        GuiSalvarLivro guiSalvarLivro = new GuiSalvarLivro();
        frame.setContentPane(guiSalvarLivro.jPSalvarLivro);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu de Livros:");
        frame.pack();
        frame.setVisible(true);
    }

    public void abrirTelaModal() {
        JDialog frame = new JDialog(new Frame(), true);
        GuiSalvarLivro guiSalvarLivro = new GuiSalvarLivro();
        frame.setContentPane(guiSalvarLivro.jPSalvarLivro);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu de Livros:");
        frame.pack();
        frame.setVisible(true);
    }
}
