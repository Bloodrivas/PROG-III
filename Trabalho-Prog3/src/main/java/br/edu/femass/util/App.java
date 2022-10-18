package br.edu.femass.util;

import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.gui.GuiAluno;
import br.edu.femass.gui.GuiLivro;
import br.edu.femass.model.Leitor;
import br.edu.femass.model.Professor;

import java.util.List;

public class App {

    public static void main(String[] args) {
        //gerarLeitor();
      //  lerLeitor();
        //new GuiAluno().abrirTela();
        new GuiLivro().abrirTela();
    }

   // public static void lerLeitor(){
     //   Dao<Leitor> dao = new DaoLeitor();
       // try{
         //   List<Leitor> leitores = new DaoLeitor().getAll();
           // for(Leitor leitor: leitores){
             //   System.out.println(leitor);
               // for(Professor professor: leitor.getCodigo()){
                 //   System.out.println(leitor);
                  //  System.out.println(leitor.getNome());
               // }
           // }
        //} catch (Exception e) {
          //  throw new RuntimeException(e);
       // }
    //}

    private static void gerarLeitor() {
        Leitor l = new Leitor();
        l.setCodigo(Long.valueOf("123"));
        l.setNome("Alan Galante");

        try{
            new DaoProfessor().save((Professor) l);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
