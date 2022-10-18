package br.edu.femass.dao;

import br.edu.femass.model.Leitor;
import br.edu.femass.model.Livro;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoLivro extends Persistencia<Livro> implements Dao<Livro> {
    private final static String NOMEARQUIVO = "livros.json";
    public static List<Livro> livros = new ArrayList<Livro>();

    public void save(Livro livro) throws Exception{
        List<Livro> livros = getAll();
        livros.add(livro);
        String json = getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(livros);
        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    public List<Livro> getAll() throws Exception{
        try{
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Livro> livros = getObjectMapper().readValue(json, new TypeReference<List<Livro>>(){});
            return livros;
        }catch (FileNotFoundException f){
            return new ArrayList();
        }catch (Exception e){
            throw e;
        }
    }
}