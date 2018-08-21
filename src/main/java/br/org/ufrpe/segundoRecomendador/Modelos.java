package br.org.ufrpe.segundoRecomendador;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

import java.io.File;
import java.io.IOException;

public class Modelos {
    public DataModel getDadosMenores() throws IOException {
        return model("/src/main/resources/dados.csv");
    }
    public DataModel getDadosMaiores() throws IOException{
        return  model("/src/main/resources/dadosMaiores.csv");
    }
    public DataModel getDadosComPergunta() throws IOException{
        return model("/src/main/resources/dadosComPergunta.csv");
    }
    private DataModel model(String path) throws IOException {
        File file = new File(path);
        return  new FileDataModel(file);
    }
}
