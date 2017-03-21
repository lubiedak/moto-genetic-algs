package org.gen.algs.moto;

import org.gen.algs.moto.ag.Population;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Population p = new Population(new Moto());
    p.createPopulation();
    p.nextGeneration();
    System.out.println("1:" + p);
    
    p.nextGeneration();
    System.out.println("2:" + p);
    
    p.nextGeneration();
    System.out.println("3:" + p);
    
    p.nextGeneration();
    System.out.println("4:" + p);
    
    p.nextGeneration();
    System.out.println("5:" + p);
    
    System.out.println(p.mapToMoto());
  }

}
