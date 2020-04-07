package PersonsContainer;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import WorkingWithPerson.*;
import ru.apache_maven.App;

@XmlRootElement(name = "PersonDynamicMass")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonDynamicMass implements IPersonRepository{

	@XmlTransient
	final Logger LOG = Logger.getLogger(App.class.getName());
	
	/** Main array of persons */
	@XmlElement(name="person")
	private IPerson[] mass;
	
	@XmlElement(required=true)
	private int size;
	
	final int START_SIZE = 2;
	
	/**
	 * Creates empty persons array
	 * 
	 * @param startSize - size of initial array
	 */
	public PersonDynamicMass() {
		mass = new IPerson[START_SIZE];
		for(int i = 0; i < START_SIZE; i++)
			mass[i] = null;
		size = 0;
	}
	
	@Override
	public void add(IPerson person) {
		
		if(size == mass.length) {
			IPerson[] temp = new IPerson[mass.length * 2];
			for(int i = 0; i < mass.length; i++)
				temp[i] = mass[i];
			mass = temp;
		}
		
		boolean Ok = false;
		int i = 0;
		while(!Ok && i < mass.length) {
			Ok = mass[i] == null;
			if(Ok) {
				mass[i] = person;
				size++;

				LOG.log(Level.INFO, person.toString() + " added to dynamic array");
			}
			else
				i++;
		}	
	}

	@Override
	public void add(int index, IPerson person){
		if(index < 0 || index > mass.length)
			throw(new IndexOutOfBoundsException());
		mass[index] = person;
		size++;
		
		LOG.log(Level.INFO, person.toString() + " added to dynamic array");
	}

	@Override
	public IPerson get(int index) throws IndexOutOfBoundsException, NullPointerException {
		if(index < 0 || index > mass.length)
			throw(new IndexOutOfBoundsException());
		if(mass[index] == null)
			throw(new NullPointerException());
		return mass[index];
	}

	/**
	 * give index of an element
	 * 
	 * @param elem - object which index we are tryiing to find
	 * @return -1 if object wasn't found, index of that object in array otherwise
	 */
	public int indexOf(IPerson elem) {		
		int i = 0;
		boolean found;
		do{
			found = mass[i].equals(elem);
			i++;
		} while(!found && i < mass.length);
			
		if(found) {
			LOG.log(Level.INFO, elem.toString() + " found at dynamic array at " + (i--) + " position");
			return i--;
		}
		LOG.log(Level.INFO, elem.toString() + " wasn't found at dynamic array");
		return -1;
	}

	@Override
	public IPerson delete(int index) {
		if(index < 0 || index > mass.length)
			throw(new IndexOutOfBoundsException());
		IPerson res = mass[index];
		mass[index] = null;
		size--;
		
		int newSize = mass.length / 2;
		
		if(size <= newSize && newSize >= START_SIZE) {
			int i = newSize;
			boolean noElemInSecondPart = true;
			while(noElemInSecondPart && i < mass.length) {
				noElemInSecondPart = mass[i] == null;
				i++;
			}		
			
			if(noElemInSecondPart) {
				int j = 0;
				
				IPerson[] temp = new IPerson[newSize];
				for(i = 0; i < mass.length; i++)
					if(mass[i] != null) {
						temp[j] = mass[i];
						j++;
					}
				mass = temp;
			}	
		}
		
		LOG.log(Level.INFO, res.toString() + " was deleted");
		return res;
	}
	
	public int curSize() {
		return size;
	}

	public int length() {
		return mass.length;
	}

	@Override
	public void sortBy(Comparator<IPerson> comparator) {
		
		PersonMassSorter.insertionSort(mass, comparator);
	}

	@Override
	public IPerson set(int index, IPerson person) {
		if(index < 0 || index > mass.length)
			throw(new IndexOutOfBoundsException());
		IPerson temp = mass[index];
		mass[index] = person;
		size++;
		
		return temp;
	}

	@Override
	public List<IPerson> toList() {
		ArrayList<IPerson> res = new ArrayList<IPerson>(Arrays.asList(mass)); 
		
		return res;
	}


	@Override
	public IPersonRepository searchBy(Predicate<IPerson> condition) {
		
		PersonDynamicMass res = new PersonDynamicMass();
		
		for(int i = 0; i < size; i++) {
			if(condition.test(mass[i]))
				res.add(mass[i]);
		}
		
		return res;
	}
}
