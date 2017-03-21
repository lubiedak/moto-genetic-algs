package org.gen.algs.moto.ag;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

public class Population { // should be generic
  Map<Phenotype, Integer> population;
  Map<Phenotype, Integer> nextGeneration;
  MapableToGene mapableToGene;

  // Temporary constants
  final int populationSize = 21; // == 7*6 / 2
  final int counterAMax = 7;
  final int counterBMax = 6;

  public Population(MapableToGene mapableToGene) {
    super();
    this.population = new HashMap<Phenotype, Integer>();
    this.nextGeneration = new HashMap<Phenotype, Integer>();
    this.mapableToGene = mapableToGene;
  }

  public void createPopulation() {
    for (int i = 0; i < populationSize; ++i) {
      int gene = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
      Phenotype p = new Phenotype(gene);
      population.put(p, getValueForPhenotype(p));
    }

    population = MapUtil.sortByValue(population);
  }

  public void nextGeneration() {
    chooseBestAndCrossOver();
    population = nextGeneration;
    population = MapUtil.sortByValue(population);
    System.out.println(population.size());
  }

  private void chooseBestAndCrossOver() {
    nextGeneration = new HashMap<Phenotype, Integer>();

    Iterator<Entry<Phenotype, Integer>> itA = population.entrySet().iterator();

    int counterA = 0;

    while (itA.hasNext() && counterA < counterAMax) {
      ++counterA;
      Map.Entry<Phenotype, Integer> pairA = (Map.Entry<Phenotype, Integer>) itA.next();
      Phenotype pA = pairA.getKey();

      Iterator<Entry<Phenotype, Integer>> itB = population.entrySet().iterator();
      int counterB = 0;
      for (int i = 0; i < counterA; ++i) {
        itB.next(); // skip few firt ones
        ++counterB;
      }

      while (itB.hasNext() && counterB < counterBMax) {
        ++counterB;
        Map.Entry<Phenotype, Integer> pairB = (Map.Entry<Phenotype, Integer>) itB.next();
        Phenotype pB = pairB.getKey();
        pA.crossover(pB, ThreadLocalRandom.current().nextInt(0, 32));
        nextGeneration.put(pA, getValueForPhenotype(pA));
        nextGeneration.put(pB, getValueForPhenotype(pB));

      }

    }

  }

  private int getValueForPhenotype(Phenotype p) {
    MapableToGene gene = null;
    try {
      gene = mapableToGene.getClass().newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    gene.mapFromGene(p.gene);

    return gene.value();
  }

  @Override
  public String toString() {
    return "Population [population=" + population + "]";
  }

  public String mapToMoto() {
    String s = "";
    Iterator<Entry<Phenotype, Integer>> it = population.entrySet().iterator();

    while (it.hasNext()) {
      MapableToGene gene = null;
      try {
        gene = mapableToGene.getClass().newInstance();
      } catch (InstantiationException | IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      gene.mapFromGene(it.next().getKey().gene);
      s += gene + "\n";
    }
    return s;
  }

}
