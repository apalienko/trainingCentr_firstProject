package WorkingWithPerson;

import org.joda.time.LocalDate;


/**
 * Класс человека.
 * 
 * @author Aleksey
*/

public class Person {

	/** Поле Фамилия Имя и Отчество человека */
	private String FIO;
	
	/** Поле Дата рождения */
	private LocalDate bDay;
	
	/** Поле Пол человека */
	private String gender;
	
	/**
	 * Конструктор - создание нового объекта с определенными значениями
	 * 
	 * @param aFIO - фамилия, Имя и Отчество
	 * @param aBDay - дата рождения
	 * @param aGender - пол человека
	 */
	public Person(String aFIO, LocalDate aBDay, String aGender) {
		
		FIO = aFIO;
		bDay = aBDay;
		gender = aGender;
		
	}
	
	public int getAge() {
		LocalDate res = LocalDate.now().minusDays(bDay.getDayOfMonth());
		res.minusMonths(bDay.getMonthOfYear());
		res.minusYears(bDay.getYear());
		return res.getYear();
	}
	
	@Override
	  public String toString() {
	      return "[FIO=" + this.FIO + ", Birth Day=" + bDay.toString() + 
	             ", Gender=" + this.gender + "]";
	  }
}
