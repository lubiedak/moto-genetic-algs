package org.gen.algs.moto;

public class HusbandAttribute {
  String name;
  int value;
  
  int nOfBits;
  
  
  
  public HusbandAttribute(String name, int value, int nOfBits) {
    super();
    this.name = name;
    this.value = value;
    this.nOfBits = nOfBits;
  }
  
  public void setValue(int value) {
    this.value = value;
  }

  public String getName() {
    return name;
  }
  public int getValue() {
    return value;
  }
  public int getnOfBits() {
    return nOfBits;
  }
  
  
}
