package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.model.Aluno;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

public class GuiAluno {
    public Container getJPanel;
    public Container getjPanel;
    private JTextField txtNome;
    private JLabel txtMatricula;
    private JTextField txtEndereco;
    private JFormattedTextField txtTelefone;
    private JButton btnSalvar;
    private JPanel jPanel;
    private JScrollPane jScrollPane;
    private JList lstAlunos;
    private JFormattedTextField formattedTextField1;

    public GuiAluno() {

        //SALVAR
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Aluno aluno = new Aluno(txtMatricula.getText(), txtNome.getText(), txtEndereco.getText(), txtTelefone.getText());
                    new DaoAluno().save(aluno);
                    preencherLista();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        //ADICIONAR NA LISTA
        lstAlunos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Aluno aluno = (Aluno) lstAlunos.getSelectedValue();

                if (aluno == null) return;

                txtMatricula.setText(aluno.getMatricula());
                txtNome.setText(aluno.getNome());
                txtEndereco.setText(aluno.getEndereco());
                txtTelefone.setText(aluno.getTelefone());
            }
        });
    }

    private void preencherLista(){
        try {
            lstAlunos.setListData(
                    new DaoAluno().getAll().toArray(new Aluno[0]));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void abrirTela(){
        GuiAluno guiAluno = new GuiAluno();

        JFrame frame = new JFrame("Aluno");
        guiAluno.preencherLista();
        frame.setContentPane(guiAluno.jPanel);

        //Fecha a tela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Máscara de formatação
        try {
            MaskFormatter mascara = new MaskFormatter("(##) #####-####");
            mascara.install(guiAluno.txtTelefone);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        frame.pack();

        frame.setVisible(true);
        //Fecha a tela e o programa roda em background
        //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}