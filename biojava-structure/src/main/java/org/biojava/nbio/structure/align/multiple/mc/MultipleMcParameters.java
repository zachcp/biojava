package org.biojava.nbio.structure.align.multiple.mc;

import java.util.ArrayList;
import java.util.List;

import org.biojava.nbio.structure.align.ce.ConfigStrucAligParams;

/** 
 * Contains the parameters to be sent to the MC optimization.
 * 
 * @author Aleix Lafita
 * @since 4.1.0
 *
 */
public class MultipleMcParameters implements ConfigStrucAligParams {
	
	private int randomSeed;
	private int minBlockLen;
	private int minAlignedStructures;
	private double gapOpen;
	private double gapExtension;
	private int convergenceSteps;
	
	/**
	 * Constructor with DEFAULT values of the parameters.
	 */
	public MultipleMcParameters(){
		reset();
	}

	@Override
	public List<String> getUserConfigParameters() {
		
		List<String> params = new ArrayList<String>();
		params.add("RandomSeed");
		params.add("MinBlockLen");
		params.add("MinAlignedStructures");
		params.add("GapOpen");
		params.add("GapExtension");
		params.add("ConvergenceSteps");

		return params;
	}

	@Override
	public List<String> getUserConfigParameterNames() {
		
		List<String> params = new ArrayList<String>();
		params.add("Random Seed");
		params.add("Minimum Block Length");
		params.add("Minimum Structures per Column");
		params.add("Gap Opening Penalty");
		params.add("Gap Extension Penalty");
		params.add("Steps to Convergence");
		
		return params;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List<Class> getUserConfigTypes() {
		
		List<Class> params = new ArrayList<Class>();
		params.add(Integer.class);
		params.add(Integer.class);
		params.add(Integer.class);
		params.add(Double.class);
		params.add(Double.class);
		params.add(Integer.class);
		
		return params;
	}

	@Override
	public List<String> getUserConfigHelp() {
		
		List<String> params =new ArrayList<String>();
		String randomSeed = 
				"Random seed for the optimizer random number generator.";
		String minBlockLen = 
				"Minimum number of aligned positions in a Block of the "
				+ "Multiple Alignment.";
		String minAlignedStructures = 
				"Minimum number of structures aligned in a column (without "
				+ "gaps). If it is 0 the minimum is calculated as a third of "
				+ "the total number of structures.";
		String gapOpen = "Penalty for opening a gap in any of the structures.";
		String gapExtension = "Penalty for extending a gapped region in any of"
				+ " the structures.";
		String convergenceSteps = 
				"Number of steps without a change in the alignment before "
				+ "stopping. Proportional to the calculation time. "
				+"If it is 0 the convergence steps are calculated proportional"
				+ " to the number of structures and their length.";
		
		params.add(randomSeed);
		params.add(minBlockLen);
		params.add(minAlignedStructures);
		params.add(gapOpen);
		params.add(gapExtension);
		params.add(convergenceSteps);
		
		return params;
	}

	@Override
	public String toString() {
		return "MultipleMcParameters [randomSeed=" + randomSeed
				+ ", minBlockLen=" + minBlockLen + ", minAlignedStructures="
				+ minAlignedStructures + ", gapOpen=" + gapOpen
				+ ", gapExtension=" + gapExtension + ", convergenceSteps="
				+ convergenceSteps + "]";
	}

	@Override
	public void reset() {
		
		randomSeed = 0;
		minBlockLen = 15;
		minAlignedStructures = 0;
		gapOpen = 10.0;
		gapExtension = 5.0;
		convergenceSteps = 0;
	}

	public int getRandomSeed() {
		return randomSeed;
	}

	public void setRandomSeed(Integer randomSeed) {
		this.randomSeed = randomSeed;
	}

	public int getMinBlockLen() {
		return minBlockLen;
	}

	public void setMinBlockLen(Integer minBlockLen) {
		this.minBlockLen = minBlockLen;
	}

	public int getMinAlignedStructures() {
		return minAlignedStructures;
	}

	public void setMinAlignedStructures(Integer minAlignedStructures) {
		this.minAlignedStructures = minAlignedStructures;
	}

	public double getGapOpen() {
		return gapOpen;
	}

	public void setGapOpen(Double gapOpen) {
		this.gapOpen = gapOpen;
	}

	public double getGapExtension() {
		return gapExtension;
	}

	public void setGapExtension(Double gapExtension) {
		this.gapExtension = gapExtension;
	}

	public int getConvergenceSteps() {
		return convergenceSteps;
	}

	public void setConvergenceSteps(Integer convergenceSteps) {
		this.convergenceSteps = convergenceSteps;
	}	
}
