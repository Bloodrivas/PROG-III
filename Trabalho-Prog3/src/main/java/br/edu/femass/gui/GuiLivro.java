package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Livro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class GuiLivro {
    public Container getJPanel;
    public Container getjPanel;
    private JPanel jPLivro;
    private JLabel txtCodigo;
    private JFormattedTextField formattedTextField1;
    private JTextField textField1;
    private JLabel txtTitulo;
    private JLabel txtAutor;
    private JTextField textField2;
    private JLabel txtAno;
    private JFormattedTextField formattedTextField2;
    private JButton bntCadLivro;
    private JList lstLivro;


    public GuiLivro() {
        bntCadLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiSalvarAutor().abrirTelaModal();
                try {
                    preencherLista();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        lstLivro.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    Livro livro = (Livro) lstLivro.getSelectedValue();

                    if (livro == null) return;
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.getMessage());
                }

                //txtCodigo.setText(livro.getCodigo());
                //              txtTitulo.setText(livro.getTitulo());
                //            txtAutor.setText(livro.getAutor());
                //          txtAno.setText(livro.getAno());}
            }
        });
    }

    private void preencherLista(){
        try {
            lstLivro.setListData(
                    new DaoAluno().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void abrirTela() {
        JFrame frame = new JFrame();
        GuiLivro guiLivro = new GuiLivro();
        frame.setContentPane(guiLivro.jPLivro);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu de Livros:");
        frame.pack();
        frame.setVisible(true);
    }

    public void abrirTelaModal() {
        JDialog frame = new JDialog(new Frame(), true);
        GuiLivro guiLivro = new GuiLivro();
        frame.setContentPane(guiLivro.jPLivro);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu de Livros:");
        frame.pack();
        frame.setVisible(true);
    }

}
