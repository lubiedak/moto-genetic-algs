package org.gen.algs;

import org.gen.algs.husband.PerfectHusband;
import org.gen.algs.moto.Moto;
import org.gen.algs.moto.ag.Population;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Population p = new Population(new PerfectHusband());
    p.createPopulation();
    System.out.println("0:" + p);
    System.out.println("Worst:" + p.getWorst().toStringAsMappedObject());
    
    p.nextGeneration();
    System.out.println("\n1:" + p);
    System.out.println("Worst:" + p.getWorst().toStringAsMappedObject());
    
    p.nextGeneration();
    System.out.println("\n2:" + p);
    System.out.println("Worst:" + p.getWorst().toStringAsMappedObject());
    p.nextGeneration();
    System.out.println("\n3:" + p);
    System.out.println("Worst:" + p.getWorst().toStringAsMappedObject());
    p.nextGeneration();
    System.out.println("\n4:" + p);

    
    System.out.println("Best:" + p.getBest().toStringAsMappedObject());
  }

}