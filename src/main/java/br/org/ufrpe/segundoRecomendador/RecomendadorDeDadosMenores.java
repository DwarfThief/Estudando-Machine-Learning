package br.org.ufrpe.segundoRecomendador;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.IOException;
import java.util.List;

public class RecomendadorDeDadosMenores {
    public static void main(String args[]) throws IOException, TasteException {
        DataModel model = new Modelos().getDadosMenores();
        Recommender recommender = new RecomendadorBuilder().buildRecommender(model);

        List<RecommendedItem> recommendations = recommender.recommend(2,3);
        for(RecommendedItem recommendation : recommendations){
            System.out.println(recommendation);
        }
    }
}
