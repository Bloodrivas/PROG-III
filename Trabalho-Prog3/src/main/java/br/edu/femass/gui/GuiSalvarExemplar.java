package br.edu.femass.gui;

import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiSalvarExemplar {
    private JPanel jPSalvarExemplar;
    private JTextField txtCodigo;
    private JFormattedTextField txtData;
    private JButton salvarButton;

    public GuiSalvarExemplar() {
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Exemplar exemplar = new Exemplar(txtCodigo.getText(), txtData.getText());
                    new DaoExemplar().save(exemplar);
                    System.out.println(exemplar);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public void abrirTela() {
        JFrame frame = new JFrame();
        GuiSalvarExemplar guiSalvarExemplar = new GuiSalvarExemplar();
        frame.setContentPane(guiSalvarExemplar.jPSalvarExemplar);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu de Exemplares:");
        frame.pack();
        frame.setVisible(true);
    }

    public void abrirTelaModal() {
        JDialog frame = new JDialog(new Frame(), true);
        GuiSalvarExemplar guiSalvarExemplar = new GuiSalvarExemplar();
        frame.setContentPane(guiSalvarExemplar.jPSalvarExemplar);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu de Livros:");
        frame.pack();
        frame.setVisible(true);
    }
}
