package org.gen.algs.moto;

import java.util.ArrayList;
import java.util.List;

import org.gen.algs.moto.ag.MapableToGene;

public class PerfectHusband implements MapableToGene{

	List<HusbandAttribute> attributes;
	
	public PerfectHusband(){
		attributes = new ArrayList<>();
		attributes.add(new HusbandAttribute("earnings", 0, 14));
		attributes.add(new HusbandAttribute("iq", 0, 7));
		attributes.add(new HusbandAttribute("emotional intelligence", 0, 7));
		attributes.add(new HusbandAttribute("addictons", 0, 2));
		attributes.add(new HusbandAttribute("attractive", 0, 1));
		attributes.add(new HusbandAttribute("having a motorocycle", 0, 1));
	}
	
	@Override
	public int mapToGene() {
		int gene = 0;
		int bitsShift = 0;
		for(HusbandAttribute attr : attributes){
			int maxValue = (int)Math.pow(2.0, attr.getnOfBits())-1;
			gene += (attr.getValue() > maxValue ? maxValue : attr.getValue()) << bitsShift;
			bitsShift = attr.getnOfBits();
		}
		return gene;
	}

	@Override
	public void mapFromGene(int gene) {
		int bitsShift = 0;
		for(HusbandAttribute attr : attributes){
			int mask = ((int)Math.pow(2.0, attr.getnOfBits())-1) << bitsShift;
			attr.setValue(mask&gene >> bitsShift);
			bitsShift += attr.getnOfBits();
			
		}
	}

	@Override
	public int value() {
		int value = 0;
		
		int earnings = getValueByAttributeName("earnings");
		value += earnings < 1000 ? -100 : (int)Math.sqrt(earnings);
		value += getValueByAttributeName("iq")-95;
		value += getValueByAttributeName("emotionl intelligence")-95;
		value -= Math.pow(getValueByAttributeName("addictions") * 2.0, 3);
		value += getValueByAttributeName("attractive")*30;
		value += getValueByAttributeName("having a motorocycle")*50;

		
		return value;
	}
	
	private int getValueByAttributeName(String name){
		return attributes.stream().filter( a -> a.getName().equals(name) ).findFirst().get().getValue();
	}

}
