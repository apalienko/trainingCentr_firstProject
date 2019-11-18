package WorkingWithPerson;

import java.util.Comparator;

public class PersonComparatorByFIO implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		if(p1.getFIO().compareTo(p2.getFIO()) > 0)
			return 1;
		else if(p1.getFIO().compareTo(p2.getFIO()) == 0)
			return 0;
		
		return -1;
	}
	
}
