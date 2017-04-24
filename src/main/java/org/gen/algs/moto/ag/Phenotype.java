package org.gen.algs.moto.ag;

import org.gen.algs.husband.PerfectHusband;


public class Phenotype implements Comparable<Phenotype> {

  int gene;
  int value;

  // TODO - should be configurable
  static MapableToGene geneToIndividualMapper = new PerfectHusband();

  public Phenotype(int gene) {
    super();
    this.gene = gene;
    calculateValue();
  }
  
  public Phenotype(Phenotype p) {
    this.gene = p.gene;
    calculateValue();
  }

  public void crossover(Phenotype p, int k) {
    int geneA = gene;
    int geneB = p.gene;
    int maskA = ~(~0 << k);
    int maskB = ~maskA;
    gene = (geneA & maskA) + (geneB & maskB);
    p.gene = (geneB & maskA) + (geneA & maskB);

    calculateValue();
    p.calculateValue();
  }

  public void mutate(int k) {
    gene = gene ^ (1 << k);
  }

  @Override
  public String toString() {
    return "" + value;
    //return "Phenotype [" + " gene=" + String.format("%32s", Integer.toBinaryString(gene)).replace(' ', '0')
    //    + ", value=" + value + "]";
  }
  
  public String toStringAsMappedObject(){
    try {
      MapableToGene m = geneToIndividualMapper.getClass().newInstance();
      m.mapFromGene(gene);
      return m.toString();
    } catch (InstantiationException | IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return "";
  }

  @Override
  public int hashCode() {
    return gene;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Phenotype other = (Phenotype) obj;
    if (gene != other.gene)
      return false;
    return true;
  }

  @Override
  public int compareTo(Phenotype p) {
    return p.value - value;
  }

  private void calculateValue() {
    geneToIndividualMapper.mapFromGene(gene);
    value = geneToIndividualMapper.value();
  }
}
