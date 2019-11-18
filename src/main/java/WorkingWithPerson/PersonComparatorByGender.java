package WorkingWithPerson;

import java.util.Comparator;

public class PersonComparatorByGender implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		if(p1.getGender().compareTo(p2.getGender()) > 0)
			return 1;
		else if(p1.getGender().compareTo(p2.getGender()) == 0)
			return 0;
		
		return -1;
	}
	
}
