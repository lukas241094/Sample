package org.gradle

import spock.lang.Specification;

class ClosestDistanceCalculatorSpecc extends Specification{
	
	
	def "testClosestDistanceCalculator"(){
		
		def  closestDistanceCalculator = new ClosestDistanceCalculator()
		def distanceCalculator = new DistanceCalculator()
		closestDistanceCalculator.calculator = distanceCalculator
		

		def core = Mock(MoleculeInterface)
		def a1 = Mock(AtomInterface)
		a1.getX() >> 0
		a1.getY() >> 0
		a1.getZ() >> 0
		
		def molecule = Mock(MoleculeInterface)
		
		def a2 = Mock(AtomInterface)
		def a3 = Mock(AtomInterface)
		a2.getX() >> 1
		a2.getY() >> 1
		a2.getZ() >> 1
		
		a3.getX() >> 1
		a3.getY() >> 2
		a3.getZ() >> 2
		
		core.getAtoms() >> [a1]
		molecule.getAtoms() >> [a2,a3]
		
		when:
		
		double distance = closestDistanceCalculator.calculateClosestDistance(core,molecule)
		println(distance)
		
		
		then:
		distance == 3
	}

}
