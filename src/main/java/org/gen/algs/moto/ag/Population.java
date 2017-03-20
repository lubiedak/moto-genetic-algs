package org.gen.algs.moto.ag;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Population { //should be generic
  List<Phenotype> population;
  MapableToGene mapableToGene;
  
  
  
  public void createPopulation(int n){
    for(int i = 0; i <n; ++i){
      int gene = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE+1);
      population.add(new Phenotype(gene));
    }
  }
  
  public void nextGeneration(){
    
  }
}
