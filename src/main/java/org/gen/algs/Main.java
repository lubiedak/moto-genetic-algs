package org.gen.algs;

import org.gen.algs.husband.PerfectHusband;
import org.gen.algs.moto.ag.Population;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Population p = new Population(new PerfectHusband());
    p.createPopulation();
    for (int i = 0; i < 5; ++i) {
      System.out.println(i + ": " + p);
      System.out.println("Worst: " + p.getWorst().toStringAsMappedObject());
      p.nextGeneration();
    }

    System.out.println("Best:" + p.getBest().toStringAsMappedObject());
  }

}
