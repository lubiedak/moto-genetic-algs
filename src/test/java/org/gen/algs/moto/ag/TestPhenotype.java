package org.gen.algs.moto.ag;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPhenotype {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test() {
    Phenotype a = new Phenotype(16);
    Phenotype b = new Phenotype(3);
    System.out.println("a:" + a + "\nb:" + b);
    a.crossover(b, 2);
    System.out.println("a:" + a + "\nb:" + b);
  }

}
