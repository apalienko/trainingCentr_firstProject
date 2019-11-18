package PersonsContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import WorkingWithPerson.*;

public class PersonDynamicMass implements IRepository{

	/** ���� ���������� ��������� ������� */
	private IPerson[] mass;
	
	private int size;
	
	final int START_SIZE = 2;
	
	/**
	 * ����������� - ������� ������ � �������� ���������
	 * �������� ������� � ���������� �������� <b>size</b>
	 * ������ ����
	 * 
	 * @param startSize - ��������� ������ �������
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
	}

	@Override
	public IPerson get(int index) throws IndexOutOfBoundsException, NullPointerException {
		if(index < 0 || index > mass.length)
			throw(new IndexOutOfBoundsException());
		if(mass[index] == null)
			throw(new NullPointerException());
		return mass[index];
	}

	public int indexOf(IPerson elem) {		
		int i = 0;
		boolean found;
		do{
			found = mass[i].equals(elem);
			i++;
		} while(!found && i < mass.length);
			
		if(found) {
			return i--;
		}
		return -1;
	}

	@Override
	public IPerson delete(int index) {
		if(index < 0 || index > mass.length)
			throw(new IndexOutOfBoundsException());
		IPerson res = mass[index];
		mass[index] = null;
		size--;
		
		// ������ ������������ �������
		int newSize = mass.length / 2;
		
		if(size <= newSize && newSize >= START_SIZE) {
			int i = newSize;
			boolean noElemInSecondPart = true;
			while(noElemInSecondPart && i < mass.length) {
				noElemInSecondPart = mass[i] == null;
				i++;
			}		
			
			if(noElemInSecondPart) {
				// ������������ ���������� ��� ������ ������������ �������
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
		
		return res;
	}
	
	public int curSize() {
		return size;
	}

	public int length() {
		return mass.length;
	}

	/**
	 * ���������� ���������
	 */
	@Override
	public void sortBy(Comparator<IPerson> comparator) {
		IPerson temp;
		
		for(int i = 0; i < size - 1; i++) {
			temp = mass[i];
			for(int j = i + 1; j < size; j++) 
				if(comparator.compare(temp, mass[j]) > 0)
					temp = mass[j];
			
			mass[i] = temp;
		}
	}
	
	/**
	 * ���������� "���������"
	 * 
	 * @param comparator - ���������� ��� ��������� �������� IPerson
	 */
	public void bubbleSort(Comparator<IPerson> comparator) {
		IPerson temp;
		
		for(int i = 0; i < size - 1; i++) {
			for(int j = 0; j < size - 1 - i; j++)
				if(comparator.compare(mass[j], mass[j + 1]) > 0) {
					temp = mass[j];
					mass[j] = mass[j + 1];
					mass[j + 1] = temp;
				}
		}
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
	public IRepository searchBy(Predicate<IPerson> condition) {
		
		PersonDynamicMass res = new PersonDynamicMass();
		
		for(int i = 0; i < size; i++) {
			if(condition.test(mass[i]))
				res.add(mass[i]);
		}
		
		return res;
	}
}
