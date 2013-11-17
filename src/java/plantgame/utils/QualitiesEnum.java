/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.utils;

/**
 *
 * @author tyler
 */
public enum QualitiesEnum {
  GROWING(-1,-1,0.0,"Growing"),
  ROTTEN(0,0,0.0,"Rotten"),
  POOR(1,1,0.1,"Poor"),
  FAIR(2,2,0.3,"Fair"),
  GOOD(4,4,0.6,"Good"),
  SUPER(8,8,1.0,"Super");
  
  private final int minWaterings;
  private final int minFertilizers;
  private final double priceCoefficient;
  private final String name;
  
  QualitiesEnum(int water, int fert, double cost, String newName){
    minWaterings = water;
    minFertilizers = fert;
    priceCoefficient = cost;
    name = newName;
  }
  
  public int getMinWaterings(){
    return minWaterings;
  }
  
  public int getMinFertilizers(){
    return minFertilizers;
  }
  
  public double getPriceCoefficient(){
    return priceCoefficient;
  }
  
  public String getName(){
    return name;
  }
  
  //This method will return a quality for a given number of waterings and
  //fertilizerings
  public static QualitiesEnum getQuality(int waterings, int fertilizers){
    
    QualitiesEnum qtemp = QualitiesEnum.ROTTEN;
    
    for (QualitiesEnum q : QualitiesEnum.values()){
      if (qtemp.minFertilizers < q.minFertilizers && 
              qtemp.minWaterings < q.minWaterings &&
              waterings > q.minWaterings &&
              fertilizers > q.minFertilizers){
        qtemp = q;
      }     
    }
    
    return qtemp;
    
  } 
}
