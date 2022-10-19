package br.edu.femass.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAtendente {
    public Container getjPAtendente;
    //public Container getJpanel;
    //protected Container getjpanel;
    JPanel jPAtendente;
    private JButton bntProfessores;
    private JButton bntAlunos;
    private JButton bntEmprestimos;

    public GuiAtendente() {
        bntProfessores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiProfessor guiProfessor = new GuiProfessor();
                JFrame frame = new JFrame("Lista de Professores");
                frame.setContentPane(guiProfessor.getJPProfessor);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        bntAlunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAluno guiAluno = new GuiAluno();
                JFrame frame = new JFrame("Lista de Alunos");
                frame.setContentPane(guiAluno.getjPAluno);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        bntEmprestimos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiEmprestimo guiEmprestimo = new GuiEmprestimo();
                JFrame frame = new JFrame("Lista de Professores");
                frame.setContentPane(guiEmprestimo.getjPEmprestimo);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public void abrirTela() {
        JFrame frame = new JFrame();
        GuiAtendente guiAtendente = new GuiAtendente();
        frame.setContentPane(guiAtendente.jPAtendente);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu do Bibliotecário(a):");
        frame.pack();
        frame.setVisible(true);
    }

    public void abrirTelaModal() {
        JDialog frame = new JDialog(new Frame(), true);
        GuiAtendente guiAtendente = new GuiAtendente();
        frame.setContentPane(guiAtendente.jPAtendente);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu do Bibliotecário(a):");
        frame.pack();
        frame.setVisible(true);
    }
}
