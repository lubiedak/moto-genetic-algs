package org.gen.algs.moto.ag;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Population { // should be generic
  List<Phenotype> population;
  List<Phenotype> nextGeneration;
  MapableToGene mapableToGene;

  // Temporary constants TODO: Should be configurable
  final int populationSize = 20; // == 7*6 / 2
  final int counterMax = 5;
  
  
  private Random randomGenerator;

  public Population(MapableToGene mapableToGene) {
    super();
    this.population = new LinkedList<Phenotype>();
    this.nextGeneration = new LinkedList<Phenotype>();
    this.mapableToGene = mapableToGene;
    
    randomGenerator = new Random();
  }

  public void createPopulation() {
    for (int i = 0; i < populationSize; ++i) {
      int gene = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
      Phenotype p = new Phenotype(gene);
      population.add(p);
    }

    Collections.sort(population);
  }
  
  public Phenotype getBest(){
    return population.get(0);
  }
  
  public Phenotype getWorst(){
    return population.get(populationSize-1);
  }

  public void nextGeneration() {
    chooseBestAndCrossOver();
    population = nextGeneration;
    Collections.sort(population);
  }

  private void chooseBestAndCrossOver() {
    nextGeneration = new LinkedList<Phenotype>();
    for(int i = 0; i < counterMax-1; ++i){
      Phenotype phenotypeA = new Phenotype(population.get(i));
      
      for(int j = i+1; j < counterMax; ++j){
        Phenotype phenotypeB = new Phenotype(population.get(j));
        
        phenotypeA.crossover(phenotypeB, ThreadLocalRandom.current().nextInt(1, 31));
        //phenotypeA.crossover(phenotypeB, findBetterCrossoverPoint());
        mutate(phenotypeA);
        nextGeneration.add(phenotypeA);
        nextGeneration.add(phenotypeB);
      }
    }
  }
  
  private void mutate(Phenotype p){
    float mutationLevel = 0.05f;
    if(randomGenerator.nextFloat() < mutationLevel){
      p.mutate(randomGenerator.nextInt(32));
    }
  }
  
  private int findBetterCrossoverPoint(){
    List<Integer> bestPlaceToCrossover = mapableToGene.bestPlacesToCrossover();
    int index = randomGenerator.nextInt(bestPlaceToCrossover.size());
    Integer item = bestPlaceToCrossover.get(index);
    return item;
  }

  @Override
  public String toString() {
    return "Population [population=" + population + "]";
  }

}
