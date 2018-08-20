package br.org.ufrpe;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class RecomendadorMain {
    public static void main(String args[]) throws IOException, TasteException {
        File file = new File("dados.csv");
        DataModel model = new FileDataModel(file);
        //Função de Similaridade
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        //Função de Proximidade
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
        //Criando um recomendador
        UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

        List<RecommendedItem> recommendations = recommender.recommend(3,3);
        for(RecommendedItem recommendation : recommendations){
            System.out.println(recommendation);
        }
    }
}
