package org.gen.algs.moto;

import org.gen.algs.moto.ag.GeneMapper;

public class Moto implements GeneMapper{
  
  int power;
  int ccm;
  int price;
  int weight;
  int gasUsage;
  int equipmentQuality;
  boolean canMyWifeUseIt;
  boolean doesMyWifeLikeItsDesign;
  
  
  
  public Moto(int power, int ccm, int price, int weight, int gasUsage, int equipmentQuality,
      boolean doesMyWifeLikeItsDesign) {
    super();
    this.power = power;
    this.ccm = ccm;
    this.price = price;
    this.weight = weight;
    this.gasUsage = gasUsage;
    this.equipmentQuality = equipmentQuality;
    this.canMyWifeUseIt  = ccm <= 125;
    this.doesMyWifeLikeItsDesign = doesMyWifeLikeItsDesign;
  }

  @Override
  public int mapToGene() {
    // 8 fields, so every information needs to be normalized into 4 bits
    int gene = power > 100 ? 15 : 15*power/100;        //max acceptable power is 100;
    gene += (ccm > 1000 ? 15 : 15*ccm/1000)<<4;        //max acceptable ccm is 1000;
    gene += (price > 40000 ? 15 : 15*price/40000)<<8;  //max acceptable price is 40000;
    gene += (weight > 220 ? 15 : 15*weight/220)<<12;   //max acceptable weight is 220;
    gene += (gasUsage > 10 ? 15 : 15*gasUsage/10)<<16; //max acceptable gasUsage is 10;
    gene += (equipmentQuality > 15 ? 15 : equipmentQuality)<<20; //max acceptable equipmentQuality is 15;
    gene += (canMyWifeUseIt ? 15 : 0)<<24; //max acceptable gasUsage is 10;
    gene += (doesMyWifeLikeItsDesign ? 15 : 0)<<28; //max acceptable gasUsage is 10;
    
    return gene;
  }
  
  @Override
  public void mapFromGene(int gene) {
    int mask = 15;
    power = (gene & mask) * 100;
    ccm = ((gene & mask<<4) >> 4) * 1000;
    price = ((gene & mask<<8) >> 8) * 40000;
    weight = ((gene & mask<<12) >> 12) * 220;
    gasUsage = ((gene & mask<<16) >> 16) * 10;
    equipmentQuality = ((gene & mask<<20) >> 20) * 15;
    canMyWifeUseIt = ((gene & mask<<24) >> 24) == 15;
    doesMyWifeLikeItsDesign = ((gene & mask<<28) >> 28) == 15;
    
  }
  @Override
  public int value(int gene) {
    return power/4 + ccm/10 - price/1000 - weight/10 - gasUsage + equipmentQuality/2 + (canMyWifeUseIt?5:0) + (canMyWifeUseIt?3:0);    
  }
  
  
}
