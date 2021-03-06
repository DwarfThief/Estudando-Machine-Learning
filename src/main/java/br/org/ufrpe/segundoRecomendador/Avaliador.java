package br.org.ufrpe.segundoRecomendador;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;

import java.io.IOException;

public class Avaliador {
    public static void main(String Args[]) throws IOException, TasteException {
        //Usa sempre o mesmo grupo para teste, assim não teremos erro na margem.
        RandomUtils.useTestSeed();

//      Usa os dados menores para avaliar a margem de erro.
//      DataModel model = new Modelos().getDadosMenores();

//      Usa os dados maiores para avaliar a margem de erro.
//      DataModel model = new Modelos().getDadosMaiores();

//      Usa os dados quem possuem dados que coletaram 3 perguntas, elas foram descritas apenas como 0 ou 1 (Sim ou Não).
        DataModel model = new Modelos().getDadosComPergunta();

        RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
        RecommenderBuilder builder = new RecomendadorBuilder();
        double margemDeErro = evaluator.evaluate(builder,null,model,0.9, 1.0);
        System.out.println(margemDeErro);
    }
}
