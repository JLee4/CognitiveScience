package Schemas; 

public class Recommendation {

    public enum Recommended_By {
      FAMILY, 
      FRIEND,
      ONLINE
    }
    
    private Recommended_By recommender;
    
    public Recommendation(Recommended_By recommender) {
      this.Recommended_By = recommender;
    }
    
    public String getRecommender() {
      return recommender;
    }
    
    public void setRecommender(Recommended_By recommender) {
      this.recommender = recommender;
    }
}
