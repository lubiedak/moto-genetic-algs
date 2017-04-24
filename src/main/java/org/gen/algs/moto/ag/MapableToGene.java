package org.gen.algs.moto.ag;

import java.util.List;

public interface MapableToGene {
  int mapToGene();
  void mapFromGene(int gene);
  int value();
  
  
  List<Integer> bestPlacesToCrossover(); 
  
}
