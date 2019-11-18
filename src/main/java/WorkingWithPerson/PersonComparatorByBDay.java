package WorkingWithPerson;

import java.util.Comparator;

public class PersonComparatorByBDay implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		if(p1.getbDay().compareTo(p2.getbDay()) > 0)
			return 1;
		else if(p1.getbDay().compareTo(p2.getbDay()) == 0)
			return 0;
	
		return -1;
	}

}
