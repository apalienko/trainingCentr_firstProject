package PersonsContainer;

import WorkingWithPerson.Person;

public class PersonDynamicMass implements DynamicMass<Person> {

	/** Поле переменная основного массива */
	private Person[] mass;
	
	private int size;
	
	final int START_SIZE = 2;
	
	/**
	 * Конструктор - создает объект с заданным начальным
	 * размером массива и выставляет значение <b>size</b>
	 * равным нулю
	 * 
	 * @param startSize - начальный размер массива
	 */
	public PersonDynamicMass() {
		mass = new Person[START_SIZE];
		for(int i = 0; i < START_SIZE; i++)
			mass[i] = null;
		size = 0;
	}
	
	@Override
	public void push(Person elem) {
		
		if(size == mass.length) {
			Person[] temp = new Person[mass.length * 2];
			for(int i = 0; i < mass.length; i++)
				temp[i] = mass[i];
			mass = temp;
		}
		
		boolean Ok = false;
		int i = 0;
		while(!Ok && i < mass.length) {
			Ok = mass[i] == null;
			if(Ok) {
				mass[i] = elem;
				size++;
			}
			else
				i++;
		}	
	}

	@Override
	public void put(Person elem, int index) {
		if(index < 0 || index > mass.length)
			throw(new IndexOutOfBoundsException());
		mass[index] = elem;
		size++;
	}

	@Override
	public Person get(int index) throws IndexOutOfBoundsException, NullPointerException {
		if(index < 0 || index > mass.length)
			throw(new IndexOutOfBoundsException());
		if(mass[index] == null)
			throw(new NullPointerException());
		return mass[index];
	}

	@Override
	public int indexOf(Person elem) {		
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
	public void delete(int index) {
		if(index < 0 || index > mass.length)
			throw(new IndexOutOfBoundsException());
		mass[index] = null;
		size--;
		
		// Размер уменьшенного массива
		int newSize = mass.length / 2;
		
		if(size <= newSize && newSize >= START_SIZE) {
			int i = newSize;
			boolean noElemInSecondPart = true;
			while(noElemInSecondPart && i < mass.length) {
				noElemInSecondPart = mass[i] == null;
				i++;
			}		
			
			if(noElemInSecondPart) {
				// Итерационная переменная для нового уменьшенного массива
				int j = 0;
				
				Person[] temp = new Person[newSize];
				for(i = 0; i < mass.length; i++)
					if(mass[i] != null) {
						temp[j] = mass[i];
						j++;
					}
				mass = temp;
			}	
		}
		
	}
	
	@Override
	public int curSize() {
		return size;
	}

	@Override
	public int length() {
		return mass.length;
	}
	
}
