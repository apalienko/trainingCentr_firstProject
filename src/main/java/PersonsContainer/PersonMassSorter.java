package PersonsContainer;

import java.util.Comparator;

import WorkingWithPerson.IPerson;

public class PersonMassSorter {

	/**
	 * Sort mass with insertion method
	 * 
	 * @param mass - sorting mass
	 * @param comparator - sorting rule
	 */
	public static void insertionSort(IPerson[] mass, Comparator<IPerson> comparator) {
		IPerson temp;
		int size = mass.length;
		for(int i = 0; i < size - 1; i++) {
			temp = mass[i];
			for(int j = i + 1; j < size; j++) 
				if(comparator.compare(temp, mass[j]) > 0)
					temp = mass[j];
			
			mass[i] = temp;
		}
	}
		
	/**
	 * Sort mass with bubble method
	 * 
	 * @param mass - sorting mass
	 * @param comparator - sorting rule
	 */
	public static void bubbleSort(IPerson[] mass, Comparator<IPerson> comparator) {
		IPerson temp;
		int size = mass.length;
		for(int i = 0; i < size - 1; i++) {
			for(int j = 0; j < size - 1 - i; j++)
				if(comparator.compare(mass[j], mass[j + 1]) > 0) {
					temp = mass[j];
					mass[j] = mass[j + 1];
					mass[j + 1] = temp;
				}
		}
	}
	
}
