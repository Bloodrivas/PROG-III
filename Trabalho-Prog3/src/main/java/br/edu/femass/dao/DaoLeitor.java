package br.edu.femass.dao;

import br.edu.femass.model.Leitor;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoLeitor extends Persistencia<Leitor> implements Dao<Leitor> {
    private final static String NOMEARQUIVO = "leitores.json";
    private static List<Leitor> leitores = new ArrayList<Leitor>();

    public void save(Leitor leitor) throws Exception{
        List<Leitor> leitores = getAll();
        leitores.add(leitor);
        String json = getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(leitores);
        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    public List<Leitor> getAll() throws Exception{
        try{
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Leitor> leitores = getObjectMapper().readValue(json, new TypeReference<List<Leitor>>(){});
            Leitor.atualizarProximoNumero(leitores);
            return leitores;
        }catch (FileNotFoundException f){
            return new ArrayList();
        }catch (Exception e){
            throw e;
        }
    }

}