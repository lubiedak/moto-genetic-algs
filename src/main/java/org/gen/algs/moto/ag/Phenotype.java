package org.gen.algs.moto.ag;

public class Phenotype {
  //int chromosomeSize;
  //int nOfChromosomes;

  int gene;

  
  
  public Phenotype(int gene) {
    super();
    this.gene = gene;
  }

  public void crossover(Phenotype p, int k) {
    int geneA = gene;
    int geneB = p.gene;
    int maskA = ~(~0 << k);
    int maskB = (~0 << k);
    gene = (geneA & maskA) + (geneB & maskB);
    p.gene = (geneB & maskA) + (geneA & maskB);

  }

  public void mutate(Phenotype p, int k) {

  }

  @Override
  public String toString() {
    return "Phenotype [gene=" + String.format("%8s", Integer.toBinaryString(gene)).replace(' ', '0') + "]";
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
  
  
}
