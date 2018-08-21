package br.org.ufrpe.segundoRecomendador;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class RecomendadorBuilder implements RecommenderBuilder {
    @Override
    public Recommender buildRecommender(DataModel model) throws TasteException{
        //Função de similaridade
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        //Função para pegar a vizinhaça
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
        //Função de recomendação
        UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        return recommender;
    }
}
