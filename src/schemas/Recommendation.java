package schemas;

public class Recommendation {

    public enum RecommendedBy {
      FAMILY, 
      FRIEND,
      ONLINE
    }
    
    private RecommendedBy recommender;
    
    public Recommendation(RecommendedBy recommender) {
      this.recommender = recommender;
    }
    
    public RecommendedBy getRecommender() {
      return recommender;
    }
    
    public void setRecommender(RecommendedBy recommender) {
      this.recommender = recommender;
    }
}
