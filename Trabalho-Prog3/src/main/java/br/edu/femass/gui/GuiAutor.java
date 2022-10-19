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
    private JPanel jPAutor;
    private JList lstAutor;
    private JButton bntAtualizar;
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

                txtNome.setText(autor.getNome());
                txtSobrenome.setText(autor.getSobrenome());
                txtNacionalidade.setText(autor.getNacionalidade());
            }
        });
        bntCadastrarNovo.addActionListener(new ActionListener() {
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
        bntAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateList();
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

    public void abrirTela() throws Exception {
        JFrame frame = new JFrame();
        GuiAutor guiAutor = new GuiAutor();
        guiAutor.preencherLista();
        frame.setContentPane(guiAutor.jPAutor);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu do Bibliotecário(a):");
        frame.pack();
        frame.setVisible(true);
    }

    public void abrirTelaModal() throws Exception {
        JDialog frame = new JDialog(new Frame(), true);
        GuiAutor guiAutor = new GuiAutor();
        guiAutor.preencherLista();
        frame.setContentPane(guiAutor.jPAutor);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu do Bibliotecário(a):");
        frame.pack();
        frame.setVisible(true);
    }

    private void updateList() {
        try {
            List<Autor> autores = new DaoAutor().getAll();
            lstAutor.setListData(autores.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}