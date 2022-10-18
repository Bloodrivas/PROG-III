package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Livro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class GuiLivro {
    private JPanel jPanel;
    private JLabel txtCodigo;
    private JFormattedTextField formattedTextField1;
    private JTextField textField1;
    private JLabel txtTitulo;
    private JLabel txtAutor;
    private JTextField textField2;
    private JLabel txtAno;
    private JFormattedTextField formattedTextField2;
    private JButton bntSalvar;
    private JList lstLivro;


    public GuiLivro() {
        bntSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Livro livro = new Livro(txtCodigo.getText(), txtTitulo.getText(), txtAutor.getText(), txtAno.getText());
                    new DaoLivro().save(livro);
                    preencherLista();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
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

//                txtCodigo.setText(livro.getCodigo());
                //              txtTitulo.setText(livro.getTitulo());
                //            txtAutor.setText(livro.getAutor());
                //          txtAno.setText(livro.getAno());}
            }
        });
    }

    private void preencherLista(){
        try {
            lstLivro.setListData(
                    new DaoAluno().getAll().toArray(new Livro[0]));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void abrirTela(){
        GuiLivro guiLivro = new GuiLivro();

        JFrame frame = new JFrame("Livro");
        guiLivro.preencherLista();
        frame.setContentPane(guiLivro.jPanel);

        //Fecha a tela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Mascara de formatação
       // try {
       //     MaskFormatter mascara = new MaskFormatter("##/##/####");
       //     mascara.install(guiLivro.txtAno);
       // } catch (ParseException e) {
       //     throw new RuntimeException(e);
       // }

        frame.pack();

        frame.setVisible(true);
    }



}
