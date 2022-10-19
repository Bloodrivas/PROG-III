package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiAutor {
    public Container getJPanel;
    public Container getjPanel;
    private JPanel jPanel;
    private JList lstAutor;
    private JComboBox cboNome;
    private JComboBox cboSobrenome;
    private JComboBox cboNacionalidade;
    private JButton bntSalvar;
    private JButton bntCadastrarNovo;
    private JLabel txtNome;
    private JLabel txtSobrenome;
    private JLabel txtNacionalidade;

    public GuiAutor() {
        lstAutor.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Autor autor = (Autor) lstAutor.getSelectedValue();
                if(autor == null) return;

                txtNome.setText(autor.getNome().toString());
                txtSobrenome.setText(autor.getSobrenome().toString());
                txtNacionalidade.setText(autor.getNacionalidade().toString());
                cboNome.setSelectedItem(autor.getNome());
                cboSobrenome.setSelectedItem(autor.getSobrenome());
                cboNacionalidade.setSelectedItem(autor.getNacionalidade());
            }
        });
        bntCadastrarNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiSalvarAutor().abrirTelaModal();
                try {
                    preencherListaAutores();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        bntSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Autor autor = new Autor(
                            (Autor) cboNome.getSelectedItem(),
                            cboSobrenome.getSelectedItem(),
                            cboNacionalidade.getSelectedItem()
                    );
                    new DaoAutor().save(autor);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    private void preencherLista() throws Exception {
        try{
            lstAutor.setListData(new DaoAutor().getAll().toArray());
        }catch (Exception ee){
            JOptionPane.showMessageDialog(null, ee.getMessage());
        }
    }

    private void preencherListaAutores() throws Exception {
        try{
            List<Autor> autores = new DaoAutor().getAll();
            cboNome.removeAllItems();
            cboSobrenome.removeAllItems();
            cboNacionalidade.removeAllItems();
            for(Autor autor:autores){
                cboNome.addItem(autor);
                cboSobrenome.addItem(autor);
                cboNacionalidade.addItem(autor);
            }
            //lstAutor.setListData(new DaoAutor().getAll().toArray());
        }catch (Exception ee){
            JOptionPane.showMessageDialog(null, ee.getMessage());
        }
    }

    public void abrirTela() throws Exception {
        JFrame frame = new JFrame();
        GuiAutor guiAutor = new GuiAutor();
        guiAutor.preencherLista();
        guiAutor.preencherListaAutores();
        frame.setContentPane(guiAutor.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu do Bibliotecário(a):");
        frame.pack();
        frame.setVisible(true);
    }

    public void abrirTelaModal() throws Exception {
        JDialog frame = new JDialog(new Frame(), true);
        GuiAutor guiAutor = new GuiAutor();
        guiAutor.preencherLista();
        guiAutor.preencherListaAutores();
        frame.setContentPane(guiAutor.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu do Bibliotecário(a):");
        frame.pack();
        frame.setVisible(true);
    }
}
