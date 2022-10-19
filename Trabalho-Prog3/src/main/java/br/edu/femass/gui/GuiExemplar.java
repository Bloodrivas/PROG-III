package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiExemplar {
    public Container getJPanel;
    public Container getjPanel;
    private JPanel jPExemplar;
    private JList lstExemplar;
    private JButton bntNovoExemplar;

    public GuiExemplar() {
        updateList();
        bntNovoExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiSalvarExemplar().abrirTelaModal();
                try {
                    preencherLista();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        lstExemplar.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    Exemplar exemplar = new Exemplar(lstExemplar.getSelectedValue().toString());
                    new DaoExemplar().save(exemplar);
                    updateList();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    private void updateList() {
        try {
            List<Livro> livros = new DaoLivro().getAll();
            lstExemplar.setListData(livros.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void preencherLista(){
        try {
            lstExemplar.setListData(
                    new DaoAluno().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void abrirTela() {
        JFrame frame = new JFrame();
        GuiExemplar guiExemplar = new GuiExemplar();
        frame.setContentPane(guiExemplar.jPExemplar);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu do Bibliotecário(a):");
        frame.pack();
        frame.setVisible(true);
    }

    public void abrirTelaModal() {
        JDialog frame = new JDialog(new Frame(), true);
        GuiExemplar guiExemplar = new GuiExemplar();
        frame.setContentPane(guiExemplar.jPExemplar);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu do Bibliotecário(a):");
        frame.pack();
        frame.setVisible(true);
    }
}
