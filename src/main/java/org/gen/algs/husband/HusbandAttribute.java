package org.gen.algs.husband;

public class HusbandAttribute {
  String name;
  int value;
  int nOfBits;

  public HusbandAttribute(String name, int value, int nOfBits) {
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

  @Override
  public String toString() {
    return "HA [" + name + ", " + value + "]";
  }

}
