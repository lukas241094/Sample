package org.gradle;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import imperative.ClosestDistanceCalculatorImp;

import static org.gradle.Region.*;
public class Main {

	public static void main(String[] args) {

		List<Molecule> molecules;
		Molecule core = new Molecule(0);
		double qmThreshold = 2.0;
		double bufferThreshold = 5.0;

		molecules = 
		IntStream.range(0,5_000_000)
				 .parallel()
				 .mapToObj(i -> new Molecule(i))
				 .collect(Collectors.toList());

		MethodStarter starter = new MethodStarter();
		

		starter.calculateStreamParallelFunctionalCDC(molecules, qmThreshold, bufferThreshold,core);

		starter.calculateImperative(molecules, qmThreshold, bufferThreshold,core);

		starter.calculateStreamPrallelImpCDC(molecules, qmThreshold, bufferThreshold,core);

		starter.calculateStreamSerial(molecules, qmThreshold, bufferThreshold,core);

	}
}
		

	

	

